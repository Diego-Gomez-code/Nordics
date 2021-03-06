package com.proyectoweb.barberia.Users.User.Domain;

import com.proyectoweb.barberia.Users.User.Domain.Exceptions.UserNotExist;
import com.proyectoweb.barberia.Users.User.Domain.Ports.UserRepository;

import java.util.Optional;

public class UserDomainFinder {

    private UserRepository repository;

    public UserDomainFinder(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> execute(String userId) {
        Optional<User> user = repository.find(userId);

        if (user.isEmpty()) {
            throw new UserNotExist("User with id: " + userId + " not exist");
        }

        return user;
    }
}
