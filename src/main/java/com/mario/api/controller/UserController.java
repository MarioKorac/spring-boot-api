package com.mario.api.controller;

import com.mario.api.dto.UserDto;
import com.mario.api.request.UserRequest;
import com.mario.api.response.UserResponse;
import com.mario.api.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private static final ModelMapper model = new ModelMapper();

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }


    //METHODS



    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserResponse> getAllUsers() {

        List<UserResponse> returnValue = new ArrayList<>();
        List<UserDto> usersDto = userService.findAll();
        for (UserDto userDto : usersDto){
            UserResponse userResponse = model.map(userDto,UserResponse.class);
            returnValue.add(userResponse);
        }
        return returnValue;
    }


    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse createUser(@RequestBody UserRequest userRequest) {


        UserDto userDto = model.map(userRequest,UserDto.class);

        userService.createUser(userDto);

        UserResponse returnValue = model.map(userDto,UserResponse.class);

        return returnValue;

    }


    @GetMapping(value = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse findUserById(@PathVariable String userId) {

        UserDto userDto = userService.findUserById(userId);
        UserResponse returnValue = model.map(userDto,UserResponse.class);

        return returnValue;
    }


    @DeleteMapping("/users/{userId}")
    public String deleteUserById(@PathVariable String userId) {

        userService.deleteUserByUserId(userId);
        return "User with id " + userId + " was deleted!";
    }


    @PutMapping(value = "/users/{userId}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse updateUser(@RequestBody UserRequest userRequest, @PathVariable String userId){

        UserDto userDto = new UserDto();
        userDto = model.map(userRequest,UserDto.class);
        userDto.setUserId(userId);
        userDto = userService.updateUser(userDto);

        UserResponse returnValue = model.map(userDto,UserResponse.class);

        return returnValue;

    }

}
