package com.openclassrooms.chatopapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDTO {

    private String token;
    private Integer id;
    private String email;
    private String name;

}