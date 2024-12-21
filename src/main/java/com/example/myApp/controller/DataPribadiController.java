package com.example.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class DataPribadiController {

    @GetMapping("/data-pribadi")
    public String showPengguna(Model model) {
        return "data-pribadi";
    }
    
}


