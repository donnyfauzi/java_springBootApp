package com.example.myApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.myApp.model.DataPribadi;
import com.example.myApp.service.DataPribadiService;

import jakarta.validation.Valid;



@Controller
public class DataPribadiController {

    @Autowired
    private DataPribadiService dataPribadiService;

    @GetMapping("/data-pribadi")
    public String showPengguna(Model model) {
        return "data-pribadi";
    }

    @PostMapping("/save-data-pribadi")
    public String uploadDataPribadi(
            @Valid @ModelAttribute("dataPribadi") DataPribadi dataPribadi,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            // Jika ada error validasi, kembali ke form
            return "data-pribadi";
        }

        // Menyimpan data ke database
        dataPribadiService.saveOrUpdate(dataPribadi);

        // Redirect dengan pesan sukses
        redirectAttributes.addFlashAttribute("successMessage", "Data berhasil di-upload!");
        return "redirect:/data-pribadi";  // Kembali ke halaman dengan pesan
    }
    
}


