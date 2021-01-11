package com.mario.api.service;


import com.mario.api.dto.UserDto;
import com.mario.api.entity.User;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto createUser(UserDto userDto);

    UserDto findUserById(String userId) throws Exception;

    void deleteUserByUserId(String userId) throws Exception;

    UserDto updateUser(UserDto userDto);
}
