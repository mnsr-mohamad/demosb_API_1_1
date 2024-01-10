package com.example.demosb_api_1_1.repositories;

import com.example.demosb_api_1_1.modele.Cours;
import com.example.demosb_api_1_1.modele.SessionCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface SessionCoursRepository extends JpaRepository<SessionCours, Integer> {

    public List<SessionCours> findSessionCoursByCours(Cours cr);

    public List<SessionCours> findSessionCoursByNbreInscrits(int nbre);

    @Query("SELECT DISTINCT sc FROM SessionCours sc " +
            "JOIN sc.cours c " +
            "WHERE sc.dateDebut <= :dateRecherche " +
            "AND sc.dateFin >= :dateRecherche")
    List<SessionCours> findSessionCoursByDateDebut(@Param("dateRecherche") Date dateRecherche);


}
