package com.example.astrotalk.controller;

import com.example.astrotalk.dto.SignupUserDto;
import com.example.astrotalk.dto.UserDto;
import com.example.astrotalk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody SignupUserDto signupUserDto){
        return userService.CreateUser(signupUserDto);
    }

}
