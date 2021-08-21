package com.vinisolon.workshopmongo.dto;

import com.vinisolon.workshopmongo.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AuthorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public AuthorDTO(User user) {
        id = user.getId();
        name = user.getName();
    }

}
