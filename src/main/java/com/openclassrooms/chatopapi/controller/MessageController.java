package com.openclassrooms.chatopapi.controller;

import com.openclassrooms.chatopapi.dto.MessageDTO;
import com.openclassrooms.chatopapi.dto.MessageRequestDTO;
import com.openclassrooms.chatopapi.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<Map<String, String>> createMessage(@RequestBody MessageRequestDTO request) {
        messageService.createMessage(request);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Message send with success");
        return ResponseEntity.ok(response);
    }
}
