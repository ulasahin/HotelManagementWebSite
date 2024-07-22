package com.example.easystay.service.rules;


import com.example.easystay.core.exceptionhandling.exception.problemdetails.ErrorMessages;
import com.example.easystay.core.exceptionhandling.exception.types.BusinessException;
import com.example.easystay.model.entity.User;
import com.example.easystay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailBusinessRule {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepository;

    @Value("${email.default}")
    private String EMAIL;

    public void findEmailAndSend(String userEmail,String subject,String body){
        User user = userRepository.findByEmail(userEmail).orElseThrow(
                ()-> new BusinessException(ErrorMessages.EMAIL_NOT_FOUND));
        if(user != null){
            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(user.getEmail());
            message.setSubject(userEmail);
            message.setText(body);
            message.setFrom(EMAIL);

            mailSender.send(message);
        }
    }
}
