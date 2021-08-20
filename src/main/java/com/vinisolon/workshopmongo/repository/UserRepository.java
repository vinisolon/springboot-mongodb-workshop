package com.vinisolon.workshopmongo.repository;

import com.vinisolon.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> /* <Classe dominio, tipo ID> */{
}
