package com.PortailResultat.demo.entity;

import jakarta.persistence.*;

@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cne;
    private float note;
    private Float note_s2;
    private int absent;
    private Integer absent_s2;
    private int acquis;
    private int rachte;
    private Integer rachte_s2;
    private float note_module;
    private Float note_module_rat;
    private Float note_module_final;
    private String decision;
    private String resultat;

    @ManyToOne
    @JoinColumn(name = "element_id")
    private Element element;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	public Float getNote_s2() {
		return note_s2;
	}

	public void setNote_s2(Float note_s2) {
		this.note_s2 = note_s2;
	}

	public int getAbsent() {
		return absent;
	}

	public void setAbsent(int absent) {
		this.absent = absent;
	}

	public Integer getAbsent_s2() {
		return absent_s2;
	}

	public void setAbsent_s2(Integer absent_s2) {
		this.absent_s2 = absent_s2;
	}

	public int getAcquis() {
		return acquis;
	}

	public void setAcquis(int acquis) {
		this.acquis = acquis;
	}

	public int getRachte() {
		return rachte;
	}

	public void setRachte(int rachte) {
		this.rachte = rachte;
	}

	public Integer getRachte_s2() {
		return rachte_s2;
	}

	public void setRachte_s2(Integer rachte_s2) {
		this.rachte_s2 = rachte_s2;
	}

	public float getNote_module() {
		return note_module;
	}

	public void setNote_module(float note_module) {
		this.note_module = note_module;
	}

	public Float getNote_module_rat() {
		return note_module_rat;
	}

	public void setNote_module_rat(Float note_module_rat) {
		this.note_module_rat = note_module_rat;
	}

	public Float getNote_module_final() {
		return note_module_final;
	}

	public void setNote_module_final(Float note_module_final) {
		this.note_module_final = note_module_final;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

    
}
