package com.example.myApp.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.myApp.model.User;
import com.example.myApp.model.DataPribadi;
import com.example.myApp.service.DataPribadiService;



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
        @RequestParam("user_id") Long userId,
            @RequestParam("nama") String nama,
            @RequestParam("jenis_kelamin") String jenisKelamin,
            @RequestParam("tentang_anda") String tentangAnda,
            @RequestParam("alamat") String alamat,
            @RequestParam("tempat_lahir") String tempatLahir,
            @RequestParam("tanggal_lahir") String tanggalLahir,
            @RequestParam("no_tlp") String noTlp,
            @RequestParam("email") String email,
            @RequestParam("agama") String agama,
            @RequestParam("status_perkawinan") String statusPerkawinan,
            @RequestParam("gol_darah") String golDarah,
            @RequestParam("kewarganegaraan") String kewarganegaraan,
            RedirectAttributes redirectAttributes
    ) {
        // Membuat objek DataPribadi dan mengisinya dengan data dari form
        DataPribadi dataPribadi = new DataPribadi();
        dataPribadi.setUser(new User(userId)); // Misal, User sudah ada berdasarkan user_id
        dataPribadi.setNama(nama);
        dataPribadi.setJenisKelamin(jenisKelamin);
        dataPribadi.setTentangAnda(tentangAnda);
        dataPribadi.setAlamat(alamat);
        dataPribadi.setTempatLahir(tempatLahir);
        dataPribadi.setTanggalLahir(LocalDate.parse(tanggalLahir));
        dataPribadi.setNoTlp(noTlp);
        dataPribadi.setEmail(email);
        dataPribadi.setAgama(agama);
        dataPribadi.setStatusPerkawinan(statusPerkawinan);
        dataPribadi.setGolDarah(golDarah);
        dataPribadi.setKewarganegaraan(kewarganegaraan);

        // Menyimpan data ke database
        dataPribadiService.saveOrUpdate(dataPribadi);

        // Redirect dengan pesan sukses
        redirectAttributes.addFlashAttribute("successMessage", "Data berhasil di-upload!");
        return "redirect:/data-pribadi";  // Kembali ke halaman yang menampilkan data

    }
    
}


