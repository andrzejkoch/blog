package com.tomaszr.blog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class postDTO {

    private Long id;
    private String title;
    private String content;
    private Long idOfUser;
    private Date created;


}
