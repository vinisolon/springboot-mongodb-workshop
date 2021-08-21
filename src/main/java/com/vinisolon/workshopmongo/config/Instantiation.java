package com.vinisolon.workshopmongo.config;

import com.vinisolon.workshopmongo.domain.Post;
import com.vinisolon.workshopmongo.domain.User;
import com.vinisolon.workshopmongo.dto.AuthorDTO;
import com.vinisolon.workshopmongo.repository.PostRepository;
import com.vinisolon.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        // Remove tudo das collections do MongoDB
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        // Adiciona os users na collection do MongoDB
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        // Necessário salvar os users antes de instanciar os dtos para criação dos posts, para eles obterem o ID

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!",
                "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!",
                "Acordei feliz hoje!", new AuthorDTO(maria));

        // Adiciona os posts na collection do MongoDB
        postRepository.saveAll(Arrays.asList(post1, post2));
    }

}
