package com.PortailResultat.demo.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Calendar;

@Entity
public class PasswordResetToken {

    private static final int EXPIRATION = 60 * 24; // Token valable 24 heures

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @OneToOne(targetEntity = Membre.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "membre_id")
    private Membre membre;

    private Date expiryDate;

    public PasswordResetToken() {}

    public PasswordResetToken(String token, Membre membre) {
        this.token = token;
        this.membre = membre;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    public boolean isExpired() {
        return new Date().after(this.expiryDate);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public static int getExpiration() {
		return EXPIRATION;
	}

    
}
