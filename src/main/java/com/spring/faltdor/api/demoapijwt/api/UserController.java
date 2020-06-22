package com.spring.faltdor.api.demoapijwt.api;

import com.spring.faltdor.api.demoapijwt.data.ApplicationUser;
import com.spring.faltdor.api.demoapijwt.repository.ApplicationUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final ApplicationUserRepository applicationUserRepository;
    private final BCryptPasswordEncoder cryptPasswordEncoder;

    public UserController(ApplicationUserRepository applicationUserRepository, BCryptPasswordEncoder cryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.cryptPasswordEncoder = cryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser applicationUser){
        applicationUser.setPassword(cryptPasswordEncoder.encode(applicationUser.getPassword()));
        applicationUserRepository.save(applicationUser);
    }
}
