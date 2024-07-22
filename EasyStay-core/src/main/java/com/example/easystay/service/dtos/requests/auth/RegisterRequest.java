package com.example.easystay.service.dtos.requests.auth;

import com.example.easystay.core.exceptionhandling.exception.problemdetails.ErrorMessages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = ErrorMessages.NOT_BLANK_FIRST_NAME)
    @Size(min=3,max = 50,message = ErrorMessages.FIRST_NAME_SIZE_3_50)
    private String firstName;

    @NotBlank(message = ErrorMessages.NOT_BLANK_LAST_NAME)
    @Size(min=3,max = 50,message = ErrorMessages.LAST_NAME_SIZE_3_50)
    private String lastName;

    @NotBlank(message = ErrorMessages.INVALID_EMAIL)
    @Email(message = ErrorMessages.INVALID_EMAIL)
    private String email;

    @NotBlank(message = ErrorMessages.NOT_BLANK_PASS)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z]).{6,}$"
            ,message = ErrorMessages.REGEXP_FOR_PASS)
    private String password;

    @NotBlank(message = ErrorMessages.NOT_BLANK_PASS)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z]).{6,}$"
            ,message = ErrorMessages.REGEXP_FOR_PASS)
    private String passwordConfirm;

    @NotBlank(message = ErrorMessages.NOT_BLANK_NUMBER)
    @Pattern(regexp= "\\d+" , message = ErrorMessages.JUST_NUMERIC_CHAR)
    @Size(min = 10,max = 10, message = ErrorMessages.NUMBER_SIZE_10)
    private String phoneNumber;
}
