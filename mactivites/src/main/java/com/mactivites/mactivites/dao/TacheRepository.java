package com.mactivites.mactivites.dao;

import com.mactivites.mactivites.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheRepository extends JpaRepository<Tache,Long> {
    public List<Tache> findByProjetId(Long id);
    public List<Tache> findByEmployeId(Long id);
    public List<Tache> findByEmployeIdAndProjetId(Long employeId,Long projetId);
}
