package com.mactivites.mactivites.services;

import com.mactivites.mactivites.entities.Tache;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TacheService {
    public List<Tache> getTacheByProjetId(Long id);
    public Tache createTache(Long projetId,Long employeId ,Tache tache);
    public List<Tache> getAllTaches();
    public List<Tache> getTachesByEmployeId(Long id);
    public List<Tache> getTachesByEmployeIdAndProjectId(Long employeId,Long projetId);
    public Tache updateTache(Long id,Tache tache);
}
