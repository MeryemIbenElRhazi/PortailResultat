package com.PortailResultat.demo.service;

import com.PortailResultat.demo.entity.Notes;
import com.PortailResultat.demo.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;

    public List<Notes> getNotesByCne(String cne) {
        return notesRepository.findNotesWithElementAndModuleByCne(cne);
    }
}
