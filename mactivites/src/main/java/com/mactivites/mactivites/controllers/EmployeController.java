package com.mactivites.mactivites.controllers;

import com.mactivites.mactivites.dao.AffectationRepository;
import com.mactivites.mactivites.entities.Affectation;
import com.mactivites.mactivites.entities.Employe;
import com.mactivites.mactivites.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ms1")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @Autowired
    private AffectationRepository affectationRepository;

    @RolesAllowed("ADMIN")
    @GetMapping("/employes")
    public List<Employe> getAllEmployes(){
        return employeService.getAllEmployes();
    }

    @GetMapping("/employes/{id}")
    public Optional<Employe> getEmployeById(@PathVariable Long id){
        return  employeService.getEmployeById(id);
    }

    @PostMapping("/employes")
    public Employe createEmploye(@RequestBody Employe employe){
        return employeService.createEmploye(employe);
    }

    @GetMapping("/employes/{id}/affectations")
    public List<Affectation> getEmployeAffectations(@PathVariable Long id){
        return affectationRepository.findByEmployeId(id);
    }

    @DeleteMapping("/employes/{id}")
    public void deleteEmploye(@PathVariable Long id){
         employeService.deleteEmploye(id);
    }

    @PutMapping("/employes/{id}")
    public Employe updateTache(@PathVariable Long id, @RequestBody Employe employe){
        return employeService.updateEmploye(id,employe);
    }

    @GetMapping("/employes/email/{email}")
    public Employe getEmployeByEmail(@PathVariable String email){
        return employeService.getEmployeByEmail(email);
    }
}
