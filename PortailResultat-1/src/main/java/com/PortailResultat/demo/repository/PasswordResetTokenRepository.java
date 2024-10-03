package com.PortailResultat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.PortailResultat.demo.entity.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);
}
