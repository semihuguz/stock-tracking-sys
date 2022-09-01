package com.trackingsys.stocktrackingsys.service;

import com.trackingsys.stocktrackingsys.dto.UserDto;
import com.trackingsys.stocktrackingsys.dto.converter.UserDtoConverter;
import com.trackingsys.stocktrackingsys.model.Order;
import com.trackingsys.stocktrackingsys.model.User;
import com.trackingsys.stocktrackingsys.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }


    public UserDto addUser(User user) {
        return userDtoConverter.convertToDto(userRepository.save(user));
    }

    public List<UserDto> getAllUser() {
        return userDtoConverter.convertToDto(userRepository.findAll());
    }

    public UserDto getByUserId(String userId) {
        return userDtoConverter.convertToDto(userRepository.findById(userId).orElse(null));
    }

    public User deleteByUser(String userId) {
        User user =userRepository.findById(userId).orElse(null);
        userRepository.deleteById(userId);
        return user;
    }

    public UserDto updateByUserId(User user, String userId) {
        User updateUser = userRepository.findById(userId).orElse(null);
        updateUser.setPassword(user.getPassword());
        updateUser.setMail(user.getMail());
        return userDtoConverter.convertToDto(userRepository.save(updateUser));
    }
}
