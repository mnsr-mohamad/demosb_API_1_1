package com.example.demosb_api_1_1.repositories;

import com.example.demosb_api_1_1.modele.Cours;
import com.example.demosb_api_1_1.modele.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer> {

    public List<Local> findByPlaces(int places);
    public List<Local> findBySigle(String sigle);
}
