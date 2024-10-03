package com.PortailResultat.demo.controller;

import com.PortailResultat.demo.entity.Stage;
import com.PortailResultat.demo.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stages")
public class StageController {

    @Autowired
    private StageService stageService;

    @GetMapping
    public ResponseEntity<List<Stage>> getAllStages() {
        List<Stage> stages = stageService.getAllStages();
        return new ResponseEntity<>(stages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stage> getStageById(@PathVariable("id") int id) {
        Optional<Stage> stage = stageService.getStageById(id);
        return stage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-cne")
    public ResponseEntity<List<Stage>> getStagesByCne(@RequestParam String cne) {
        List<Stage> stages = stageService.getStagesByCne(cne);
        return new ResponseEntity<>(stages, HttpStatus.OK);
    }
    
    // Nouveau point de terminaison pour obtenir les stages par e-mail
    @GetMapping("/by-email")
    public ResponseEntity<List<Stage>> getStagesByEmail(@RequestParam String email) {
        List<Stage> stages = stageService.getStagesByEmail(email);
        return new ResponseEntity<>(stages, HttpStatus.OK);
    }
}
