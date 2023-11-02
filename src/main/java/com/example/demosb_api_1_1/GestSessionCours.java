package com.example.demosb_api_1_1;

import com.example.demosb_api_1_1.modele.Cours;
import com.example.demosb_api_1_1.modele.Local;
import com.example.demosb_api_1_1.modele.SessionCours;
import com.example.demosb_api_1_1.services.InterfCoursService;
import com.example.demosb_api_1_1.services.InterfSessionCoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sessioncours")
public class GestSessionCours {

    @Autowired
    private InterfSessionCoursService sessionCoursService;

    @Autowired
    private InterfCoursService coursService;

    @RequestMapping("/rechercheParCours")
    public String read(@RequestParam int idcours, Map<String, Object> model){
        System.out.println("Recherche du cours n° " + idcours);
        try {
            Cours cr = coursService.read(idcours);
           /* Local lc = new Local(null, "M22", 19, "Moyenne Classe", new ArrayList<>());
            SessionCours sc = new SessionCours(LocalDate.now(),LocalDate.now().plusDays(10),20,cr,lc);
            sessionCoursService.create(sc);
            List<SessionCours> lsc = sessionCoursService.getSessionCours(cr);
            model.put("moncours",cr);
            model.put("sesscours",lsc);*/
            List<SessionCours> lsc = sessionCoursService.getSessionCours(cr);
            model.put("moncours",cr);
            model.put("sesscours",lsc);
        }
        catch (Exception e){
            System.out.println("----------erreur lors de la recherche -------- " + e);
            model.put("error", e.getMessage());
            return "error";
        }
        return "affsesscours";
    }



}
