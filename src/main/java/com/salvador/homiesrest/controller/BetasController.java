/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salvador.homiesrest.controller;

import com.salvador.homiesrest.model.HomiesMessage;
import com.salvador.homiesrest.service.HomiesMessageService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author salvador
 */
@RequiredArgsConstructor
@Controller
@CrossOrigin
public class BetasController {

    private final HomiesMessageService betasService;

    @PostMapping("/sendMessage")
    public RedirectView sendMessage(@RequestParam String text, @RequestParam String author) {
        betasService.sendMessage(text, author);
        return new RedirectView("betas.html");
    }

    @PostMapping("/sendVoiceNote")
    public RedirectView sendVoiceNote(@RequestParam String src, @RequestParam String author) {
        betasService.sendVoiceNote(src, author);
        return new RedirectView("betas.html");
    }

    @GetMapping("/getAllMessages")
    @ResponseBody
    public ResponseEntity<List<HomiesMessage>> getAllMessages() {
        return ResponseEntity.ok(betasService.getAllMessages());
    }
}
