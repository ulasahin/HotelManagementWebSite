package com.example.easystay.service.dtos.requests.payment;

import com.example.easystay.core.exceptionhandling.exception.problemdetails.ErrorMessages;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @NotNull
    @Min(4)
    private Long amount;

    @Email(message = ErrorMessages.INVALID_EMAIL)
    private String email;

    @NotBlank
    @Size(min = 5, max = 200)
    private String productName;
}
