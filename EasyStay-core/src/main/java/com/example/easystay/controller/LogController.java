package com.example.easystay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("logs")
public class LogController {

    @GetMapping
    public List<String> getLogs() throws IOException {

        String logFilePath = "logs/app.log";
        return Files.readAllLines(Paths.get(logFilePath));
    }
}
