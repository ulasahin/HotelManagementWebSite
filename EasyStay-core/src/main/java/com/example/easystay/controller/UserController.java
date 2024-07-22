package com.example.easystay.controller;

import com.example.easystay.model.entity.User;
import com.example.easystay.service.abstracts.UserService;
import com.example.easystay.service.dtos.requests.user.AddUserRequest;
import com.example.easystay.service.dtos.requests.user.UpdateUserRequest;
import com.example.easystay.service.dtos.responses.user.AddUserResponse;
import com.example.easystay.service.dtos.responses.user.DeleteUserResponse;
import com.example.easystay.service.dtos.responses.user.ListUserResponse;
import com.example.easystay.service.dtos.responses.user.UpdateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("allUsers")
    @ResponseStatus(HttpStatus.OK)
    public List<ListUserResponse> getAll(){
        return userService.getAll();
    }
    @PostMapping("addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public AddUserResponse add(@RequestBody AddUserRequest request){
        return userService.add(request);
    }
    @GetMapping("myprofile")
    @ResponseStatus(HttpStatus.OK)
    public User getProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userService.getUserByUsername(username);
    }
    @PutMapping("updateUser")
    @ResponseStatus(HttpStatus.OK)
    public UpdateUserResponse update(@RequestBody UpdateUserRequest request){
        return userService.update(request);
    }
    @DeleteMapping("userDelete")
    public DeleteUserResponse delete(@RequestParam long id){
        return userService.delete(id);
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ListUserResponse getById(@RequestParam long id){
        return userService.getById(id);
    }


}
