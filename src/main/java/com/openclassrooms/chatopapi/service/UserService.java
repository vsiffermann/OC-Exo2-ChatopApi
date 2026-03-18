package com.openclassrooms.chatopapi.service;

import com.openclassrooms.chatopapi.dto.UserDTO;
import com.openclassrooms.chatopapi.mapper.UserMapper;
import com.openclassrooms.chatopapi.model.User;
import com.openclassrooms.chatopapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO getUserById(Integer id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }

    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }
}
