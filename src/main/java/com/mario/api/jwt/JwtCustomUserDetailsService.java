package com.mario.api.jwt;

import com.mario.api.entity.User;
import com.mario.api.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtCustomUserDetailsService implements UserDetailsService {


    private final UserRepository userRepository;

    public JwtCustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByFirstName(username);
        return new org.springframework.security.core.userdetails.User(user.getFirstName(),user.getPassword(),new ArrayList<>());
    }
}
