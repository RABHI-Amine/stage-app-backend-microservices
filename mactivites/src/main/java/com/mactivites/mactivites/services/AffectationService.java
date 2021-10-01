package com.mactivites.mactivites.services;

import com.mactivites.mactivites.entities.Affectation;

public interface AffectationService {

    public Affectation affecterEmplyer(Long idProjet,Long idEmploye,Affectation affectation);
}
