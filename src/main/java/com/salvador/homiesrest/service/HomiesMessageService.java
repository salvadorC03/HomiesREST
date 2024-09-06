/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salvador.homiesrest.service;

import com.salvador.homiesrest.model.HomiesMessage;
import com.salvador.homiesrest.repository.HomiesMessageRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author salvador
 */
@Service
@RequiredArgsConstructor
public class HomiesMessageService {
    private final HomiesMessageRepository repository;
        
    public HomiesMessage sendMessage(String text, String user) {
        var message = HomiesMessage
                .builder()
                .type("text")
                .content(text)
                .author(user)
                .date(LocalDateTime.now())
                .build()
                ;
        
        return repository.save(message);
    }
    
    public HomiesMessage sendVoiceNote(String src, String user) {
        var message = HomiesMessage
                .builder()
                .type("audio")
                .content(src)
                .author(user)
                .date(LocalDateTime.now())
                .build()
                ;
        
        return repository.save(message);
    }
    
    public List<HomiesMessage> getAllMessages() {
        return repository.findAll();
    }
}
