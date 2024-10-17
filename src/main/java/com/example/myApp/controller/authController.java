package com.example.myApp.controller;

import com.example.myApp.model.User;
import com.example.myApp.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/proses-login")
    public String processLogin(@RequestParam String email, @RequestParam String password, Model model) {
        Optional<User> user = userService.findByEmail(email);

        System.out.println("Email: " + email);
        System.out.println("Password Input: " + password);
        
        if (user.isPresent()) {
            // Menggunakan passwordEncoder.matches untuk memverifikasi password
            boolean passwordMatch = passwordEncoder.matches(password, user.get().getPassword());
            System.out.println("User Found: " + user.get().getEmail() + ", Password: " + user.get().getPassword());

            if (passwordMatch) {
                // Jika login berhasil, arahkan ke halaman beranda atau dashboard
                return "redirect:/dashboard";
            }
        }
        
        // Jika login gagal, kembali ke halaman login dengan pesan error
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }
    
    
}
