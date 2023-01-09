package com.mateussouza.workshopmongo.services;

import com.mateussouza.workshopmongo.domain.User;
import com.mateussouza.workshopmongo.repository.UserRepository;
import com.mateussouza.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> u = repository.findById(id);
        return u.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }
}
