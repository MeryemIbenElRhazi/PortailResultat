package com.PortailResultat.demo.controller;

import com.PortailResultat.demo.entity.Etudiant;
import com.PortailResultat.demo.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProfileController {

    @Autowired
    private EtudiantRepository etudiantRepository; // Suppose you have an EtudiantRepository

    @GetMapping("/etudiant/{cne}")
    public Etudiant getEtudiantProfile(@PathVariable String cne) {
        // Assuming EtudiantRepository retrieves Etudiant by cne
        Etudiant etudiant = etudiantRepository.findByCne(cne);

        // Create a new Etudiant object with only required fields
        Etudiant profile = new Etudiant();
        profile.setCne(etudiant.getCne());
        profile.setNom(etudiant.getNom());
        profile.setNiveau(etudiant.getNiveau());
        profile.setType(etudiant.getType());
        profile.setMail(etudiant.getMail());

        return profile;
    }
}
