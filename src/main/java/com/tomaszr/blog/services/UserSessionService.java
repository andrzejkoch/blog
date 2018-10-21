package com.tomaszr.blog.services;

import com.tomaszr.blog.model.dto.UserDto;
import com.tomaszr.blog.model.entities.User;
import com.tomaszr.blog.repositories.UserRepository;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope(value="sessions",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSessionService {

    @Getter
    private boolean logged;

    @Getter
    private UserDto userDto;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    public boolean loginUser(String userName, String password){
        Optional<User> optionalUser = userRepository.findByUserName(userName);

        if (!optionalUser.isPresent()){
            return false;
        }

        User user = optionalUser.get();

        if (!user.getPassword().equals(password)){
            return false;
        }

        userDto = modelMapper.map(user, UserDto.class);
        logged = true;
        return logged;
    }

}

