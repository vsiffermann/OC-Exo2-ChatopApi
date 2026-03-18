package com.openclassrooms.chatopapi.controller;

import com.openclassrooms.chatopapi.dto.MessageRequestDTO;
import com.openclassrooms.chatopapi.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
@Tag(name = "Messages", description = "Message endpoints")
public class MessageController {

    private final MessageService messageService;

    @Operation(summary = "Send a message about a rental")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Message sent with success"),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Map<String, String>> createMessage(@RequestBody MessageRequestDTO request) {
        messageService.createMessage(request);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Message sent with success");
        return ResponseEntity.ok(response);
    }
}
