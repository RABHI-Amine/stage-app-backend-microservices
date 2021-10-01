package com.mactivites.mactivites.dao;

import com.mactivites.mactivites.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {
    public Employe findEmployeByEmail(String email);
}
