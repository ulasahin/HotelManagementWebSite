package com.example.easystay.service.abstracts;

import com.example.easystay.model.entity.User;
import com.example.easystay.service.dtos.requests.user.UpdateUserRequest;
import com.example.easystay.service.dtos.responses.user.AddUserResponse;
import com.example.easystay.service.dtos.responses.user.DeleteUserResponse;
import com.example.easystay.service.dtos.responses.user.ListUserResponse;
import com.example.easystay.service.dtos.requests.user.AddUserRequest;
import com.example.easystay.service.dtos.responses.user.UpdateUserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<ListUserResponse> getAll();
    AddUserResponse add(AddUserRequest request);
    User getUserByUsername(String username);
    UpdateUserResponse update(UpdateUserRequest request);
    DeleteUserResponse delete(long id);
    ListUserResponse getById(long id);
}
