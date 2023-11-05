package com.example.demosb_api_1_1.services;

import com.example.demosb_api_1_1.modele.Cours;
import com.example.demosb_api_1_1.modele.SessionCours;

import java.util.List;

public interface InterfSessionCoursService extends InterfService<SessionCours> {

    public List<SessionCours> getSessionCours(Cours cours);

    public List<SessionCours> rechNbreInscrit(int nbre);



}
