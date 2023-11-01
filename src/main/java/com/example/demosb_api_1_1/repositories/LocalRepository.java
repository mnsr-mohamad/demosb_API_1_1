package com.example.demosb_api_1_1.repositories;

import com.example.demosb_api_1_1.modele.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer> {

}
