package ru.vadim.springboot.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vadim.springboot.model.User;
import ru.vadim.springboot.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public void addUser(User user) {
        repository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        repository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new EntityNotFoundException("Пользователь не найден: " + id);
        }
    }
}
