package com.techbek.hyip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard/referrals")
public class DashboardReferralsController {

    private static final String DOCTITLE = "docTitle";

    @GetMapping("")
    public String getReferrals(Model model){
        model.addAttribute(DOCTITLE,"Referrals");
        return "dashboard/referrals/index";
    }

    @GetMapping("/all")
    public String getReferralsList(Model model){
        model.addAttribute(DOCTITLE,"All Referals");
        return "dashboard/referrals/index";
    }

    @GetMapping("/banners")
    public String getBanners(Model model){
        model.addAttribute(DOCTITLE,"promotional Banners");
        return "dashboard/referrals/promotionals";
    }

    @GetMapping("/earnings")
    public String getFinance(Model model){
        model.addAttribute(DOCTITLE,"Referral Earning");
        return "dashboard/referrals/earnings";
    }
}
