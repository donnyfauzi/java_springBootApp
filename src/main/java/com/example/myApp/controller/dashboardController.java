package com.example.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class dashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Anda bisa menambahkan data model di sini jika perlu
        return "dashboard"; // Mengembalikan nama view untuk dashboard
    }
}
