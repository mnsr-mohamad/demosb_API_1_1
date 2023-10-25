package com.example.demosb_api_1_1.repositories;

import com.example.demosb_api_1_1.modele.Cours;
import com.example.demosb_api_1_1.modele.SessionCours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface SessionCoursRepository extends JpaRepository<SessionCours, Integer> {

    public List<SessionCours> findSessionCoursByCours(Cours cr);

    public List<SessionCours> findSessionCoursByDateDebut(Date dd);
}
