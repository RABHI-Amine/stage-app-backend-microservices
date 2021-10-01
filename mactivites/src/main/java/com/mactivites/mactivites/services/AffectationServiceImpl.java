package com.mactivites.mactivites.services;

import com.mactivites.mactivites.dao.AffectationRepository;
import com.mactivites.mactivites.dao.EmployeRepository;
import com.mactivites.mactivites.dao.ProjetRepository;
import com.mactivites.mactivites.dao.RoleRepository;
import com.mactivites.mactivites.entities.Affectation;
import com.mactivites.mactivites.entities.Employe;
import com.mactivites.mactivites.entities.Projet;
import com.mactivites.mactivites.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AffectationServiceImpl implements AffectationService{

    @Autowired
    private AffectationRepository affectationRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public Affectation affecterEmplyer(Long idProjet, Long idEmploye,Affectation affec) {
        Affectation affectation = new Affectation();
        Optional<Employe> employe = employeRepository.findById(idEmploye);
        Optional<Projet> projet = projetRepository.findById(idProjet);
        affectation.setEmploye(employe.get());
        affectation.setProjet(projet.get());
        affectation.setRole(roleRepository.findById(affec.getRole().getId()).get());
        return affectationRepository.save(affectation);
    }
}
