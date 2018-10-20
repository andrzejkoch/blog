package com.tomaszr.blog.model.entities;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Post {
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

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

    public void addComment(PostComment postComment) {
        comments.add(postComment);
        postComment.setPost(this);
    }
}