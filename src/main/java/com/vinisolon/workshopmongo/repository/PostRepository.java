package com.vinisolon.workshopmongo.repository;

import com.vinisolon.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> /* <Classe dominio, tipo ID> */ {
}
