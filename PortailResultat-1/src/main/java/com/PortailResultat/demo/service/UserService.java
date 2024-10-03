package com.PortailResultat.demo.service;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PortailResultat.demo.entity.Membre;
import com.PortailResultat.demo.entity.PasswordResetToken;
import com.PortailResultat.demo.repository.MembreRepository;
import com.PortailResultat.demo.repository.PasswordResetTokenRepository;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {

    @Autowired
    private MembreRepository membreRepository;

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    private static final String TOKEN_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int TOKEN_LENGTH = 20;

    public String findEmailByCNE(String cne) {
        Membre membre = membreRepository.findByCne(cne);
        return (membre != null) ? membre.getMail() : null;
    }

    public String createPasswordResetToken(String email) {
        Membre membre = membreRepository.findByMail(email);
        if (membre == null) {
            return null;
        }
        String token = generateToken();
        PasswordResetToken resetToken = new PasswordResetToken(token, membre);
        tokenRepository.save(resetToken);
        return token;
    }

    public boolean resetPassword(String token, String newPassword) {
        PasswordResetToken resetToken = tokenRepository.findByToken(token);
        if (resetToken == null || resetToken.isExpired()) {
            return false;
        }
        Membre membre = resetToken.getMembre();
        membre.setPassword(newPassword);
        membreRepository.save(membre);
        tokenRepository.delete(resetToken);
        return true;
    }

    private String generateToken() {
        SecureRandom random = new SecureRandom();
        StringBuilder token = new StringBuilder(TOKEN_LENGTH);
        for (int i = 0; i < TOKEN_LENGTH; i++) {
            token.append(TOKEN_CHARS.charAt(random.nextInt(TOKEN_CHARS.length())));
        }
        return token.toString();
    }
}
