package com.example.easystay.core.mail;

import com.example.easystay.core.exceptionhandling.exception.types.BusinessException;
import com.example.easystay.model.entity.User;
import com.example.easystay.repository.UserRepository;
import com.example.easystay.service.rules.EmailBusinessRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailBusinessRule emailBusinessRule;

    public void sendEmailToUser(String userEmail,String subject,String body) {

        emailBusinessRule.findEmailAndSend(userEmail,subject,body);
    }
}
