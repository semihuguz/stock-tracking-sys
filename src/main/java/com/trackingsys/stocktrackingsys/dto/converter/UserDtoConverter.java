package com.trackingsys.stocktrackingsys.dto.converter;

import com.trackingsys.stocktrackingsys.dto.UserDto;
import com.trackingsys.stocktrackingsys.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {
 public UserDto convertToDto(User user){
     return UserDto.builder()
             .mail(user.getMail())
             .password(user.getPassword())
             .creationDate(LocalDateTime.now(ZoneId.of("Africa/Addis_Ababa")))
             .build();
 }
 public List<UserDto> convertToDto(List<User> users){
     return users.stream()
             .map(this::convertToDto)
             .collect(Collectors.toList());
 }
}
