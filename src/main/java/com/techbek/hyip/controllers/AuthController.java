package com.techbek.hyip.controllers;

import com.techbek.hyip.dto.LoginDto;
import com.techbek.hyip.dto.RegistrationDto;
import com.techbek.hyip.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("docTitle","Login");
        return "login/index";
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("docTitle","Register");
        return "register/index";
    }


    @PostMapping
    public void login(@Valid @RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @PostMapping
    public void register(@Valid @RequestBody RegistrationDto registrationDto){
        userService.registerUser(registrationDto);

    }

}
