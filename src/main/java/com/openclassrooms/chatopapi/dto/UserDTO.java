package com.openclassrooms.chatopapi.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String name;
    private LocalDateTime createdAt;
}