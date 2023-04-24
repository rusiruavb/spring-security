package com.example.security.service;

import com.example.security.domain.Role;
import com.example.security.domain.User;

import java.util.List;

public interface IUserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void assignRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
