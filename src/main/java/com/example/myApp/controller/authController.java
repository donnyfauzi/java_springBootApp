package com.example.myApp.controller;

import com.example.myApp.model.user;
import com.example.myApp.service.userService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class authController {
    @Autowired
    private userService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/proses-login")
    public String processLogin(@RequestParam String email, @RequestParam String password, Model model) {
        Optional<user> user = userService.findByEmail(email);

        System.out.println("Email: " + email);
        System.out.println("Password Input: " + password);
        
        if (user.isPresent()) {
            System.out.println("User Found: " + user.get().getEmail() + ", Password: " + user.get().getPassword());
        }
        
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            // Jika login berhasil, arahkan ke halaman beranda atau dashboard
            return "redirect:/dashboard";
        } else {
            // Jika login gagal, kembali ke halaman login dengan pesan error
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
    
    
}
