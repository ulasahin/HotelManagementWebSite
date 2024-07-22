package com.example.easystay.service.rules;

import com.example.easystay.core.exceptionhandling.exception.problemdetails.ErrorMessages;
import com.example.easystay.core.exceptionhandling.exception.types.BusinessException;
import com.example.easystay.model.entity.User;
import com.example.easystay.repository.UserRepository;
import com.example.easystay.service.dtos.requests.auth.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserBusinessRule {
    @Autowired
    private UserRepository userRepository;

    public void emailShouldNotExist(String email){
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            throw new BusinessException(ErrorMessages.EMAIL_USED);
        }
    }
    public void passwordConfirmation(RegisterRequest request){
        if (!(request.getPassword().equals(request.getPasswordConfirm()))){
            throw new BusinessException(ErrorMessages.NOT_SAME_PASS);
        }
    }
    public void authentication(Authentication authentication){
        if(!authentication.isAuthenticated()){
            throw new BusinessException(ErrorMessages.INVALID_PASS_EMAIL);
        }
    }
}
