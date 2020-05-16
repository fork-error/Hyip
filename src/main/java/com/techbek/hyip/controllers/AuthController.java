package com.techbek.hyip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("docTitle","Login");
        return "login/index";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("docTitle","Register");
        return "register/index";
    }
}
