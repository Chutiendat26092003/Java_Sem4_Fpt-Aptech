package com.example.crudproduct.service.imp;

import com.example.crudproduct.dto.UserDto;
import com.example.crudproduct.entity.User;
import com.example.crudproduct.jpa.exception.UserNotFoundException;
import com.example.crudproduct.mapper.UserMapper;
import com.example.crudproduct.mapper.UserMapperImpl;
import com.example.crudproduct.repository.UserRepository;
import com.example.crudproduct.repository.imp.UserRepositoryImpl;
import com.example.crudproduct.service.UserService;
import org.mapstruct.Mapper;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new UserRepositoryImpl();
    UserMapper mapper = new UserMapperImpl();

    @Override
    public Boolean authenUser(String username, String password) {
        UserDto user = mapper.entityToDto(userRepository.getByUserName(username));
        if(user == null){
            throw new UserNotFoundException("");
        }

        return (user.getUsername().trim().equals(username) && user.getPassword().equals(password));
    }
}
