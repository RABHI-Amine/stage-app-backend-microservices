package com.mactivites.mactivites.services;

import com.mactivites.mactivites.dao.EmployeRepository;
import com.mactivites.mactivites.dao.ProjetRepository;
import com.mactivites.mactivites.dao.TacheRepository;
import com.mactivites.mactivites.entities.Employe;
import com.mactivites.mactivites.entities.Projet;
import com.mactivites.mactivites.entities.Tache;
import com.mactivites.mactivites.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheServiceImpl implements TacheService{

    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public List<Tache> getTacheByProjetId(Long id) {
        return tacheRepository.findByProjetId(id);
    }

    @Override
    public Tache createTache(Long projetId,Long employeId ,Tache tache) {
        Projet projet = projetRepository.findById(projetId).get();
        Employe employe = employeRepository.findById(employeId).get();
        tache.setProjet(projet);
        tache.setEmploye(employe);
        return tacheRepository.save(tache);
    }


    @Override
    public List<Tache> getAllTaches() {
        return tacheRepository.findAll();
    }

    @Override
    public List<Tache> getTachesByEmployeId(Long id) {
        return tacheRepository.findByEmployeId(id);
    }

    @Override
    public List<Tache> getTachesByEmployeIdAndProjectId(Long employeId, Long projetId) {
        return tacheRepository.findByEmployeIdAndProjetId(employeId,projetId);
    }

    @Override
    public Tache updateTache(Long id,Tache tache) {
        Tache t = tacheRepository.findById(id).get();
        t.setEmploye(tache.getEmploye());
        t.setProjet(tache.getProjet());
        t.setEtat(tache.getEtat());
        t.setName(tache.getName());
        t.setDescription(tache.getDescription());
        return tacheRepository.save(t);
    }


}
