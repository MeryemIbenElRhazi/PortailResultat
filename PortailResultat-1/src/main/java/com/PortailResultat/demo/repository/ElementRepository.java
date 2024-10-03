package com.PortailResultat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.PortailResultat.demo.entity.Element;

public interface ElementRepository extends JpaRepository<Element, Integer> {
    // Additional query methods (if any) can be added here
}
