/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salvador.homiesrest.service;

import static java.lang.System.out;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.salvador.homiesrest.model.HomiesFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author salvador
 */
@Service
public class HomiesFileService {

    String dir = System.getProperty("user.dir") + "/src/main/resources/static/files";

    public Resource downloadFile(String name) throws FileNotFoundException, MalformedURLException {
        var file = new File(dir + "/" + name);
        var resource = new UrlResource(file.toURI());

        if (!resource.exists()) {
            throw new FileNotFoundException("Error loading file named " + name + ": File not found");
        }

        if (!resource.isReadable()) {
            throw new FileNotFoundException("Error loading file named " + name + ": File not readable");
        }

        return resource;
    }

    public String uploadFile(MultipartFile file) throws FileNotFoundException, IOException {
        var path = dir + "/" + file.getOriginalFilename();
        var destinationFile = new File(path);

        file.transferTo(destinationFile);
        out.println("Uploaded new file: " + path);

        return "index.html";
    }

    public HomiesFile[] getAllFiles() throws IOException {
        var paths = Files
                .list(Path.of(dir))
                .sorted()
                .filter(path -> {
                    var file = path.toFile();
                    return !file.isDirectory() && !file.getName().equals(".DS_Store");
                })
                .toArray(Path[]::new);

        var files = new HomiesFile[paths.length];

        for (int i = 0; i < files.length; i++) {
            try {
                var path = paths[i];
                var contentType = Files.probeContentType(path);
                var name = path.toFile().getName();

                var file = HomiesFile
                        .builder()
                        .name(name)
                        .contentType(contentType)
                        .downloadURL("/downloadFile?name=" + name);

                files[i] = file.build();
            } catch (IOException ex) {
                Logger.getLogger(HomiesFileService.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
            }
        }

        return files;
    }
}
