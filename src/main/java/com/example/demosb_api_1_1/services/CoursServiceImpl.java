package com.example.demosb_api_1_1.services;

import com.example.demosb_api_1_1.modele.Cours;
import com.example.demosb_api_1_1.repositories.CoursRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackOn = Exception.class)
public class CoursServiceImpl implements InterfCoursService {

    @Autowired
    private CoursRepository coursRepository;

    @Override
    public List<Cours> read(String matiere) {
        return coursRepository.findByMatiere(matiere);
    }

    @Override
    public List<Cours> readh(int heures) {
        return coursRepository.findByHeures(heures);
    }

    @Override
    public List<String> getAllMatiere() {
        /*List<Cours> coursList = coursRepository.findAll();
        List<String> matieres = coursList.stream()
                .map(Cours::getMatiere)
                .distinct()
                .collect(Collectors.toList());*/
        return coursRepository.distinctMatiere();

    }



    @Override
    public Cours create(Cours cours) throws Exception {
        coursRepository.save(cours);
        return cours;
    }

    @Override
    public Cours read(Integer id) throws Exception {
        Optional<Cours> ocr = coursRepository.findById(id);
        return ocr.get();
    }

    @Override
    public Cours update(Cours cours) throws Exception {
       read(cours.getId_cours());
       coursRepository.save(cours);
       return cours;
    }

    @Override
    public void delete(Cours cours) throws Exception {

        coursRepository.deleteById(cours.getId_cours());
    }

    @Override
    public List<Cours> all() throws Exception {
        return coursRepository.findAll();
    }
}
