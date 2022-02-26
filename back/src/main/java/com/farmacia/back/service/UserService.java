package com.farmacia.back.service;

import com.farmacia.back.mapper.UserMapper;
import com.farmacia.back.model.User;
import com.farmacia.back.model.dto.UserInputDTO;
import com.farmacia.back.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserInputDTO login(UserInputDTO userInputDTO) {
        return userMapper.entityToDto(userRepository.findByNameAndPassword(userInputDTO.getName(), userInputDTO.getPassword()));
    }
}
