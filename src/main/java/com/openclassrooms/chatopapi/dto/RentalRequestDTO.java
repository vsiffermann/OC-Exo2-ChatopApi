package com.openclassrooms.chatopapi.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RentalRequestDTO {
    private String name;
    private long surface;
    private long price;
    private MultipartFile picture;
    private String description;
}
