package com.example.demosb_api_1_1.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "APILOCAL", schema = "ORA23", catalog = "ORCL.CONDORCET.BE")
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "local_generator")
    @SequenceGenerator(name = "local_generator", sequenceName =
            "APILOCAL_SEQ", allocationSize = 1)
    private Integer id_local;

    private String sigle;

    private Integer places;

    private String descriptions;

    @JsonIgnore
    @OneToMany(mappedBy = "local")
    @ToString.Exclude
    private List<SessionCours> sessionCours;
}
