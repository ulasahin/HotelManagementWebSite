package com.example.easystay.service.dtos.responses.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUserResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
