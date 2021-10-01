package com.mactivites.mactivites.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name="taches")
@DynamicInsert
@DynamicUpdate
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class  Tache {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String etat;


    @ManyToOne
    @JsonIgnoreProperties("taches")
    private Projet projet;

    @ManyToOne
    @JsonIgnoreProperties({"taches","affectations"})
    private Employe employe;

}
