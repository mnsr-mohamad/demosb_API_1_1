package com.example.demosb_api_1_1.services;

import com.example.demosb_api_1_1.modele.Cours;
import com.example.demosb_api_1_1.modele.Local;
import com.example.demosb_api_1_1.modele.SessionCours;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SessionCoursImplTest {

    private Cours cr;

    private SessionCours sc;

    private Local loc;

    @Autowired
    private CoursServiceImpl coursServiceImpl;

    @Autowired
    private SessionCoursImpl sessionCoursImpl;

    @Autowired
    private LocalServiceImpl localServiceImpl;

    @BeforeEach
    void setUp() {
        try{
            cr = new Cours(null,"Matiere2",10,new ArrayList<>());

            coursServiceImpl.create(cr);
            System.out.println("Création du cours : "+cr);

            loc = new Local(null,"M22",19,"Moyenne Classe", new ArrayList<>());
            localServiceImpl.create(loc);
            System.out.println("Création du local : "+loc);

            sc = new SessionCours(LocalDate.now(),LocalDate.now().plusDays(20),20,cr,loc);
            sessionCoursImpl.create(sc);
            System.out.println("Création de la session : "+sc);


        }
        catch (Exception e){
            System.out.println("Erreur de création de sessions de cours "+e);
        }
    }

    @AfterEach
    void tearDown() {
        try{
            sessionCoursImpl.delete(sc);
        }
        catch (Exception e){
            System.out.println("Erreur d'effacement de session "+e);
        }
        try{
            coursServiceImpl.delete(cr);
        }
        catch (Exception e){
            System.out.println("Erreur d'effacement du cours "+e);
        }
        try{
            localServiceImpl.delete(loc);
        }
        catch (Exception e){
            System.out.println("Erreur d'effacement du local "+e);
        }

    }

    @Test
    void create() {

        assertNotEquals(0,sc.getId_SessionCours(),"numéro  de sessions non incrémenté ");
        assertEquals(LocalDate.now(),sc.getDateDebut(),"Date différentes " + sc.getDateDebut() + " et "+ LocalDate.now());
    }

    @Test
    void read() {
        try{
            int numsc=sc.getId_SessionCours();
            SessionCours sc2 = sessionCoursImpl.read(numsc);
            assertEquals(20,sc2.getNbreInscrits(),"Nombre d'inscrits différents");
        }
        catch (Exception e ){
            fail("Recherche infructueuse"+e);
        }
    }

    @Test
    void update() {
        try{
           sc.setDateDebut(LocalDate.now().plusDays(10));
           sc = sessionCoursImpl.update(sc);
           assertEquals(sc.getDateDebut(),LocalDate.now().plusDays(10),"Date début différentes "+ sc.getDateDebut()+" - "+LocalDate.now().plusDays(10));
        }
        catch (Exception e ){
            fail("Erreur de mise à jour");
        }
    }

    @Test
    void delete() {

        try{
            sessionCoursImpl.delete(sc);
            Assertions.assertThrows(Exception.class, () -> {
               sessionCoursImpl.read(sc.getId_SessionCours());
            },"record non effacé");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void affCollection() {

        try{
            Collection<SessionCours> lsc = sessionCoursImpl.getSessionCours(cr);
            boolean trouve = false;
            for(SessionCours s : lsc){
                if(s.getId_SessionCours().equals(sc.getId_SessionCours())){
                    trouve=true;
                    break;
                }
            }
            assertTrue(trouve,"session absente de la liste des cours");
        }
        catch (Exception e ){
            fail("Erreur de recherche");

        }
    }

}