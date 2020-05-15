package com.techbek.hyip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage(Model model){
        String welcome = "Welcome to Hyip. Where Dreams come true";
        model.addAttribute("test",welcome);
        return "home";
    }
}
