package com.vinisolon.workshopmongo.repository;

import com.vinisolon.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> /* <Classe dominio, tipo ID> */ {

    // ?0 = primeiro parametro do método
    // 'i' = opção para aplicar case-insensitive na busca
    @Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String title);

    List<Post> findByTitleContainsIgnoringCase(String title);

    @Query("{ $and : [ " +
            "{ date : { $gte: ?1 } }, " +
            "{ date : { $lte: ?2 } }, " +
            "{ $or : [ " +
            "{ 'title' : { $regex: ?0, $options: 'i' } }, " +
            "{ 'body' : { $regex: ?0, $options: 'i' } }, " +
            "{ 'comments.text' : { $regex: ?0, $options: 'i' } } " +
            "] } " +
            "] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

}
