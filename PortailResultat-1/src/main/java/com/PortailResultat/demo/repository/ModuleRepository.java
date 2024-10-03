package com.PortailResultat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.PortailResultat.demo.entity.Module;

public interface ModuleRepository extends JpaRepository<Module, Integer> {
    // Additional query methods (if any) can be added here
}
