package com.example.demosb_api_1_1.webservices;

import com.example.demosb_api_1_1.modele.Cours;
import com.example.demosb_api_1_1.modele.SessionCours;
import com.example.demosb_api_1_1.services.InterfCoursService;
import com.example.demosb_api_1_1.services.InterfSessionCoursService;
import com.example.demosb_api_1_1.services.SessionCoursImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RestController
@RequestMapping("/sessioncours")
public class RestSessionCours {


    @Autowired
    private InterfSessionCoursService sessionCoursServiceImpl;

    //-------------------Retrouver la session qui correspondant à un id donné--------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SessionCours> getSessionCours(@PathVariable(value = "id") int id) throws Exception {
        System.out.println("recherche de la session  d' id " + id);
        SessionCours sessionCours = sessionCoursServiceImpl.read(id);
        return new ResponseEntity<>(sessionCours, HttpStatus.OK);
    }

    //-------------------Retrouver des sessions  avec un nombres d'inscrits donné--------------------------------------------------------
    @RequestMapping(value = "/nbreInscrits={nbreInscrits}", method = RequestMethod.GET)
    public ResponseEntity<List<SessionCours>> listSessionCoursNbreInscrits(@PathVariable(value = "nbreInscrits") int nbreInscrits) throws Exception {
        System.out.println("recherche du nombres d'inscrits " + nbreInscrits);
        List<SessionCours> sessionCours;
        sessionCours = sessionCoursServiceImpl.rechNbreInscrit(nbreInscrits);
        return new ResponseEntity<>(sessionCours, HttpStatus.OK);
    }

    //-------------------Créer une session --------------------------------------------------------
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<SessionCours> createSessionCours(@RequestBody SessionCours sessionCours) throws Exception {
        System.out.println("Création de la session  " );
        sessionCoursServiceImpl.create(sessionCours);
        return new ResponseEntity<>(sessionCours, HttpStatus.OK);
    }

    //-------------------Mettre à jour une session d'un id donné--------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SessionCours> majSessionCours(@PathVariable(value = "id") int id, @RequestBody SessionCours nouvsess) throws Exception {
        System.out.println("maj de la session id =  " + id);
        nouvsess.setId_SessionCours(id);
        SessionCours sc = sessionCoursServiceImpl.update(nouvsess);
        return new ResponseEntity<>(sc, HttpStatus.OK);
    }

    //-------------------Effacer uneqsession d'un id donné--------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSessionCours(@PathVariable(value = "id") int id) throws Exception {
        System.out.println("effacement de la session d'id " + id);
       SessionCours sessionCours = sessionCoursServiceImpl.read(id);
        sessionCoursServiceImpl.delete(sessionCours);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //-------------------Retrouver toutes les sessions  --------------------------------------------------------
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<SessionCours>> listSessionCours() throws Exception {
        System.out.println("recherche de toutes les sessions");
        return new ResponseEntity<>(sessionCoursServiceImpl.all(), HttpStatus.OK);
    }

    //-------------------Gérer les erreurs--------------------------------------------------------
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Void> handleIOException(Exception ex) {
        System.out.println("erreur : " + ex.getMessage());
        return ResponseEntity.notFound().header("error", ex.getMessage()).build();
    }







}
