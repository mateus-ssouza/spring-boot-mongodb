package com.mateussouza.workshopmongo.services;

import com.mateussouza.workshopmongo.domain.Post;
import com.mateussouza.workshopmongo.repository.PostRepository;
import com.mateussouza.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> p = repository.findById(id);
        return p.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }
}
