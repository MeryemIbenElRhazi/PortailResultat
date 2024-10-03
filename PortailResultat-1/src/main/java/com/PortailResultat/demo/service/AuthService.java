package com.PortailResultat.demo.service;

import com.PortailResultat.demo.entity.Etudiant;
import com.PortailResultat.demo.entity.Membre;
import com.PortailResultat.demo.repository.EtudiantRepository;
import com.PortailResultat.demo.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private MembreRepository membreRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    public Membre authenticateUser(String email, String password) {
        Membre membre = membreRepository.findByMail(email);
        if (membre != null && password.equals(membre.getPassword())) {
            return membre;
        }
        throw new RuntimeException("Invalid credentials");
    }

    public Etudiant getStudentByEmail(String email) {
        return etudiantRepository.findByMail(email);
    }
    public void resetPassword(String email, String oldPassword, String newPassword) {
        Membre membre = membreRepository.findByMail(email);
        if (membre != null) {
            if (oldPassword.equals(membre.getPassword())) {
                membre.setPassword(newPassword);
                membreRepository.save(membre);
            } else {
                throw new RuntimeException("Ancien mot de passe incorrect");
            }
        } else {
            throw new RuntimeException("Utilisateur non trouvé");
        }
    }

}