package com.mactivites.mactivites.controllers;

import com.mactivites.mactivites.entities.Tache;
import com.mactivites.mactivites.services.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/ms1")
public class TacheController {

    @Autowired
    private TacheService tacheService;

    @GetMapping("/projets/{id}/taches")
    public List<Tache> getAllProjetTaches(@PathVariable Long id){
        return tacheService.getTacheByProjetId(id);
    }

    @PostMapping("/employes/{employeId}/projets/{projetId}/taches")
    public Tache createProjetTache(@PathVariable Long projetId,@PathVariable Long employeId,@RequestBody Tache tache){
        return tacheService.createTache(employeId,projetId,tache);
    }

    @GetMapping("/employes/{employeId}/projets/{projetId}/taches")
    public List<Tache> getTachesByEmployeIdAndProjectId(@PathVariable Long employeId,@PathVariable Long projetId){
        return tacheService.getTachesByEmployeIdAndProjectId(employeId,projetId);
    }

    @GetMapping("/taches")
    public List<Tache> getAllTache(){
        return tacheService.getAllTaches();
    }

    @GetMapping("/employes/{id}/taches")
    public List<Tache> getTachesByEmployeID(@PathVariable Long id){
        return tacheService.getTachesByEmployeId(id);
    }

    @PutMapping("/taches/{id}")
    public Tache updateTache(@PathVariable Long id,@RequestBody Tache tache){
        return tacheService.updateTache(id,tache);
    }
}
