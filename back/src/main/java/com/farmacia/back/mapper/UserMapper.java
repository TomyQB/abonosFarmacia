package com.farmacia.back.mapper;

import java.util.List;

import com.farmacia.back.model.User;
import com.farmacia.back.model.dto.UserInputDTO;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

// @Mapper(componentModel = "spring")
@Service
public class UserMapper /*extends IMapper<User, UserInputDTO>*/ {
    
    // User dtoToEntity(UserInputDTO dto);
    public UserInputDTO entityToDto(User entity) {
        if(entity == null) return null;
        
        UserInputDTO userInputDTO = new UserInputDTO();

        userInputDTO.setName(entity.getName());
        userInputDTO.setPassword(entity.getPassword());

        return userInputDTO;
    }

    // List<User> dtosToEntities(List<UserInputDTO> dtos);
    // List<UserInputDTO> entitiesToDtos(List<User> dtos);
    
}
