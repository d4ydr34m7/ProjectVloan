package com.gladiator.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class EmploymentDet {
@Id
@GeneratedValue
private  int empId;
private String type;
private int monthlySal;
private int rentalIncome;
private String employerName;
@OneToOne( mappedBy="empDet")

private Applicant applicant;
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getMonthlySal() {
	return monthlySal;
}
public void setMonthlySal(int monthlySal) {
	this.monthlySal = monthlySal;
}
public int getRentalIncome() {
	return rentalIncome;
}
public void setRentalIncome(int rentalIncome) {
	this.rentalIncome = rentalIncome;
}
public String getEmployerName() {
	return employerName;
}
public void setEmployerName(String employerName) {
	this.employerName = employerName;
}
public Applicant getApplicant() {
	return applicant;
}
public void setApplicant(Applicant applicant) {
	this.applicant = applicant;
}


}
