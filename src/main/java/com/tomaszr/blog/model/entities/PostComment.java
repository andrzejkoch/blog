package com.tomaszr.blog.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //generuje klucz primary w tabeli.
    private Long id;
    private String comment;

    @Embedded
    private AuditEntity auditEntity=new AuditEntity();

    @ManyToOne
    @JoinColumn(name="postId")
    private Post post;


}
