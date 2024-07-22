package com.example.easystay.mapper;

import com.example.easystay.model.entity.User;
import com.example.easystay.service.dtos.requests.user.UpdateUserRequest;
import com.example.easystay.service.dtos.responses.user.DeleteUserResponse;
import com.example.easystay.service.dtos.responses.user.ListUserResponse;
import com.example.easystay.service.dtos.responses.user.UpdateUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //Diğer Mapper'lardan farklı olarak update idye göre işlem yaptığı için böyle yapılmalı.
    @Mapping(target = "id", ignore = true)
    User userFromUpdateRequest(UpdateUserRequest request, @MappingTarget User user);

    UpdateUserResponse userFromUpdateResponse(User user);
    DeleteUserResponse userFromDeleteResponse(User user);
    ListUserResponse userFromGetResponse(User user);
}
