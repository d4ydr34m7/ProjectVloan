package com.gladiator.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Applicant {
		@Id
		@GeneratedValue
		@Column(name="app_id")
		private int aid;
		@Column(name="app_name")
		private String name;
		@Column(name="app_age")
		private int age;
		@Column(name="app_gender")
		private String gender;
		@Column(name="app_mobile")
		private int mobile;
		@Column(name="app_email")
		private String email;
		@Column(name="app_password")
		private String password;
		@Column(name="app_exist_emi")
		private String eEmi;
		@Column(name="app_ysal")
		private int ysal;
		
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="l_aid")
		private Loan  loan;
		
		@OneToOne(cascade=CascadeType.ALL )
		@JoinColumn(name="v_aid")
		private Vehicle vehicle;
		
		
		@OneToOne
		@JoinColumn(name="c_aid")
		private Client client;
		
		@OneToOne
		@JoinColumn(name="emi_aid")
		private Emi emi;
		
		@OneToOne(cascade=CascadeType.ALL )
		@JoinColumn(name="emp_aid")
		private EmploymentDet empDet;
		
		
		
		public Loan getLoan() {
			return loan;
		}
		public void setLoan(Loan loan) {
			this.loan = loan;
		}
		public EmploymentDet getEmpDet() {
			return empDet;
		}
		public void setEmpDet(EmploymentDet empDet) {
			this.empDet = empDet;
		}
		public Vehicle getVehicle() {
			return vehicle;
		}
		public void setVehicle(Vehicle vehicle) {
			this.vehicle = vehicle;
		}
		public Client getClient() {
			return client;
		}
		public void setClient(Client client) {
			this.client = client;
		}
		public Emi getEmi() {
			return emi;
		}
		public void setEmi(Emi emi) {
			this.emi = emi;
		}
		public int getAid() {
			return aid;
		}
		public void setAid(int aid) {
			this.aid = aid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getMobile() {
			return mobile;
		}
		public void setMobile(int mobile) {
			this.mobile = mobile;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String geteEmi() {
			return eEmi;
		}
		public void seteEmi(String eEmi) {
			this.eEmi = eEmi;
		}
		public int getYsal() {
			return ysal;
		}
		public void setYsal(int ysal) {
			this.ysal = ysal;
		}
		
		
}
