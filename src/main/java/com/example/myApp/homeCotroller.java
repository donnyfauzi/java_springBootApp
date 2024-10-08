package com.example.myApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeCotroller {

     @GetMapping("/")
     public String home(Model model) {
         model.addAttribute("message");
         return "home"; // Mengembalikan nama template (home.html)
     }
}
