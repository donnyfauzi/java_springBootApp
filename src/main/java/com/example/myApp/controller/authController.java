package com.example.myApp.controller;

import com.example.myApp.model.User;
import com.example.myApp.service.UserService;

import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public String login(HttpSession session) {
        // Check if user is already logged in
        if (session.getAttribute("user") != null) {
            // If user is already logged in, redirect to the dashboard
            return "redirect:/dashboard";
        }
        // If user is not logged in, show the login page
        return "login";
    }

    @PostMapping("/proses-login")
    public String processLogin(@RequestParam String email, @RequestParam String password, Model model,
            HttpSession session) {
        Optional<User> user = userService.findByEmail(email);

        System.out.println("Email: " + email);
        System.out.println("Password Input: " + password);

        if (user.isPresent()) {
            // Menggunakan passwordEncoder.matches untuk memverifikasi password
            boolean passwordMatch = passwordEncoder.matches(password, user.get().getPassword());
            System.out.println("User Found: " + user.get().getEmail() + ", Password: " + user.get().getPassword());

            if (passwordMatch) {
                // Jika login berhasil, simpan informasi pengguna di dalam session
                session.setAttribute("user", user.get());
                // Jika login berhasil, arahkan ke halaman beranda atau dashboard
                return "redirect:/dashboard";
            }
        }

        // Jika login gagal, kembali ke halaman login dengan pesan error
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }
    
    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getStatus(HttpSession session) {
        User user = (User) session.getAttribute("user"); // Ambil user dari session
        Map<String, Object> response = new HashMap<>();

        if (user != null) {
            // Jika pengguna sedang login
            response.put("isLoggedIn", true);
            response.put("statusText", "Aktif");
            response.put("userName", user.getNama()); // Misalnya untuk menampilkan nama pengguna
        } else {
            // Jika pengguna tidak login
            response.put("isLoggedIn", false);
            response.put("statusText", "Tidak Aktif");
        }

        return ResponseEntity.ok(response);
    }
    
    
}
