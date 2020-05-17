package com.techbek.hyip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dashboard/account")
public class DashboardAccountController {

    @GetMapping("")
    public String getAccount(Model model){
        model.addAttribute("docTitle","Account");
        return "dashboard/index";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        model.addAttribute("docTitle","My Profile");
        return "dashboard/account/profile";
    }

    @GetMapping("/email")
    public String getEmailNotif(Model model){
        model.addAttribute("docTitle","Email Notifications");
        return "dashboard/account/email";
    }

    @GetMapping("/password")
    public String getPassword(Model model){
        model.addAttribute("Change Password");
        return "dashboard/account/password";
    }
    @GetMapping("/pin")
    public String getPin(Model model){
        model.addAttribute("Change Pin");
        return "dashboard/account/pin";
    }
}
