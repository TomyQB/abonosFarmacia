package com.farmacia.back.controller;

import com.farmacia.back.model.dto.UserInputDTO;
import com.farmacia.back.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public UserInputDTO login(@RequestBody UserInputDTO userInputDTO) {
        return userService.login(userInputDTO);
    }
}
