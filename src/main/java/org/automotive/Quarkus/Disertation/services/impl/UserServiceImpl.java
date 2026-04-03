package org.automotive.Quarkus.Disertation.services.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.automotive.Quarkus.Disertation.exceptions.ResourceNotFoundException;
import org.automotive.Quarkus.Disertation.models.User;
import org.automotive.Quarkus.Disertation.repositories.UserRepository;
import org.automotive.Quarkus.Disertation.services.UserService;

import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.listAll();
    }

    @Override
    public User findById(Long id) {
        return repository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username " + username));
    }

    @Override
    @Transactional
    public User create(User user) {
        repository.persist(user);
        return user;
    }

    @Override
    @Transactional
    public User update(Long id, User user) {
        User existing = findById(id);
        existing.username = user.username;
        existing.password = user.password;
        existing.role = user.role;
        return existing;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}