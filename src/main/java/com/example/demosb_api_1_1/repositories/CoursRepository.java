package com.example.demosb_api_1_1.repositories;

import com.example.demosb_api_1_1.modele.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Repository
public interface CoursRepository extends JpaRepository<Cours,Integer> {

    public List<Cours> findByMatiere(String matiere);

    /*
    @Query(value =" SELECT * FROM APICOURS WHERE HEURES = :hr",nativeQuery =
            true)
    Collection<Cours> findAllHRCours(@Param("hr") Integer hr);*/

    public List<Cours> findByHeures(int heures);

    @Query("SELECT DISTINCT c.matiere FROM Cours c")
    List<String> distinctMatiere();





}
