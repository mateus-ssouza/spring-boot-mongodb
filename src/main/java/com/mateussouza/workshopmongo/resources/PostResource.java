package com.mateussouza.workshopmongo.resources;

import com.mateussouza.workshopmongo.domain.Post;
import com.mateussouza.workshopmongo.domain.User;
import com.mateussouza.workshopmongo.dto.UserDTO;
import com.mateussouza.workshopmongo.services.PostService;
import com.mateussouza.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }
}
