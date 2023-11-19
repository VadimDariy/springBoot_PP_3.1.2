package ru.vadim.springboot.service;

import ru.vadim.springboot.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void deleteUserById(Long id);

    void updateUser(User user);

    List<User> findAllUsers();

    User getUserById(Long id);
}
