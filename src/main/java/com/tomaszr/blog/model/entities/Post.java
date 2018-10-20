package com.tomaszr.blog.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@NoArgsConstructor

public class Post {
    //id, title, content,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;

    //osadza w tabeli kolumny które sa w klasie AuditEntity. w klasie osadzanej musi być adnotacja @Emeddadable
    @Embedded
    private AuditEntity audit = new AuditEntity();

    @OneToMany(mappedBy = "post")
    private Set<PostComment> comments = new HashSet<>();

}