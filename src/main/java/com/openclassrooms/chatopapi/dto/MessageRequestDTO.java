package com.openclassrooms.chatopapi.dto;

import lombok.Data;

@Data
public class MessageRequestDTO {
    private Integer rentalId;
    private Integer userId;
    private String message;
}
