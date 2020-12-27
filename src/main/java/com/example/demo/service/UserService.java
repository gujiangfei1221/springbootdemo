package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService
{
    User getUserById(long userId);

    List<User> listUser(int page, int pageSize);

}
