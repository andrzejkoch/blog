package com.tomaszr.blog.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class UserDto {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    private String emaill;


}
