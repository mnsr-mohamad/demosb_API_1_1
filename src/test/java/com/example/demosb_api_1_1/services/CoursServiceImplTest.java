package com.example.demosb_api_1_1.services;

import com.example.demosb_api_1_1.modele.Cours;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoursServiceImplTest {

    @Autowired
    private InterfCoursService coursServiceImpl;

    @Autowired
    private InterfSessionCoursService sessionCoursServiceImpl;

    Cours cr;

    @BeforeEach
    void setUp() {
        try {
            cr = new Cours(null, "NomMatiere", 10,new ArrayList<>());
            coursServiceImpl.create(cr);
            System.out.println("Création du cours : " + cr);
        } catch (Exception e) {
            System.out.println("Erreur de création du cours : " + cr + " Erreur : " + e);
        }
    }

    @AfterEach
    void tearDown() {
        try {
            coursServiceImpl.delete(cr);
            System.out.println("Effacement du cours : " + cr);

        } catch (Exception e) {
            System.out.println("Erreur d'ffacement du cours : " + cr + " Erreur : " + e);
        }
    }

    @Test
    void create() {
        assertNotEquals(0, cr.getId_cours(), "ID du cours non incrémenté");
        assertEquals("NomMatiere", cr.getMatiere(), "Matiere non enregistré");
        assertEquals(10, cr.getHeures(), "Heures non enregistré");
    }

   // @Test()
    void creationDoublon(){   //ajouté
        Cours cr2 = new Cours(null,"NomTest",20,new ArrayList<>());
        Assertions.assertThrows(Exception.class, () -> {
            coursServiceImpl.create(cr2);
        },"création d'un doublon");
    }
    @Test
    void read() {
        try {
            int idcours = cr.getId_cours();
            Cours cr2 = coursServiceImpl.read(idcours);
            assertEquals("NomMatiere", cr2.getMatiere(), "Matiere différentes " + "NomMatiere" + "-" + cr2.getMatiere());
            assertEquals(10, cr2.getHeures(), "Nombre d'heures différents " + "10" + "-" + cr2.getHeures());
        } catch (Exception e) {
            fail("Recherche infructueuse");
        }
    }

    @Test
    void update() {

        try {
            cr.setMatiere("NomMatiere2");
            cr.setHeures(20);
        } catch (Exception e) {
            fail("Erreur de mise à jour " + e);
        }
    }

    @Test
    void delete() {
        try{
            coursServiceImpl.delete(cr);  Assertions.assertThrows(Exception.class, () -> {
                coursServiceImpl.read(cr.getId_cours());
            },"record non effacé");
        }catch (Exception e ){
            fail("Erreur d'affacement "+e);
        }
    }

    @Test
    void all() {

        try{
            List<Cours> lc = coursServiceImpl.all();
            assertNotEquals(0,lc.size(),"La liste ne contient aucun élément");

        }catch (Exception e){
            fail("Erreur de recherche de tous les clients "+e);
        }

    }
}