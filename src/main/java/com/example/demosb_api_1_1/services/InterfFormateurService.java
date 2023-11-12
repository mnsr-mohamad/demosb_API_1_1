package com.example.demosb_api_1_1.services;

import com.example.demosb_api_1_1.modele.Formateur;
import com.example.demosb_api_1_1.modele.Local;

import java.util.List;

public interface InterfFormateurService extends InterfService<Formateur>{

    public List<Formateur> readNom(String nom );
}
