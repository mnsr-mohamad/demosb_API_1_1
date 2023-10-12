package com.example.demosb_api_1_1.modele;

import java.time.LocalDate;

public class SessionCours {


    private int id_SessionCours;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private int nbreInscrits;

    private Cours cours;


    public SessionCours(int id_SessionCours, LocalDate dateDebut, LocalDate dateFin, int nbreInscrits, Cours cours) {
        this.id_SessionCours = id_SessionCours;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbreInscrits = nbreInscrits;
        this.cours = cours;
    }

    public SessionCours(int idSessionCours, LocalDate dateDebut, LocalDate dateFin, int nbreInscrit) {
        this.id_SessionCours = idSessionCours;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbreInscrits = nbreInscrit;

    }

    public int getId_SessionCours() {
        return id_SessionCours;
    }

    public void setId_SessionCours(int id_SessionCours) {
        this.id_SessionCours = id_SessionCours;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbreInscrits() {
        return nbreInscrits;
    }

    public void setNbreInscrits(int nbreInscrits) {
        this.nbreInscrits = nbreInscrits;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
}
