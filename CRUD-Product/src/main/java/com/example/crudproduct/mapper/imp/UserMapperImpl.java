package com.example.crudproduct.mapper.imp;

import com.example.crudproduct.dto.ProductDto;
import com.example.crudproduct.dto.UserDto;
import com.example.crudproduct.entity.Product;
import com.example.crudproduct.entity.User;
import com.example.crudproduct.mapper.UserMapper;

public class UserMapperImpl implements UserMapper {
    @Override
    public User dtoEntity(UserDto userDto) {
        return new User();
    }

    @Override
    public UserDto entityToDto(User user) {
        return new UserDto();
    }
}
