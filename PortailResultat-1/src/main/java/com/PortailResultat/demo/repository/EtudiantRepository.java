package com.PortailResultat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.PortailResultat.demo.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, String> {

    Etudiant findByMail(String mail); // Méthode pour trouver un étudiant par son email

    Etudiant findByCne(String cne); // Méthode pour trouver un étudiant par son CNE
}
