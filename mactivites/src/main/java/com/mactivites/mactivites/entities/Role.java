package com.mactivites.mactivites.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="roles")
@DynamicInsert
@DynamicUpdate
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String designation;
    private String abreviation;

    @OneToMany(mappedBy = "role",cascade = {CascadeType.ALL})
    private Collection<Affectation> affectations;
}
