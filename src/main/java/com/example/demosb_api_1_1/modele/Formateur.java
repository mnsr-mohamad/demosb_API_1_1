package com.example.demosb_api_1_1.modele;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "APIFORMATEUR ", schema = "ORA23", catalog = "ORCL.CONDORCET.BE")
public class Formateur {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "formateur_generator")
    @SequenceGenerator(name="formateur_generator", sequenceName =
            "APIFORMATEUR_SEQ", allocationSize=1)

    private Integer id_formateur;

    @NonNull
    private String mail;
    @NonNull
    private String nom;
    @NonNull
    private String prenom;

}
