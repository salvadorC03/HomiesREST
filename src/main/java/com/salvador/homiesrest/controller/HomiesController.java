/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salvador.homiesrest.controller;

import com.salvador.homiesrest.service.HomiesFileService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import com.salvador.homiesrest.model.HomiesFile;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author salvador
 */
@Controller
@CrossOrigin
@RequiredArgsConstructor
public class HomiesController {

    private final HomiesFileService homiesFileService;

    @GetMapping("/downloadFile")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@RequestParam String name) throws FileNotFoundException, MalformedURLException {
        return ResponseEntity.ok(homiesFileService.downloadFile(name));
    }

    @GetMapping("/getAllFiles")
    @ResponseBody
    public ResponseEntity<HomiesFile[]> getAllFilesHandler() throws IOException {
        return ResponseEntity.ok(homiesFileService.getAllFiles());
    }

    @PostMapping("/homies")
    public RedirectView uploadFileHandler(@RequestParam MultipartFile file) throws FileNotFoundException, IOException {
        return new RedirectView(homiesFileService.uploadFile(file));
    }
}
