package com.example.demosb_api_1_1.services;

import com.example.demosb_api_1_1.modele.Cours;
import com.example.demosb_api_1_1.modele.Formateur;
import com.example.demosb_api_1_1.modele.Local;
import com.example.demosb_api_1_1.repositories.CoursRepository;
import com.example.demosb_api_1_1.repositories.FormateurRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;
import java.util.Optional;
@Service
@Transactional(rollbackOn = Exception.class)
public class FormateurServiceImpl implements InterfFormateurService{

    @Autowired
    private FormateurRepository formateurRepository;

    @Override
    public Formateur create(Formateur formateur) throws Exception {
        formateurRepository.save(formateur);
        return formateur;
    }

    @Override
    public Formateur read(Integer id) throws Exception {
        Optional<Formateur> ocf = formateurRepository.findById(id);
        return ocf.get();
    }

    @Override
    public Formateur update(Formateur formateur) throws Exception {
        read(formateur.getId_formateur());
        formateurRepository.save(formateur);
        return formateur;
    }

    @Override
    public void delete(Formateur formateur) throws Exception {
        formateurRepository.deleteById(formateur.getId_formateur());
    }

    @Override
    public List<Formateur> all() throws Exception {
        return formateurRepository.findAll();
    }

    @Override
    public List<Formateur> readNom(String nom) {
        return formateurRepository.findByNom(nom);
    }
}
