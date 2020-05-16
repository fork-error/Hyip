package com.techbek.hyip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage(Model model){
        String docTitle = "Welcome to Hyip";
        model.addAttribute("docTitle",docTitle);
        return "home";
    }
}
