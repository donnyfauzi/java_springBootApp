package com.example.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("menu", "dashboard");
        model.addAttribute("pageTitle", "Dashboard");
        model.addAttribute("content", "dashboard.html"); // Mengarahkan konten dashboard
        return "layout-dashboard"; // Menggunakan layout utama dashboard
    }

    @GetMapping("/data-pribadi")
    public String showPengguna(Model model) {
        model.addAttribute("menu", "data-pribadi");
        model.addAttribute("pageTitle", "data-pribadi");
        model.addAttribute("content", "data-pribadi.html"); // Mengarahkan konten pengguna
        return "layout-dashboard"; // Menggunakan layout utama dashboard
    }

    @GetMapping("/pendidikan")
    public String showProduk(Model model) {
        model.addAttribute("menu", "pendidikan");
        model.addAttribute("pageTitle", "pendidikan");
        model.addAttribute("content", "pendidikan.html"); // Mengarahkan konten produk
        return "layout-dashboard"; // Menggunakan layout utama dashboard
    }
}
