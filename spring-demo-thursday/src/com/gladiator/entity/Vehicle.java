package com.gladiator.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vehicle {
		@Id
		@GeneratedValue
		@Column(name="v_id")
		private int cid;
		@Column(name="v_make")
		private String cmake;
		@Column(name="v_model")
		private String cmodel;
		@Column(name="v_exshowroom_price")
		private int exprice;
		
		@OneToMany(mappedBy="vehicle")
		private List<Applicant> applicant;

		

		public int getCid() {
			return cid;
		}

		public void setCid(int cid) {
			this.cid = cid;
		}

		public String getCmake() {
			return cmake;
		}

		public void setCmake(String cmake) {
			this.cmake = cmake;
		}

		public String getCmodel() {
			return cmodel;
		}

		public void setCmodel(String cmodel) {
			this.cmodel = cmodel;
		}

		public int getExprice() {
			return exprice;
		}

		public void setExprice(int exprice) {
			this.exprice = exprice;
		}

		public List<Applicant> getApplicant() {
			return applicant;
		}

		public void setApplicant(List<Applicant> applicant) {
			this.applicant = applicant;
		}
		
		
}
