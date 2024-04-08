package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    public User findByEmailToAuthenticate(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username);
        if (user == null) {
            log.error("User not found: " + username);
            throw new UsernameNotFoundException("Email not found");
        }
        log.info("User found: " + username);
        return user;
    }
}
