package com.spring.faltdor.api.demoapijwt.service;

import com.spring.faltdor.api.demoapijwt.repository.ApplicationUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final ApplicationUserRepository applicationUserRepository;

    public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserRepository.findByUsername(username)
                .map(applicationUser -> (UserDetails) new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList()))
                .orElseThrow(()-> new UsernameNotFoundException(username));
    }
}
