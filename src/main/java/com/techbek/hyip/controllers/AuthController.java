package com.techbek.hyip.controllers;

import com.techbek.hyip.dto.LoginDto;
import com.techbek.hyip.dto.RegistrationDto;
import com.techbek.hyip.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Slf4j
@Controller
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("docTitle","Login");
        model.addAttribute("login", new LoginDto());
        return "login/index";
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("docTitle","Register");
        model.addAttribute("user", new RegistrationDto());
        return "register/index";
    }


    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("login") LoginDto loginDto){
        log.info("Trying to authenticate user");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "dashboard/index";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid RegistrationDto registrationDto, BindingResult result){

        if (result.hasErrors()){
            return "register/index";
        }

        userService.registerUser(registrationDto);
        return "redirect:/register/success";


    }

}
