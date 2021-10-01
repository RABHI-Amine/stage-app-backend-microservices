package com.mactivites.mactivites.services;

import com.mactivites.mactivites.dao.EmployeRepository;
import com.mactivites.mactivites.dao.ProjetRepository;
import com.mactivites.mactivites.dao.RoleRepository;
import com.mactivites.mactivites.entities.Employe;
import com.mactivites.mactivites.entities.Projet;
import com.mactivites.mactivites.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AppInitServiceImpl implements AppInitService{

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public void initProjets() {

        for(int i=0;i<5;i++){
            Projet projet = new Projet();
            projet.setNom("projet-"+(i+1));
            projet.setDescription("projet description .... :"+(i+1));
            projet.setDateDebut(new Date());
            projet.setDateLivraison(new Date());
            projet.setNomClient("client"+(i+1));
            projetRepository.save(projet);
        }
    }

    @Override
    public void initEmployes() {
        Employe e1 = new Employe();
        e1.setNom("RABHI");
        e1.setPrenom("Amine");
        e1.setEmail("admin");
        e1.setNumeroTelephone("06782187821");
        employeRepository.save(e1);

        Employe e2 = new Employe();
        e2.setNom("Aziz");
        e2.setPrenom("Ahmed");
        e2.setEmail("user1");
        e2.setNumeroTelephone("06782187821");
        employeRepository.save(e2);

        Employe e3 = new Employe();
        e3.setNom("Hafid");
        e3.setPrenom("Mouaad");
        e3.setEmail("user2");
        e3.setNumeroTelephone("06782187821");
        employeRepository.save(e3);
    }

    @Override
    public void initRoles() {
    Role role1 = new Role();
    role1.setCode("code role 1");
    role1.setDesignation("developeur");
    role1.setAbreviation("dev");

    Role role2 = new Role();
    role2.setCode("code role 2");
    role2.setDesignation("designer");
    role2.setAbreviation("design");

    Role role3 = new Role();
    role3.setCode("code role 3");
    role3.setDesignation("concepteur");
    role3.setAbreviation("concepteur");

    Role role4 = new Role();
    role4.setCode("code role 4");
    role4.setDesignation("chef de projet");
    role4.setAbreviation("chef");

    roleRepository.save(role1);
    roleRepository.save(role2);
    roleRepository.save(role3);
    roleRepository.save(role4);
    }   

    @Override
    public void initAffectations() {

    }

    @Override
    public void initTaches() {

    }
}
