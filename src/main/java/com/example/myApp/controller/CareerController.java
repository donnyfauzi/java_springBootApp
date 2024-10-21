package com.example.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CareerController {

     @GetMapping("/career")
     public String career(Model model) {
         return "career"; 
     }

}