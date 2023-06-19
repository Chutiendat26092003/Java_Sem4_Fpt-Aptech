package com.example.crudproduct.mapper;

import com.example.crudproduct.dto.ProductDto;
import com.example.crudproduct.dto.UserDto;
import com.example.crudproduct.entity.Product;
import com.example.crudproduct.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User dtoEntity(UserDto userDto);
    UserDto entityToDto (User user);
}
