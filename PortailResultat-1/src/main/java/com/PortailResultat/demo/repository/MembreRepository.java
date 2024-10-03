package com.PortailResultat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PortailResultat.demo.entity.Membre;

public interface MembreRepository extends JpaRepository<Membre, Integer> {
    Membre findByMail(String email);
    Membre findByCne(String cne);
    
}
