package com.example.easystay.controller;

import com.example.easystay.core.mail.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mailSendingPanel")
@RequiredArgsConstructor
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public void sendEmail(@RequestParam String userEmail, @RequestParam String subject
            , @RequestParam String body) {
        emailService.sendEmailToUser(userEmail,subject,body);
    }
}
