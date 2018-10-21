package com.tomaszr.blog.security;

//import com.tomaszr.blog.model.entities.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {

    @Getter
    //@Setter
    private final String email;

//    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//        super(username, password, authorities);
//        this.email = null;
//    }
//
//    public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
//        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
//        this.email = null;
//    }

    public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String email) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomUserDetails{" +
                "email='" + email + '\'' +
                "} " + super.toString();
    }
}
