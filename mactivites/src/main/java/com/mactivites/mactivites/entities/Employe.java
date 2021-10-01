package com.mactivites.mactivites.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name="employes")
@DynamicInsert
@DynamicUpdate
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Employe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private String numeroTelephone;
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "employe")
    @JsonIgnoreProperties("employe")
    private Collection<Tache> taches;

    @OneToMany(mappedBy = "employe",cascade = CascadeType.ALL)
    private Collection<Affectation> affectations;

}
