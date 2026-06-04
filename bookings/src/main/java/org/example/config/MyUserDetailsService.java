package org.example.config;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @SuppressWarnings("NullableProblems")
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return User.builder().username(username).authorities("USER").build();
    }
}
