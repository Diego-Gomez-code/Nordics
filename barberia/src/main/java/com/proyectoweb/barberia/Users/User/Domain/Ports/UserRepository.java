package com.proyectoweb.barberia.Users.User.Domain.Ports;

import com.proyectoweb.barberia.Users.User.Domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    Optional<User> find(String userId);

    void update(String userId, User user);

    Optional<List<User>> all();
}
