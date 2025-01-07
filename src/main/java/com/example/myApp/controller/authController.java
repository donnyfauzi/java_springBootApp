package com.example.myApp.controller;

import com.example.myApp.model.User;
import com.example.myApp.service.UserService;

import jakarta.servlet.http.HttpSession;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
public String processLogin(@RequestParam String email, 
                           @RequestParam String password, 
                           Model model, 
                           HttpSession session, 
                           RedirectAttributes redirectAttributes) {
    // Validasi input
    if (email.isEmpty() || password.isEmpty()) {
        redirectAttributes.addFlashAttribute("error", "Email dan Password harus diisi!");
        return "redirect:/login";
    }

    // Mencari user berdasarkan email
    Optional<User> user = userService.findByEmail(email);

    // Logging untuk debugging
    System.out.println("Email: " + email);
    System.out.println("Password Input: " + password);

    if (user.isPresent()) {
        boolean passwordMatch = passwordEncoder.matches(password, user.get().getPassword());

        // Debugging informasi user
        System.out.println("User Found: " + user.get().getEmail() + ", Password (hashed): " + user.get().getPassword());

        if (passwordMatch) {
            // Jika login berhasil, simpan user ke dalam session
            session.setAttribute("user", user.get());
            System.out.println("Login Berhasil, User: " + user.get().getEmail());

            // Arahkan ke halaman dashboard
            return "redirect:/dashboard";
        } else {
            System.out.println("Password tidak cocok!");
        }
    } else {
        System.out.println("User dengan email " + email + " tidak ditemukan!");
    }

    // Jika login gagal, beri pesan error dan arahkan kembali ke halaman login
    redirectAttributes.addFlashAttribute("error", "Email atau Password salah!");
    return "redirect:/login";
}

    
    // @GetMapping("/status")
    // public ResponseEntity<Map<String, Object>> getStatus(HttpSession session) {
    //     User user = (User) session.getAttribute("user"); // Ambil user dari session
    //     Map<String, Object> response = new HashMap<>();

    //     if (user != null) {
    //         // Jika pengguna sedang login
    //         response.put("isLoggedIn", true);
    //         response.put("statusText", "Aktif");
    //         response.put("userName", user.getNama()); // Misalnya untuk menampilkan nama pengguna
    //     } else {
    //         // Jika pengguna tidak login
    //         response.put("isLoggedIn", false);
    //         response.put("statusText", "Tidak Aktif");
    //     }

    //     return ResponseEntity.ok(response);
    // }
    
    
}
