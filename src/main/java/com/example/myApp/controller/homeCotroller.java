package com.example.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeCotroller {

     @GetMapping("/")
     public String home() {
         return "home"; 
     }

}
