package com.example.easystay.service.concretes;

import com.example.easystay.core.exceptionhandling.exception.problemdetails.ErrorMessages;
import com.example.easystay.core.exceptionhandling.exception.types.BusinessException;
import com.example.easystay.mapper.UserMapper;
import com.example.easystay.model.entity.User;
import com.example.easystay.repository.UserRepository;
import com.example.easystay.service.abstracts.UserService;
import com.example.easystay.service.dtos.requests.user.UpdateUserRequest;
import com.example.easystay.service.dtos.responses.user.AddUserResponse;
import com.example.easystay.service.dtos.responses.user.DeleteUserResponse;
import com.example.easystay.service.dtos.responses.user.ListUserResponse;
import com.example.easystay.service.dtos.requests.user.AddUserRequest;
import com.example.easystay.service.dtos.responses.user.UpdateUserResponse;
import com.example.easystay.service.rules.UserBusinessRule;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserBusinessRule userBusinessRule;

    @Override
    public List<ListUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(u -> new ListUserResponse(u.getFirstName(),u.getLastName(),u.getEmail())).toList();
    }

    @Override
    public AddUserResponse add(AddUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRole(request.getRole());
        userBusinessRule.emailShouldNotExist(request.getEmail());

        userRepository.save(user);
        AddUserResponse responses = new AddUserResponse();
        responses.setLastName(user.getLastName());
        responses.setFirstName(user.getFirstName());
        return responses;
    }
    @Override
    public UpdateUserResponse update(UpdateUserRequest request) {
        User user = userRepository.findById(request.getId()).orElseThrow(()
                -> new BusinessException(ErrorMessages.USER_NOT_FOUND));

        userBusinessRule.emailShouldNotExist(request.getEmail());

        UserMapper.INSTANCE.userFromUpdateRequest(request,user);

        user = userRepository.save(user);
        UpdateUserResponse response = UserMapper.INSTANCE.userFromUpdateResponse(user);
        return response;
    }

    @Override
    public DeleteUserResponse delete(long id) {
        User user = userRepository.findById(id).orElseThrow(()
                -> new BusinessException(ErrorMessages.USER_NOT_FOUND));
        DeleteUserResponse response = UserMapper.INSTANCE.userFromDeleteResponse(user);
        userRepository.delete(user);
        return response;
    }

    @Override
    public ListUserResponse getById(long id) {
        User user = userRepository.findById(id).orElseThrow(()
                -> new BusinessException(ErrorMessages.USER_NOT_FOUND));
        ListUserResponse response = UserMapper.INSTANCE.userFromGetResponse(user);
        return response;
    }

    @Override
    public User getUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(ErrorMessages.USER_NOT_FOUND_FOR_EMAIL + email));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       return userRepository.findByEmail(email).orElseThrow();
    }
}
