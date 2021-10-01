package com.mactivites.mactivites.services;

import com.mactivites.mactivites.dao.AffectationRepository;
import com.mactivites.mactivites.dao.ProjetRepository;
import com.mactivites.mactivites.entities.Affectation;
import com.mactivites.mactivites.entities.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetServiceImpl implements ProjetService{

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private AffectationRepository affectationRepository;

    @Override
    public List<Projet> getAllProjets() {
        return projetRepository.findAll();
    }

    @Override
    public Optional<Projet> getProjetById(Long id) {
        return projetRepository.findById(id);
    }

    @Override
    public Projet createProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public List<Affectation> getProjectAffectations(Long id) {
        return affectationRepository.findByProjetId(id);
    }

    @Override
    public void deleteProjet(Long id){  projetRepository.deleteById(id);}


}
