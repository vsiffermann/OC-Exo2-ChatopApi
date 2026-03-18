package com.openclassrooms.chatopapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RentalDTO {
    private Integer id;
    private String name;
    private long surface;
    private long price;
    private String picture;
    private String description;
    @JsonProperty("owner_id")
    private Integer ownerId;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
