package com.vinisolon.workshopmongo.resources;

import com.vinisolon.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User test = new User("1", "Vinicius", "vini@email.com");
        User test2 = new User("2", "Cleiton", "cleitin@email.com");

        List<User> users = new ArrayList<>(Arrays.asList(test, test2));

        return ResponseEntity.ok().body(users);
    }
}
