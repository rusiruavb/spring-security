package com.example.security.service;

import com.example.security.domain.Role;
import com.example.security.domain.User;
import com.example.security.repository.RoleRepository;
import com.example.security.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements IUserService{
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public User saveUser(User user) {
        log.info("Saving a new user {} to the database", user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void assignRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        log.info("Assigning new role {} to the user {}", role.getName(), user.getUsername());
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetch user from the database");
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetch all users from the database");
        return userRepository.findAll();
    }
}
