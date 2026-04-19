package com.pathforge.backend.controller;

import com.pathforge.backend.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/chat")
    public String chat(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        if (message == null || message.isEmpty()) {
            return "Please provide a message.";
        }
        return chatService.getChatResponseV1(message);
    }

    @PostMapping("/v2/chat")
    public Flux<String> chatFlux(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        if (message == null || message.isEmpty()) {
            return Flux.just("Please provide a message.");
        }
        return chatService.getChatResponse(message);
    }
}
