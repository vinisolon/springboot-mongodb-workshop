package com.vinisolon.workshopmongo.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Lombok annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
// MongoDB annotations
@Document(collection = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String email;

    // @DBRef -> Referencia outra collection do MongoDB
    // lazy = true -> Não queremos carregar os posts automaticamente quando recuperarmos users da base
    // final -> Não entrar no @AllArgsConstructor
    @DBRef(lazy = true)
    final private List<Post> posts = new ArrayList();

}
