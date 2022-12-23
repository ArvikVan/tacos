package com.example.tacos.controller;

import com.example.tacos.model.RegistrationForm;
import com.example.tacos.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserRepository userRepos;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepos, PasswordEncoder passwordEncoder) {
        this.userRepos = userRepos;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }
    @PostMapping
    public String processRegistration(RegistrationForm form) {
        userRepos.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
