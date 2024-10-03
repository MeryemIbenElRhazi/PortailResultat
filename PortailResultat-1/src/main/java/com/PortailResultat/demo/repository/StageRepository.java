package com.PortailResultat.demo.repository;

import com.PortailResultat.demo.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StageRepository extends JpaRepository<Stage, Integer> {
    List<Stage> findByCne(String cne);
    
    // Nouvelle méthode pour trouver par e-mail
    List<Stage> findByMail(String mail);
}
