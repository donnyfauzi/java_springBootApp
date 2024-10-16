package com.example.myApp.controller;

import com.example.myApp.model.User;
import com.example.myApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register"; // Tampilkan halaman registrasi
    }

    @PostMapping("/proses-register")
    public String processRegister(
        @RequestParam String email,
        @RequestParam String nama,
        @RequestParam String password,
        Model model
    ) {
        // Cek apakah email sudah terdaftar
        Optional<User> existingUser = userService.findByEmail(email);
        if (existingUser.isPresent()) {
            model.addAttribute("error", "Email already registered");
            return "register";
        }

        // Buat objek user baru
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setNama(nama);
        newUser.setPassword(password);

        // Panggil service untuk menyimpan user baru
        userService.registerUser(newUser);

        return "redirect:/login"; // Redirect ke halaman login setelah berhasil register
    }
}
