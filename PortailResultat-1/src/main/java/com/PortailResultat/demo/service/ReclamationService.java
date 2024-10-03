package com.PortailResultat.demo.service;

import com.PortailResultat.demo.entity.Reclamation;
import com.PortailResultat.demo.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class ReclamationService {

    private final ReclamationRepository reclamationRepository;
    private final ParamsService paramsService;

    @Autowired
    public ReclamationService(ReclamationRepository reclamationRepository, ParamsService paramsService) {
        this.reclamationRepository = reclamationRepository;
        this.paramsService = paramsService;
    }

    public Reclamation saveReclamation(Reclamation reclamation) {
        Date expirationDate = paramsService.getExpirationDate(reclamation.getNiveau());
        Date currentDate = new Date(); // Date système actuelle

        if (expirationDate == null || currentDate.after(expirationDate)) {
            throw new RuntimeException("The reclamation period for this level has expired.");
        }

        if (reclamation.getDate_creation() == null) {
            reclamation.setDate_creation(currentDate); // Utilise la date actuelle si la date de création est null
        }

        return reclamationRepository.save(reclamation);
    }
}
