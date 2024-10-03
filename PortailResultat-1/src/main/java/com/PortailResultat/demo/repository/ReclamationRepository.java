package com.PortailResultat.demo.repository;

import com.PortailResultat.demo.entity.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamationRepository extends JpaRepository<Reclamation, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées de requête ici si nécessaire
}
