package com.example.myApp.service;

import com.example.myApp.model.DataPribadi;
import com.example.myApp.repository.DataPribadiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataPribadiService {
          @Autowired
    private DataPribadiRepository dataPribadiRepository;

    // Menyimpan atau memperbarui data pribadi
    public DataPribadi saveOrUpdate(DataPribadi dataPribadi) {
        return dataPribadiRepository.save(dataPribadi);
    }

    // Mendapatkan semua data pribadi
    public List<DataPribadi> getAllDataPribadi() {
        return dataPribadiRepository.findAll();
    }

    // Mendapatkan data pribadi berdasarkan ID
    public Optional<DataPribadi> getDataPribadiById(Long id) {
        return dataPribadiRepository.findById(id);
    }

    // Menghapus data pribadi berdasarkan ID
    public void deleteDataPribadiById(Long id) {
        dataPribadiRepository.deleteById(id);
    }
          
}
