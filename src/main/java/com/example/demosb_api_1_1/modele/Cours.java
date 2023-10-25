package com.example.demosb_api_1_1.modele;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
@ToString
@Entity
@Table(name = "APICOURS", schema = "ORA23", catalog = "ORCL.CONDORCET.BE")
public class Cours {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cours_generator")
    @SequenceGenerator(name="cours_generator", sequenceName =
            "APICOURS_SEQ", allocationSize=1)
    private Integer id_cours;

    @NonNull
    private String matiere;

    @NonNull
    private Integer heures;



    //private List<SessionCours> session = new ArrayList<>();

}
