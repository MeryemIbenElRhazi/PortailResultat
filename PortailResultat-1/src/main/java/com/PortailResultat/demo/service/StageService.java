package com.PortailResultat.demo.service;

import com.PortailResultat.demo.entity.Stage;
import com.PortailResultat.demo.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;@Service
public class StageService {

    @Autowired
    private StageRepository stageRepository;

    public List<Stage> getAllStages() {
        return stageRepository.findAll();
    }

    public Optional<Stage> getStageById(int id) {
        return stageRepository.findById(id);
    }
    public List<Stage> getStagesByEmail(String email) {
        return stageRepository.findByMail(email);
    }

    public List<Stage> getStagesByCne(String cne) {
        return stageRepository.findByCne(cne);
    }
}
