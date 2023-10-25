package com.example.demosb_api_1_1.services;

import com.example.demosb_api_1_1.modele.Cours;

import java.util.List;

public interface InterfCoursService extends InterfService<Cours> {

    public List<Cours> read(String matiere);


}
