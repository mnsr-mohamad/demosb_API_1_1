package com.example.demosb_api_1_1.webservices;

import com.example.demosb_api_1_1.modele.Cours;
import com.example.demosb_api_1_1.modele.Formateur;
import com.example.demosb_api_1_1.services.InterfCoursService;
import com.example.demosb_api_1_1.services.InterfFormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RestController
@RequestMapping("/formateur")
public class RestFormateur {

    @Autowired
    private InterfFormateurService formateurServiceImpl;

    //-------------------Retrouver le formateur correspondant à un id donné--------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Formateur> getFormateur(@PathVariable(value = "id") int id) throws Exception {
        System.out.println("recherche du formateur d' id " + id);
        Formateur formateur = formateurServiceImpl.read(id);
        return new ResponseEntity<>(formateur, HttpStatus.OK);
    }

    //-------------------Retrouver les formateurs avec un nom donné--------------------------------------------------------
    @RequestMapping(value = "/nom={nom}", method = RequestMethod.GET)
    public ResponseEntity<List<Formateur>> listFormateurNom(@PathVariable(value = "nom") String nom) throws Exception {
        System.out.println("recherche du nom  " + nom);
        List<Formateur> formateurs;
        formateurs = formateurServiceImpl.readNom(nom);
        return new ResponseEntity<>(formateurs, HttpStatus.OK);
    }

    //-------------------Créer un formateur--------------------------------------------------------
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Formateur> createFormateur(@RequestBody Formateur formateur) throws Exception {
        System.out.println("Création du Formateur " + formateur.getNom());
        formateurServiceImpl.create(formateur);
        return new ResponseEntity<>(formateur, HttpStatus.OK);
    }

    //-------------------Mettre à jour un formateur d'un id donné--------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Formateur> majFormateur(@PathVariable(value = "id") int id, @RequestBody Formateur nouvform) throws Exception {
        System.out.println("maj du formateur id =  " + id);
        nouvform.setId_formateur(id);
        Formateur form = formateurServiceImpl.update(nouvform);
        return new ResponseEntity<>(form, HttpStatus.OK);
    }

    //-------------------Effacer un formateur d'un id donné--------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteFormateur(@PathVariable(value = "id") int id) throws Exception {
        System.out.println("effacement du formateur d'id " + id);
        Formateur form = formateurServiceImpl.read(id);
        formateurServiceImpl.delete(form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //-------------------Retrouver tous les  formateurs  --------------------------------------------------------
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Formateur>> listFormateur() throws Exception {
        System.out.println("recherche de tous les formateurs");
        return new ResponseEntity<>(formateurServiceImpl.all(), HttpStatus.OK);
    }

    //-------------------Gérer les erreurs--------------------------------------------------------
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Void> handleIOException(Exception ex) {
        System.out.println("erreur : " + ex.getMessage());
        return ResponseEntity.notFound().header("error", ex.getMessage()).build();
    }




}
