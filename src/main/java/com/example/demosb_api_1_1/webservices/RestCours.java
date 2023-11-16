package com.example.demosb_api_1_1.webservices;

import com.example.demosb_api_1_1.modele.Cours;
import com.example.demosb_api_1_1.services.InterfCoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RestController
@RequestMapping("/cours")
public class RestCours {

    @Autowired
    private InterfCoursService coursServiceImpl;

    //-------------------Retrouver le cours correspondant à un id donné--------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cours> getCours(@PathVariable(value = "id") int id) throws Exception {
        System.out.println("recherche du cours d' id " + id);
        Cours cours = coursServiceImpl.read(id);
        return new ResponseEntity<>(cours, HttpStatus.OK);
    }

    //-------------------Retrouver les cours avec un nombres d'heures donné--------------------------------------------------------
    @RequestMapping(value = "/heures={heures}", method = RequestMethod.GET)
    public ResponseEntity<List<Cours>> listCoursHeures(@PathVariable(value = "heures") int heures) throws Exception {
        System.out.println("recherche du nombres d'heures " + heures);
        List<Cours> cours;
        cours = coursServiceImpl.readh(heures);
        return new ResponseEntity<>(cours, HttpStatus.OK);
    }

    //-------------------Créer un cours--------------------------------------------------------
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Cours> createCours(@RequestBody Cours cours) throws Exception {
        System.out.println("Création du Cours " + cours.getMatiere());
        coursServiceImpl.create(cours);
        return new ResponseEntity<>(cours, HttpStatus.OK);
    }

    //-------------------Mettre à jour un cours d'un id donné--------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cours> majCours(@PathVariable(value = "id") int id, @RequestBody Cours nouvcours) throws Exception {
        System.out.println("maj du cours id =  " + id);
        nouvcours.setId_cours(id);
        Cours crs = coursServiceImpl.update(nouvcours);
        return new ResponseEntity<>(crs, HttpStatus.OK);
    }

    //-------------------Effacer un cours d'un id donné--------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCours(@PathVariable(value = "id") int id) throws Exception {
        System.out.println("effacement du cours d'id " + id);
        Cours cours = coursServiceImpl.read(id);
        coursServiceImpl.delete(cours);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //-------------------Retrouver tous les  cours  --------------------------------------------------------
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Cours>> listCours() throws Exception {
        System.out.println("recherche de tous les cours");
        return new ResponseEntity<>(coursServiceImpl.all(), HttpStatus.OK);
    }

    //-------------------Gérer les erreurs--------------------------------------------------------
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Void> handleIOException(Exception ex) {
        System.out.println("erreur : " + ex.getMessage());
        return ResponseEntity.notFound().header("error", ex.getMessage()).build();
    }

}
