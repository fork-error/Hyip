package com.techbek.hyip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dashboard/reports")
public class DashboardReportsController {
    private static final String DOCTITLE = "docTitle";

    @GetMapping("")
    public String getReports(Model model){
        model.addAttribute(DOCTITLE, "Reports");
        return "dashboard/reports/transaction";
    }

    @GetMapping("/transactions")
    public String getReportsList(Model model){
        model.addAttribute(DOCTITLE, "Transaction Lists");
        return "dashboard/reports/transaction";
    }

    @GetMapping("/deposit")
    public String getDeposit(Model model){
        model.addAttribute(DOCTITLE, "Deposit History");
        return "dashboard/reports/deposit";
    }

    @GetMapping("/pending")
    public String getPending(Model model){
        model.addAttribute(DOCTITLE, "Pending History");
        return "dashboard/reports/pending";
    }

    @GetMapping("/exchange")
    public String getExchange(Model model){
        model.addAttribute(DOCTITLE, "Reports");
        return "dashboard/reports/exchange";
    }

    @GetMapping("/earning")
    public String getEarning(Model model){
        model.addAttribute(DOCTITLE, "Earning History");
        return "dashboard/reports/earning";
    }
}
