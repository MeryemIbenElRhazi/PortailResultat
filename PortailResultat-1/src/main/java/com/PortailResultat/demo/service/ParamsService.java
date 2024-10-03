package com.PortailResultat.demo.service;

import com.PortailResultat.demo.repository.ParamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class ParamsService {

    private final ParamsRepository paramsRepository;

    @Autowired
    public ParamsService(ParamsRepository paramsRepository) {
        this.paramsRepository = paramsRepository;
    }

    public Date getExpirationDate(String niveau) {
        return paramsRepository.findExpirationDateByNiveau(niveau);
    }
}
