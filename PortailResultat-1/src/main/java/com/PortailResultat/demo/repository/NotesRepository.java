package com.PortailResultat.demo.repository;

import com.PortailResultat.demo.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotesRepository extends JpaRepository<Notes, Integer> {
    @Query("SELECT n FROM Notes n JOIN FETCH n.element e JOIN FETCH e.module m WHERE n.cne = :cne")
    List<Notes> findNotesWithElementAndModuleByCne(@Param("cne") String cne);
}
