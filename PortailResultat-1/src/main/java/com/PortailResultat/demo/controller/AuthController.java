// AuthController.java
package com.PortailResultat.demo.controller;

import com.PortailResultat.demo.entity.Etudiant;
import com.PortailResultat.demo.entity.Membre;
import com.PortailResultat.demo.entity.Notes;
import com.PortailResultat.demo.service.AuthService;
import com.PortailResultat.demo.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private NotesService notesService;

    @PostMapping("/login")
    public ResponseEntity<Membre> login(@RequestBody LoginRequest loginRequest) {
        try {
            Membre membre = authService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());
            return ResponseEntity.ok(membre); // Retourne l'entité Membre authentifiée
        } catch (Exception e) {
            return ResponseEntity.status(401).body(null); // Gestion de l'échec d'authentification
        }
    }

    @GetMapping("/student")
    public ResponseEntity<Etudiant> getStudent(@RequestParam String email) {
        try {
            Etudiant etudiant = authService.getStudentByEmail(email);
            return ResponseEntity.ok(etudiant); // Retourne l'entité Etudiant trouvée
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null); // Gestion de l'étudiant non trouvé
        }
    }


    @GetMapping("/notes")
    public ResponseEntity<List<Notes>> getNotes(@RequestParam String cne) {
        try {
            List<Notes> notes = notesService.getNotesByCne(cne);
            return ResponseEntity.ok(notes); // Returns the list of notes
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null); // Handle notes not found
        }
    }

    static class LoginRequest {
        private String email;
        private String password;

        // Getters and setters
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
    @PostMapping("/reset-password")
    public ResponseEntity<Map<String, String>> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        try {
            authService.resetPassword(resetPasswordRequest.getEmail(), resetPasswordRequest.getOldPassword(), resetPasswordRequest.getNewPassword());
            Map<String, String> response = new HashMap<>();
            response.put("message", "Réinitialisation du mot de passe réussie");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Collections.singletonMap("error", "Échec de la réinitialisation du mot de passe : " + e.getMessage()));
        }
    }

    // ResetPasswordRequest class definition
    static class ResetPasswordRequest {
        private String email;
        private String oldPassword;
        private String newPassword;

        // Getters and setters
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getOldPassword() {
            return oldPassword;
        }

        public void setOldPassword(String oldPassword) {
            this.oldPassword = oldPassword;
        }

        public String getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }
    }
}