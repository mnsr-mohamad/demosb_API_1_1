package com.example.demosb_api_1_1.repositories;

import com.example.demosb_api_1_1.modele.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<Cours,Integer> {
}
