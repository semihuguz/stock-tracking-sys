package com.trackingsys.stocktrackingsys.controller;

import com.trackingsys.stocktrackingsys.dto.OrderDto;
import com.trackingsys.stocktrackingsys.dto.UserDto;
import com.trackingsys.stocktrackingsys.model.Order;
import com.trackingsys.stocktrackingsys.model.User;
import com.trackingsys.stocktrackingsys.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getByUserId(@PathVariable("id")String userId){
        return ResponseEntity.ok(userService.getByUserId(userId));
    }
    @DeleteMapping("/{id}")
    public void deleteByUser(@PathVariable("id")String userId){
        userService.deleteByUser(userId);
    }
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateByUserId(
           @RequestBody User user,
           @PathVariable("id") String userId){
        return ResponseEntity.ok(userService.updateByUserId(user, userId));
    }
}
