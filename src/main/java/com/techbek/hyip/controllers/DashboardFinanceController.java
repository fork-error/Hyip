package com.techbek.hyip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dashboard/finance")
public class DashboardFinanceController {

    private static final String DOCTITLE = "docTitle";

    @GetMapping("")
    public String getFinance(Model model){
        model.addAttribute(DOCTITLE,"Make Deposit");
        return "dashboard/finance/make_deposit";
    }

    @GetMapping("/deposit")
    public String makeDeposit(Model model){
        model.addAttribute(DOCTITLE,"Make Deposit");
        return "dashboard/finance/make_deposit";
    }

    @GetMapping("/lists")
    public String getDepositList(Model model){
        model.addAttribute(DOCTITLE,"Deposit Lists");
        return "dashboard/finance/deposit_list";
    }

    @GetMapping("/requests")
    public String getPaymentRequests(Model model){
        model.addAttribute(DOCTITLE,"Payment Requests");
        return "dashboard/finance/payment_requests";
    }

    @GetMapping("/exchange")
    public String getMoneyExchange(Model model){
        model.addAttribute(DOCTITLE,"Exchange Money");
        return "dashboard/finance/exchange_money";
    }
}
