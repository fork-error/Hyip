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

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("docTitle", "About Us | Hyip");

        return "about/index";
    }

    @GetMapping("/investment")
    public String investment(Model model){
        model.addAttribute("docTitle", "Investment Plans | Hyip");
        return "investment/index";
    }
}
