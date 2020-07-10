package com.jalasoft.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author HP
 * @version 1.1
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private Path filePath = buildFilePath("file");

    @PostMapping
    public String sayHello(@RequestParam(value = "name") String name,
                           @RequestParam(value = "lastName") String lastName,
                           @RequestParam("file") MultipartFile file) {
        try {
            file.transferTo(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Hello " + name + " " + lastName;
    }

    private Path buildFilePath(String name) {
        String home = System.getProperty("user.home");
        return Paths.get(home, name + ".txt");
    }
}
