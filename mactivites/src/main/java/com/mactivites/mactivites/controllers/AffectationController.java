package com.mactivites.mactivites.controllers;

import com.mactivites.mactivites.entities.Affectation;
import com.mactivites.mactivites.services.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ms1")
public class AffectationController {

    @Autowired
    private AffectationService affectationService;

    @PostMapping("/projets/{projetID}/employes/{employeID}/affectations")
    private Affectation affecterEmploye(@PathVariable Long projetID, @PathVariable Long employeID, @RequestBody Affectation affectation){
        return affectationService.affecterEmplyer(projetID,employeID,affectation);
    }
}
