package com.example.demosb_api_1_1.modele;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "APISESSIONCOURS", schema = "ORA23", catalog = "ORCL.CONDORCET.BE")
public class SessionCours {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sessioncours_generator")
    @SequenceGenerator(name = "sessioncours_generator", sequenceName = "API_SESSIONCOURS_SEQ", allocationSize = 1)
    @Column(name = "ID_SESSIONCOURS")
    private Integer id_SessionCours;

    @Column(name = "DATEDEBUT")
    @NonNull
    private Date dateDebut;
    @Column(name = "DATEFIN ")
    @NonNull
    private Date dateFin;
    @Column(name = "NBREINSCRITS")
    @NonNull
    private Integer nbreInscrits;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "ID_COURS")
    private Cours cours;

    @NonNull
    @ManyToOne
    @JoinColumn(name="ID_LOCAL")
    private Local local;




}
