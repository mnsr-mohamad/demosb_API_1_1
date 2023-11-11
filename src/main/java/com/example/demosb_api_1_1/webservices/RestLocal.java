package com.example.demosb_api_1_1.webservices;

import com.example.demosb_api_1_1.modele.Cours;
import com.example.demosb_api_1_1.modele.Local;
import com.example.demosb_api_1_1.services.InterfCoursService;
import com.example.demosb_api_1_1.services.InterfLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RestController
@RequestMapping("/local")
public class RestLocal {


    @Autowired
    private InterfLocalService localServiceImpl;

    //-------------------Retrouver le local correspondant à un id donné--------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Local> getLocal(@PathVariable(value = "id") int id) throws Exception {
        System.out.println("recherche du local d' id " + id);
        Local local = localServiceImpl.read(id);
        return new ResponseEntity<>(local, HttpStatus.OK);
    }

    //-------------------Retrouver les locaux avec un nombres de places donné--------------------------------------------------------
    @RequestMapping(value = "/places={places}", method = RequestMethod.GET)
    public ResponseEntity<List<Local>> listLocalPlaces(@PathVariable(value = "places") int places) throws Exception {
        System.out.println("recherche du nombres de places  " + places);
        List<Local> local;
        local = localServiceImpl.readPlaces(places);
        return new ResponseEntity<>(local, HttpStatus.OK);
    }

    //-------------------Créer un local--------------------------------------------------------
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Local> createLocal(@RequestBody Local local) throws Exception {
        System.out.println("Création du Local " + local.getSigle());
        localServiceImpl.create(local);
        return new ResponseEntity<>(local, HttpStatus.OK);
    }

    //-------------------Mettre à jour un local d'un id donné--------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Local> majLocal(@PathVariable(value = "id") int id, @RequestBody Local nouvlocal) throws Exception {
        System.out.println("maj du local id =  " + id);
        nouvlocal.setId_local(id);
        Local lcl = localServiceImpl.update(nouvlocal);
        return new ResponseEntity<>(lcl, HttpStatus.OK);
    }

    //-------------------Effacer un local d'un id donné--------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteLocal(@PathVariable(value = "id") int id) throws Exception {
        System.out.println("effacement du local d'id " + id);
        Local local = localServiceImpl.read(id);
        localServiceImpl.delete(local);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //-------------------Retrouver tous les  locaux  --------------------------------------------------------
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Local>> listLocal() throws Exception {
        System.out.println("recherche de tous les locaux");
        return new ResponseEntity<>(localServiceImpl.all(), HttpStatus.OK);
    }

    //-------------------Gérer les erreurs--------------------------------------------------------
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Void> handleIOException(Exception ex) {
        System.out.println("erreur : " + ex.getMessage());
        return ResponseEntity.notFound().header("error", ex.getMessage()).build();
    }














}
