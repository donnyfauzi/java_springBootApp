package com.example.myApp.repository;

import com.example.myApp.model.DataPribadi;
import com.example.myApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DataPribadiRepository extends JpaRepository<DataPribadi, Long> {
              DataPribadi findByUser(User user);
}
