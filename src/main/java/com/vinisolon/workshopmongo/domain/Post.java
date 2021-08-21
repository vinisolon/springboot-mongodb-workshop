package com.vinisolon.workshopmongo.domain;

import com.vinisolon.workshopmongo.dto.AuthorDTO;
import com.vinisolon.workshopmongo.dto.CommentDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Lombok annotations
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
// MongoDB annotations
@Document(collection = "post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    // User aninhado
    private AuthorDTO author;
    // CommentDTO aninhado
    private List<CommentDTO> comments = new ArrayList<>();

    public Post(String id, Date date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

}
