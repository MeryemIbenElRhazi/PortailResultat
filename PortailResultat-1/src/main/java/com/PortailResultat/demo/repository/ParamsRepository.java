package com.PortailResultat.demo.repository;

import com.PortailResultat.demo.entity.Params;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;

public interface ParamsRepository extends JpaRepository<Params, String> {
    @Query("SELECT p.date_expiration FROM Params p WHERE p.niveau = :niveau")
    Date findExpirationDateByNiveau(@Param("niveau") String niveau);
}
