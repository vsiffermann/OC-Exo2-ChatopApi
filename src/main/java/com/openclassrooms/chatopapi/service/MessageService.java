package com.openclassrooms.chatopapi.service;

import com.openclassrooms.chatopapi.dto.MessageDTO;
import com.openclassrooms.chatopapi.dto.MessageRequestDTO;
import com.openclassrooms.chatopapi.mapper.MessageMapper;
import com.openclassrooms.chatopapi.model.Message;
import com.openclassrooms.chatopapi.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageDTO createMessage(MessageRequestDTO request) {
        Message message = messageMapper.toEntity(request);
        message.setCreatedAt(LocalDateTime.now());
        message.setUpdatedAt(LocalDateTime.now());
        
        Message saved = messageRepository.save(message);
        return messageMapper.toDto(saved);
    }
}
