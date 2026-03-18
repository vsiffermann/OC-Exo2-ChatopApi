package com.openclassrooms.chatopapi.mapper;

import com.openclassrooms.chatopapi.dto.MessageDTO;
import com.openclassrooms.chatopapi.dto.MessageRequestDTO;
import com.openclassrooms.chatopapi.model.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageDTO toDto(Message message);
    Message toEntity(MessageRequestDTO dto);
}
