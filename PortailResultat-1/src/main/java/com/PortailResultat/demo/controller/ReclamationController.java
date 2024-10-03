package com.PortailResultat.demo.controller;

import com.PortailResultat.demo.entity.Reclamation;
import com.PortailResultat.demo.service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/reclamations")
public class ReclamationController {

    private final ReclamationService reclamationService;

    @Autowired
    public ReclamationController(ReclamationService reclamationService) {
        this.reclamationService = reclamationService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addReclamation(@RequestBody Reclamation reclamation) {
        try {
            Reclamation savedReclamation = reclamationService.saveReclamation(reclamation);
            return new ResponseEntity<>(savedReclamation, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }
}
