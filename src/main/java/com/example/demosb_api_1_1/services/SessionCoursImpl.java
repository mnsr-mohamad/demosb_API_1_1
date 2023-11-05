package com.example.demosb_api_1_1.services;

import com.example.demosb_api_1_1.modele.Cours;
import com.example.demosb_api_1_1.modele.SessionCours;
import com.example.demosb_api_1_1.repositories.CoursRepository;
import com.example.demosb_api_1_1.repositories.SessionCoursRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
public class SessionCoursImpl implements InterfSessionCoursService {

    @Autowired
    private SessionCoursRepository sessionCoursRepository;
    @Autowired
    private CoursRepository coursRepository;

    @Override
    public SessionCours create(SessionCours sessionCours) throws Exception {
        sessionCoursRepository.save(sessionCours);
        return sessionCours;
    }

    @Override
    public SessionCours read(Integer id) throws Exception {
        return sessionCoursRepository.findById(id).get();
    }

    @Override
    public SessionCours update(SessionCours sessionCours) throws Exception {
        read(sessionCours.getId_SessionCours());
        sessionCoursRepository.save(sessionCours);
        return sessionCours;
    }

    @Override
    public void delete(SessionCours sessionCours) throws Exception {
        sessionCoursRepository.deleteById(sessionCours.getId_SessionCours());
    }

    @Override
    public List<SessionCours> all() throws Exception {
        return sessionCoursRepository.findAll();
    }

    @Override
    public List<SessionCours> getSessionCours(Cours cours) {
       List<SessionCours> lsc = sessionCoursRepository.findSessionCoursByCours(cours);
       return lsc;
    }

    @Override
    public List<SessionCours> rechNbreInscrit(int nbre) {
        return sessionCoursRepository.findSessionCoursByNbreInscrits(nbre);
    }
}
