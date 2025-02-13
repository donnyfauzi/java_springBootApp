package com.example.myApp.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.myApp.model.DataPribadi;
import com.example.myApp.model.User;
import com.example.myApp.service.DataPribadiService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DataPribadiController {

    @Autowired
    private DataPribadiService dataPribadiService;

    // Helper method to get user from session
    private User getUserFromSession(HttpSession session) throws IllegalStateException {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            System.out.println("User tidak ditemukan di session!");
        }
        return user;
    }

    @GetMapping("/data-pribadi")
    public String showPengguna(HttpSession session, Model model) {
        User user = getUserFromSession(session);
        boolean isDataPribadiUploaded = dataPribadiService.findByUser(user) != null;
        model.addAttribute("isDataPribadiUploaded", isDataPribadiUploaded);
        return "data-pribadi";
    }

    @PostMapping("/save-data-pribadi")
    public String uploadDataPribadi(
        @RequestParam("nama") String nama,
        @RequestParam(value="jenis_kelamin", required = false) String jenisKelamin,
        @RequestParam("tentang_anda") String tentangAnda,
        @RequestParam("alamat") String alamat,
        @RequestParam("tempat_lahir") String tempatLahir,
        @RequestParam(value = "tanggal_lahir", required = false) String tanggalLahir,
        @RequestParam("no_tlp") String noTlp,
        @RequestParam("email") String email,
        @RequestParam(value = "agama", required = false) String agama,
        @RequestParam(value = "status_perkawinan", required = false) String statusPerkawinan,
        @RequestParam("gol_darah") String golDarah,
        @RequestParam("kewarganegaraan") String kewarganegaraan,
        RedirectAttributes redirectAttributes,
        Model model,
        HttpSession session
        
    ) 
    {
        try {
            // mengembalikan nilai input
            model.addAttribute("nama", nama);
            model.addAttribute("jenisKelamin", jenisKelamin);
            model.addAttribute("tentangAnda", tentangAnda);
            model.addAttribute("alamat", alamat);
            model.addAttribute("tempatLahir", tempatLahir);
            model.addAttribute("tanggalLahir", tanggalLahir);
            model.addAttribute("noTlp", noTlp);
            model.addAttribute("email", email);
            model.addAttribute("agama", agama);
            model.addAttribute("statusPerkawinan", statusPerkawinan);
            model.addAttribute("statusPerkawinan", statusPerkawinan);
            model.addAttribute("kewarganegaraan", kewarganegaraan);

            // validasi input
            if (nama == null || nama.trim().isEmpty()) {
                model.addAttribute("errorNama", "Nama tidak boleh kosong !");
                return "data-pribadi"; // Kembali ke halaman dengan pesan error
            }

            if (jenisKelamin == null || jenisKelamin.trim().isEmpty()) {
                model.addAttribute("errorJenisKelamin", "Jenis Kelamin harus diisi !");
                return "data-pribadi";
            }

            if (tentangAnda == null || tentangAnda.trim().isEmpty()) {
                model.addAttribute("errorTentangAnda", "Tentang Anda harus diisi !");
                return "data-pribadi";
            }

            if (alamat == null || alamat.trim().isEmpty()) {
                model.addAttribute("errorAlamat", "Alamat harus diisi !");
                return "data-pribadi";
            }

            if (tempatLahir == null || tempatLahir.trim().isEmpty()) {
                model.addAttribute("errorTempatLahir", "Tempat Lahir harus diisi !");
                return "data-pribadi";
            }

            if (tanggalLahir == null || tanggalLahir.trim().isEmpty()) {
                model.addAttribute("errorTanggalLahir", "Tanggal Lahir harus diisi !");
                return "data-pribadi";
            }

            if (noTlp == null || noTlp.trim().isEmpty()) {
                model.addAttribute("errorNoTlp", "Nomor Tlp harus diisi !");
                return "data-pribadi";
            }

            if (email == null || email.trim().isEmpty()) {
                model.addAttribute("errorEmail", "Email harus diisi !");
                return "data-pribadi";
            }

            if (agama == null || agama.trim().isEmpty()) {
                model.addAttribute("errorAgama", "Agama harus diisi !");
                return "data-pribadi";
            }

            if (statusPerkawinan == null || statusPerkawinan.trim().isEmpty()) {
                model.addAttribute("errorStatusPerkawinan", "Status Perkawinan harus diisi !");
                return "data-pribadi";
            }

            if (golDarah == null || golDarah.trim().isEmpty()) {
                model.addAttribute("errorGolDarah", "Golongan Darah harus diisi !");
                return "data-pribadi";
            }

            if (kewarganegaraan == null || kewarganegaraan.trim().isEmpty()) {
                model.addAttribute("errorKewarganegaraan", "Kewarganegaraan harus diisi !");
                return "data-pribadi";
            }

            User user = getUserFromSession(session);
            // Membuat objek DataPribadi dan mengisinya dengan data dari form
            DataPribadi dataPribadi = new DataPribadi();
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
            dataPribadi.setUser(user);

            // Menyimpan data ke database
            dataPribadiService.saveOrUpdate(dataPribadi);

            // Redirect dengan pesan sukses
            redirectAttributes.addFlashAttribute("successMessage",
                    "Data berhasil disimpan, silahkan isi data lainnya !");
            return "redirect:/data-pribadi"; // Kembali ke halaman yang menampilkan data

        } catch (Exception e) {
            // Tangani error upload dan kirim pesan error ke view
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menyimpan data");
            return "redirect:/data-pribadi";
        }

    }
    
    @GetMapping("/data-pribadi/status")
    public String checkDataPribadiStatus(HttpSession session, Model model) {
        User user = getUserFromSession(session);
        boolean isDataUploaded = dataPribadiService.findByUser(user) != null;

        model.addAttribute("isDataUploaded", isDataUploaded);
        return "data-pribadi";
    }

     
}


