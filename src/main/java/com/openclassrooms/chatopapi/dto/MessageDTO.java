package com.openclassrooms.chatopapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MessageDTO {
    private Integer id;
    @JsonProperty("rental_id")
    private Integer rentalId;
    @JsonProperty("user_id")
    private Integer userId;
    private String message;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
