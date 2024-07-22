package com.example.easystay.core.exceptionhandling.exception.problemdetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails{
    private List<String> errors;

    public ValidationProblemDetails(List<String> errors){
        setDetail("One or more validaton errors");
        setType("ValidationException");
        setTitle("Validation Rule Violation");
        this.errors=errors;
    }
}
