package com.example.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        return "users-profile"; // Menggunakan layout utama dashboard
    }

    @GetMapping("/data-pribadi")
    public String showPengguna(Model model) {
        return "data-pribadi"; // Menggunakan layout utama dashboard
    }

   
}
