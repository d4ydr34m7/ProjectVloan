package com.gladiator.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Emi_exists")
public class Emi {
	
	@Id
	@GeneratedValue
	@Column(name="emi_id")
	private int emiId;
	@Column(name="emi_amount")
	private int emiAmount;
	@Column(name="emi_amount_paid")
	private int paidAmount;
	@Column(name="emi_tenure")
	private int tenure;
	
	

@OneToOne(mappedBy="emi")
	private Applicant applicant;


public int getEmiId() {
	return emiId;
}


public void setEmiId(int emiId) {
	this.emiId = emiId;
}


public int getEmiAmount() {
	return emiAmount;
}


public void setEmiAmount(int emiAmount) {
	this.emiAmount = emiAmount;
}


public int getPaidAmount() {
	return paidAmount;
}


public void setPaidAmount(int paidAmount) {
	this.paidAmount = paidAmount;
}


public int getTenure() {
	return tenure;
}


public void setTenure(int tenure) {
	this.tenure = tenure;
}


public Applicant getApplicant() {
	return applicant;
}


public void setApplicant(Applicant applicant) {
	this.applicant = applicant;
}



}
