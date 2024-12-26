package com.example.myApp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_data_pribadi")
public class DataPribadi {
    
          @Id
          @GeneratedValue(strategy = GenerationType.IDENTITY)
          private Long id;

          @ManyToOne
          @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
          private User user;

          @Column(name = "nama")
          private String nama;

          @Column(name = "jenis_kelamin")
          private String jenisKelamin;

          @Column(name = "tentang_anda")
          private String tentangAnda;
          
          @Column(name = "alamat")
          private String alamat;

          @Column(name = "tempat_lahir")
          private String tempatLahir;

          @Column(name = "tanggal_lahir")
          private LocalDate tanggalLahir;

          @Column(name = "no_tlp")
          private String noTlp;

          @Column(name = "email")
          private String email;

          @Column(name = "agama")
          private String agama;

          @Column(name = "status_perkawinan")
          private String statusPerkawinan;

          @Column(name = "gol_darah")
          private String golDarah;

          @Column(name = "kewarganegaraan")
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

          public User getUser() {
          return user;
          }

          public void setUser(User user) {
          this.user = user;
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
