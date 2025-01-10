/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salvador.homiesrest.controller;

import com.salvador.homiesrest.model.HomiesMessage;
import com.salvador.homiesrest.service.HomiesMessageService;
import com.salvador.homiesrest.service.MessageRequestBody;
import com.salvador.homiesrest.service.VoiceNoteRequestBody;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author salvador
 */
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class BetasController {

    private final HomiesMessageService betasService;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public HomiesMessage sendMessage(@RequestBody MessageRequestBody body) {
        return betasService.sendMessage(body.getText(), body.getAuthor());
    }

    @MessageMapping("/sendVoiceNote")
    @SendTo("/topic/messages")
    public HomiesMessage sendVoiceNote(@RequestBody VoiceNoteRequestBody body) {
        return betasService.sendVoiceNote(body.getSrc(), body.getAuthor());
    }

    @GetMapping("/getAllMessages")
    public ResponseEntity<List<HomiesMessage>> getAllMessages() {
        return ResponseEntity.ok(betasService.getAllMessages());
    }
}
