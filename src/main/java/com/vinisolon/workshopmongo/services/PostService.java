package com.vinisolon.workshopmongo.services;

import com.vinisolon.workshopmongo.domain.Post;
import com.vinisolon.workshopmongo.repository.PostRepository;
import com.vinisolon.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    // Comentado para testar a busca com @Query
//    public List<Post> findByTitle(String title) {
//        return repository.findByTitleContainsIgnoringCase(title);
//    }

    // Busca utilizando o @Query
    public List<Post> findByTitle(String title) {
        return repository.searchTitle(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); // Somando 1 dia na maxDate
        return repository.fullSearch(text, minDate, maxDate);
    }

}
