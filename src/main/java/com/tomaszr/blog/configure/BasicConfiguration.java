package com.tomaszr.blog.configure;

import com.tomaszr.blog.model.dto.PostDto;
import com.tomaszr.blog.model.entities.Post;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BasicConfiguration {
@Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Post.class, PostDto.class)
                .addMapping(pst -> pst.getUser().getId(),PostDto::setIdOfUser)
                .addMapping(p -> p.getAudit().getAdded(),PostDto::setCreated);
        return modelMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
