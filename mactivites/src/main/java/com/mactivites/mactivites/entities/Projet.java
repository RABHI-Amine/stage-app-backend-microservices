package com.mactivites.mactivites.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name="projets")
@DynamicInsert
@DynamicUpdate
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Projet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateLivraison;
    private String nomClient;

    @OneToMany(mappedBy = "projet",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("projet")
    private Collection<Tache> taches;

    @OneToMany(mappedBy = "projet",cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Affectation> affectations;

}
