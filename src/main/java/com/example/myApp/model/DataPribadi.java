package com.example.myApp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_data_pribadi")
public class DataPribadi {
    
          @Id
          @GeneratedValue(strategy = GenerationType.IDENTITY)
          private Long id;

          @Column(name = "nama")
          @NotEmpty(message = "Nama tidak boleh kosong!")
          private String nama;

          @Column(name = "jenis_kelamin")
          @NotEmpty(message = "Jenis Kelamin tidak boleh kosong!")
          private String jenisKelamin;

          @Column(name = "tentang_anda")
          @NotEmpty(message = "Tentang Anda tidak boleh kosong!")
          private String tentangAnda;
          
          @Column(name = "alamat")
          @NotEmpty(message = "Alamat tidak boleh kosong!")
          private String alamat;

          @Column(name = "tempat_lahir")
          @NotEmpty(message = "Tempat Lahir tidak boleh kosong!")
          private String tempatLahir;

          @Column(name = "tanggal_lahir")
          @NotNull(message = "Tanggal Lahir tidak boleh kosong!")
          private LocalDate tanggalLahir;

          @Column(name = "no_tlp")
          @NotEmpty(message = "Nomor Telepon tidak boleh kosong!")
          private String noTlp;

          @Column(name = "email")
          @NotEmpty(message = "Email tidak boleh kosong!")
          private String email;

          @Column(name = "agama")
          @NotEmpty(message = "Agama tidak boleh kosong!")
          private String agama;

          @Column(name = "status_perkawinan")
          @NotEmpty(message = "Status Perkawinan tidak boleh kosong!")
          private String statusPerkawinan;

          @Column(name = "gol_darah")
          @NotEmpty(message = "Golongan Darah tidak boleh kosong!")
          private String golDarah;

          @Column(name = "kewarganegaraan")
          @NotEmpty(message = "Kewarganegaraan tidak boleh kosong!")
          private String kewarganegaraan;

          @Column(name = "created_at", updatable = false)
          private LocalDateTime createdAt = LocalDateTime.now();

          // Getter dan Setter
          public Long getId() {
          return id;
          }

          public void setId(Long id) {
          this.id = id;
          }

          public String getNama() {
          return nama;
          }

          public void setNama(String nama) {
          this.nama = nama;
          }

          public String getJenisKelamin() {
          return jenisKelamin;
          }

          public void setJenisKelamin(String jenisKelamin) {
          this.jenisKelamin = jenisKelamin;
          }

          public String getTentangAnda() {
          return tentangAnda;
          }

          public void setTentangAnda(String tentangAnda) {
          this.tentangAnda = tentangAnda;
          }

          public String getAlamat() {
          return alamat;
          }

          public void setAlamat(String alamat) {
          this.alamat = alamat;
          }

          public String getTempatLahir() {
          return tempatLahir;
          }

          public void setTempatLahir(String tempatLahir) {
          this.tempatLahir = tempatLahir;
          }

          public LocalDate getTanggalLahir() {
          return tanggalLahir;
          }

          public void setTanggalLahir(LocalDate tanggalLahir) {
          this.tanggalLahir = tanggalLahir;
          }

          public String getNoTlp() {
          return noTlp;
          }

          public void setNoTlp(String noTlp) {
          this.noTlp = noTlp;
          }

          public String getEmail() {
          return email;
          }

          public void setEmail(String email) {
          this.email = email;
          }

          public String getAgama() {
          return agama;
          }

          public void setAgama(String agama) {
          this.agama = agama;
          }

          public String getStatusPerkawinan() {
          return statusPerkawinan;
          }

          public void setStatusPerkawinan(String statusPerkawinan) {
          this.statusPerkawinan = statusPerkawinan;
          }

          public String getGolDarah() {
          return golDarah;
          }

          public void setGolDarah(String golDarah) {
          this.golDarah = golDarah;
          }

          public String getKewarganegaraan() {
          return kewarganegaraan;
          }

          public void setKewarganegaraan(String kewarganegaraan) {
          this.kewarganegaraan = kewarganegaraan;
          }

          public LocalDateTime getCreatedAt() {
          return createdAt;
          }

          public void setCreatedAt(LocalDateTime createdAt) {
          this.createdAt = createdAt;
          }

}
