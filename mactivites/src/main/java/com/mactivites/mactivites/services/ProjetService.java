package com.mactivites.mactivites.services;
import com.mactivites.mactivites.entities.Affectation;
import com.mactivites.mactivites.entities.Projet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


interface  ProjetService {
    public List<Projet> getAllProjets();
    public Optional<Projet> getProjetById( Long id);
    public Projet createProjet(Projet projet);
    public List<Affectation> getProjectAffectations(Long id);
    public void deleteProjet(Long id);
}
