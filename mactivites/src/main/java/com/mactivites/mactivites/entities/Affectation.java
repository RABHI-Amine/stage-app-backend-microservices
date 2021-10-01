package com.mactivites.mactivites.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="affectations")
@DynamicInsert
@DynamicUpdate
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Affectation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateDebut;

    private Date dateDeFin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("affectations")
    private Role role;

    @ManyToOne
    @JsonIgnoreProperties({"affectations", "employe"})
    private Employe employe;

    @ManyToOne
    @JsonIgnoreProperties({"affectations","projet"})
    private Projet projet;
}
