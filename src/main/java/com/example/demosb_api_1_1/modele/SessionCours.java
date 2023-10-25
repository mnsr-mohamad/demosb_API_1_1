package com.example.demosb_api_1_1.modele;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "APISESSIONCOURS", schema = "ORA23", catalog = "ORCL.CONDORCET.BE")
public class SessionCours {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sessioncours_generator")
    @SequenceGenerator(name = "sessioncours_generator", sequenceName = "APISESSIONCOURS_SEQ", allocationSize = 1)
    private Integer id_SessionCours;

    @NonNull
    private LocalDate dateDebut;
    @NonNull
    private LocalDate dateFin;
    @NonNull
    private Integer nbreInscrits;
    @ManyToOne @JoinColumn(name = "ID_COURS")
    private Cours cours;

}
