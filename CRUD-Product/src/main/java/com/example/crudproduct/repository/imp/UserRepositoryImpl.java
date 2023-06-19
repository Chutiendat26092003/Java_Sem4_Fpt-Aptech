package com.example.crudproduct.repository.imp;

import com.example.crudproduct.entity.User;
import com.example.crudproduct.jpa.iml.JpaExecutorImpl;
import com.example.crudproduct.repository.UserRepository;

public class UserRepositoryImpl extends JpaExecutorImpl<User> implements UserRepository {
    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public User getByUserName(String userName){
        return super.getByField("username", userName);
    }
}
