package com.example.easystay.mapper;

import com.example.easystay.model.entity.User;
import com.example.easystay.service.dtos.requests.auth.LoginRequest;
import com.example.easystay.service.dtos.requests.auth.RegisterRequest;
import com.example.easystay.service.dtos.responses.auth.LoginResponse;
import com.example.easystay.service.dtos.responses.auth.RegisterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthMapper {
    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    RegisterResponse responseFromRegisterResponse(User user);
}
