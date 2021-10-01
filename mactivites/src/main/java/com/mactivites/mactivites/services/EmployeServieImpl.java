package com.mactivites.mactivites.services;

import com.mactivites.mactivites.dao.AffectationRepository;
import com.mactivites.mactivites.dao.EmployeRepository;
import com.mactivites.mactivites.entities.Employe;
import com.mactivites.mactivites.entities.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeServieImpl implements EmployeService{

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private AffectationRepository affectationRepository;

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Optional<Employe> getEmployeById(Long id) {
        return employeRepository.findById(id);
    }

    @Override
    public Employe createEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public Employe updateEmploye(Long id, Employe employe) {
        Employe e = employeRepository.findById(id).get();
        e.setEmail(employe.getEmail());
        e.setPrenom(employe.getPrenom());
        e.setNom(employe.getNom());
        e.setAffectations(employe.getAffectations());
        e.setNumeroTelephone(employe.getNumeroTelephone());
        return employeRepository.save(e);
    }

    @Override
    public Employe getEmployeByEmail(String email) {
        return employeRepository.findEmployeByEmail(email);
    }
}
