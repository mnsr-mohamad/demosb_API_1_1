package com.example.demosb_api_1_1;


import com.example.demosb_api_1_1.modele.Cours;
import com.example.demosb_api_1_1.modele.SessionCours;
import com.example.demosb_api_1_1.repositories.CoursRepository;
import com.example.demosb_api_1_1.repositories.SessionCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/cours")
public class GestCours {
    @Autowired     //instanciation "automatique" par le framework avec les paramètres indiqués, il s'agit d'un singleton
    //CoursDAO coursDAO;
    CoursRepository coursRepository;
    SessionCoursRepository sessionCoursRepository;

    @RequestMapping("/tous")
    public String affTous(Map<String, Object> model) {
        System.out.println("recherche cours");
        List<Cours> liste;
        try {
            //liste= coursDAO.readall();
            liste = coursRepository.findAll();
            model.put("mesCours", liste);
        } catch (Exception e) {
            System.out.println("----------erreur lors de la recherche-------- " + e);
            return "error";
        }
        return "affichagetousCours";
    }


    @RequestMapping("/selection")
    String selection(@RequestParam("numcours") int numcours, Map<String, Object> model) {
        Cours cr = null;
        Optional<Cours> ocr;
        try {
            //cr = coursDAO.readCours(numcours);
            ocr = coursRepository.findById(numcours);
            if (ocr.isPresent()) {
                cr = ocr.get();
            }
            else{
                throw new Exception("Client inconnu");
            }

            model.put("monCours", cr);

        } catch (Exception e) {
            System.out.println("erreur lors de la lecture " + e);
            model.put("error", e);
            return "error";
        }
        return "affCours";  // page html à développer
    }

    @RequestMapping("/create")
    public String create(@RequestParam String matiere,@RequestParam int
            heures,@RequestParam  Map<String, Object> model){
        System.out.println("création de cours");
        Cours cr = new Cours(matiere,heures);
        try {
            coursRepository.save(cr);//mise à jour du cours avec son id

            System.out.println(cr);
            Collection<Cours> lcr= coursRepository.findAll();
            model.put("nouvcours",cr);
            model.put("mesCours", lcr);
        } catch (Exception e) {
            System.out.println("----------erreur lors de la création------- - " + e);
                    model.put("error",e.getMessage());
            return "error";
        }
        return "nouveauCours";
    }


    @RequestMapping("/selectionNom")
    String selection(@RequestParam("matiere") String matiere, Map<String, Object> model) {
        List<Cours> lc;
        try {
            lc = coursRepository.findByMatiere(matiere);
            model.put("monCours", lc);

        } catch (Exception e) {
            System.out.println("erreur lors de la lecture " + e);
            model.put("error", e);
            return "error";
        }
        return "affCoursNom";


    }

    @RequestMapping("/selectionHR")
    String selectionByHR(@RequestParam("hr") int hr, Map<String, Object> model) {
        Collection<Cours> lc;

        try {
            //lc = coursRepository.findAllHRCours(hr);
            lc = coursRepository.findByHeures(hr);
            model.put("monCours", lc);

        } catch (Exception e) {
            System.out.println("erreur lors de la lecture " + e);
            model.put("error", e);
            return "error";
        }
        return "affCoursHR";


    }




}
