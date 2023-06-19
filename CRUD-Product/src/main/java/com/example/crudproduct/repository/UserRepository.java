package com.example.crudproduct.repository;

import com.example.crudproduct.entity.User;

public interface UserRepository {
    User getByUserName(String username);
}
