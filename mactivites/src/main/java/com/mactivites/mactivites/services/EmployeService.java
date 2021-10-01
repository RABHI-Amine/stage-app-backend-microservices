package com.mactivites.mactivites.services;

import com.mactivites.mactivites.entities.Affectation;
import com.mactivites.mactivites.entities.Employe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface EmployeService {
    public List<Employe> getAllEmployes();
    public Optional<Employe> getEmployeById(Long id);
    public Employe createEmploye(Employe emloye);
    public void deleteEmploye(Long id);
    public Employe updateEmploye(Long id,Employe employe);
    public Employe getEmployeByEmail(String email);
}
