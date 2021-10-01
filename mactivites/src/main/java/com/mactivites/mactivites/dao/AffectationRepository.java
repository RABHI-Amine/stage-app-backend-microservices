package com.mactivites.mactivites.dao;

import com.mactivites.mactivites.entities.Affectation;
import com.mactivites.mactivites.entities.Employe;
import com.mactivites.mactivites.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AffectationRepository extends JpaRepository<Affectation,Long> {
    public List<Affectation> findByProjetId(Long id);
    public List<Affectation> findByEmployeId(Long id);
}
