package com.PortailResultat.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.PortailResultat.demo.service.EmailSenderService;
import com.PortailResultat.demo.service.UserService;
import java.util.Map;

@RestController
public class PasswordResetController {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private UserService userService;

    @PostMapping("/requestPasswordReset")
    public String requestPasswordReset(@RequestBody Map<String, String> request) {
        String cne = request.get("cne");
        String email = userService.findEmailByCNE(cne);
        if (email == null) {
            return "Invalid CNE!";
        }
        String token = userService.createPasswordResetToken(email);
        if (token == null) {
            return "Invalid email!";
        }
        emailSenderService.sendResetPasswordEmail(email, token);
        return email; // Renvoie l'email pour l'utiliser dans le composant React Native
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestBody Map<String, String> request) {
        String token = request.get("token");
        String newPassword = request.get("newPassword");
        boolean result = userService.resetPassword(token, newPassword);
        return result ? "Password has been reset!" : "Invalid token!";
    }
}
