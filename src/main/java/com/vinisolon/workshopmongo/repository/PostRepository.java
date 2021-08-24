package com.vinisolon.workshopmongo.repository;

import com.vinisolon.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> /* <Classe dominio, tipo ID> */ {

    // ?0 = primeiro parametro do método
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String title);

    List<Post> findByTitleContainsIgnoringCase(String title);

}
