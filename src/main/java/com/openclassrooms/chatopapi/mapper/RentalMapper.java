package com.openclassrooms.chatopapi.mapper;

import com.openclassrooms.chatopapi.dto.RentalDTO;
import com.openclassrooms.chatopapi.dto.RentalRequestDTO;
import com.openclassrooms.chatopapi.model.Rental;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RentalMapper {
    
    @Mapping(target = "picture", ignore = true)
    Rental toEntity(RentalRequestDTO dto);
    
    RentalDTO toDto(Rental rental);
    
    @Mapping(target = "picture", ignore = true)
    void updateEntityFromDto(RentalRequestDTO dto, @MappingTarget Rental rental);
}
