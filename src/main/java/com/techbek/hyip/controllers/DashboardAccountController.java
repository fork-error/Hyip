package com.techbek.hyip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardAccountController {

    @GetMapping("/account/profile")
    public String profile(Model model){
        model.addAttribute("docTitle","My Profile");
        return "dashboard/account/profile";
    }

    @GetMapping("/account/email")
    public String getEmailNotif(Model model){
        model.addAttribute("docTitle","Email Notifications");
        return "dashboard/account/email";
    }


}
