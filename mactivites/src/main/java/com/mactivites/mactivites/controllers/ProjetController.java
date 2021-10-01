package com.mactivites.mactivites.controllers;

import com.mactivites.mactivites.entities.Affectation;
import com.mactivites.mactivites.entities.Projet;
import com.mactivites.mactivites.services.AffectationServiceImpl;
import com.mactivites.mactivites.services.ProjetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/ms1")
public class ProjetController {

    @Autowired
    private ProjetServiceImpl projetService;

    @Autowired
    private AffectationServiceImpl affectationService;


    @GetMapping("/projets")
    private List<Projet> getAllProjets(){
        Projet projet = new Projet();
        return projetService.getAllProjets();
    }

    @GetMapping("projets/{id}")
    private Optional<Projet> getProjetById(@PathVariable Long id){
        return projetService.getProjetById(id);
    }

    @PostMapping("/projets")
    private Projet createProjet(@RequestBody Projet projet){
        return projetService.createProjet(projet);
    }

    @GetMapping("/projets/{id}/affectations")
    private List<Affectation> getEmployeAffectations(@PathVariable Long id){
        return projetService.getProjectAffectations(id);
    }

    @DeleteMapping("/projets/{id}")
    private void deleteProjet(@PathVariable Long id){
        projetService.deleteProjet(id);
    }


 }
