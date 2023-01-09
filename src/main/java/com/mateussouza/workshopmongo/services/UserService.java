package com.mateussouza.workshopmongo.services;

import com.mateussouza.workshopmongo.domain.User;
import com.mateussouza.workshopmongo.dto.UserDTO;
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

    public User insert(User obj) {
        return repository.insert(obj);
    }


    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
