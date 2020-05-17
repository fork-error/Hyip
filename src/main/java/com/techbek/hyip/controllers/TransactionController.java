package com.techbek.hyip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionController {

    @GetMapping("/dashboard/transfer")
    public String transferFund(Model model){
        model.addAttribute("docTitle","Transfer Funds");
        return "dashboard/transfer_fund";
    }
}
