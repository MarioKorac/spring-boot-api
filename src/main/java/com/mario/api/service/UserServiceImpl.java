package com.mario.api.service;

import com.mario.api.dto.TodoDto;
import com.mario.api.errors.ErrorMessages;
import com.mario.api.dto.UserDto;
import com.mario.api.entity.User;
import com.mario.api.exceptions.RepositoryServiceException;
import com.mario.api.exceptions.UserServiceException;
import com.mario.api.repository.UserRepository;
import com.mario.api.utils.GenerateUserId;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    private static final ModelMapper model = new ModelMapper();

    private GenerateUserId generateUserId;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,GenerateUserId generateUserId){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.generateUserId = generateUserId;

    }

    //METHODS

    @Override
    public List<UserDto> findAll() {

        List<User> users = userRepository.findAll();

        if (users.size() == 0) {
            throw new RepositoryServiceException(ErrorMessages.LIST_IS_EMPTY.getErrorMessage());
        }

        List<UserDto> returnValue = new ArrayList<>();
        for (User user : users){
            UserDto UserDto = model.map(user, com.mario.api.dto.UserDto.class);
            returnValue.add(UserDto);
        }

        return returnValue;
    }

    @Override
    public UserDto createUser(UserDto userDto) throws UserServiceException {

        if (userDto.getEmail().isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

        User checkUser = userRepository.findByEmail(userDto.getEmail());
        if (checkUser != null){
            throw new UserServiceException(ErrorMessages.RECORD_ALREADY_EXIST.getErrorMessage());
        }

        for (int i = 0; i < userDto.getTodos().size() ; i++) {
            TodoDto todoDto = userDto.getTodos().get(i);
            todoDto.setUser(userDto);
            todoDto.setTodoId(generateUserId.generateString());
            userDto.getTodos().set(i,todoDto);

        }


        User user = model.map(userDto,User.class);


        user.setUserId(generateUserId.generateString());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);

        UserDto returnValue = model.map(user,UserDto.class);


        return returnValue;
    }


    @Override
    public UserDto findUserById(String userId) throws RepositoryServiceException {

        UserDto userDto = new UserDto();

        try {
            User userEntity = userRepository.findByUserId(userId);
            userDto = model.map(userEntity,UserDto.class);

        }catch (Exception e){
            throw new RepositoryServiceException(ErrorMessages.RECORD_DOES_NOT_EXIST.getErrorMessage());
        }

        return userDto;
    }


    @Override
    public void deleteUserByUserId(String userId) throws UserServiceException {

        try {
            User user = userRepository.findByUserId(userId);
            userRepository.delete(user);
        }catch (Exception e){
            throw new UserServiceException(ErrorMessages.RECORD_DOES_NOT_EXIST.getErrorMessage());
        }

    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        if (userDto.getEmail().isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

        User user = userRepository.findByUserId(userDto.getUserId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAge(userDto.getAge());

        userRepository.save(user);
        userDto = model.map(user,UserDto.class);

        return userDto;


    }
}
