package com.example.myApp.repository;

import com.example.myApp.model.DataPribadi;
import com.example.myApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DataPribadiRepository extends JpaRepository<DataPribadi, Long> {
      List<DataPribadi> findByUser(User user);          
}
