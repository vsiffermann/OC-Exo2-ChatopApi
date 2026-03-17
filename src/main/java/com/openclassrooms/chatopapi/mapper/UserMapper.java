package com.openclassrooms.chatopapi.mapper;

import com.openclassrooms.chatopapi.dto.UserDTO;
import com.openclassrooms.chatopapi.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
    User toEntity(UserDTO dto);
}