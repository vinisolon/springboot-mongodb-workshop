package com.vinisolon.workshopmongo.services;

import com.vinisolon.workshopmongo.domain.Post;
import com.vinisolon.workshopmongo.repository.PostRepository;
import com.vinisolon.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post not found."));
    }

    public List<Post> findByTitle(String title) {
        return repository.findByTitleContainsIgnoringCase(title);
    }

}
