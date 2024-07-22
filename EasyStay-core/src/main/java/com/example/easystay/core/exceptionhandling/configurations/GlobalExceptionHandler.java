package com.example.easystay.core.exceptionhandling.configurations;

import com.example.easystay.core.exceptionhandling.exception.problemdetails.ProblemDetails;
import com.example.easystay.core.exceptionhandling.exception.problemdetails.ValidationProblemDetails;
import com.example.easystay.core.exceptionhandling.exception.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handleRunTimeException(BusinessException exception){
        return new ProblemDetails("Business Rule Violation", exception.getMessage(), "BusinessException");
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception){
        List<String> errorMessages = new ArrayList<>();
        List<FieldError> errors = exception.getBindingResult().getFieldErrors();
        for(FieldError error : errors){
            errorMessages.add(error.getDefaultMessage());
        }
        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails(errorMessages);
        return validationProblemDetails;
    }
}
