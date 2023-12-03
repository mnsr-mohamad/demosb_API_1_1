package com.example.demosb_api_1_1.services;

import com.example.demosb_api_1_1.modele.Cours;
import com.example.demosb_api_1_1.modele.Local;
import com.example.demosb_api_1_1.modele.SessionCours;

import java.util.List;

public interface InterfLocalService extends InterfService<Local>{
    public List<Local> readPlaces(int places);

    public List<Local> read(String sigle);
}
