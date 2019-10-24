package com.gladiator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Loan {
	
		@Id
		@GeneratedValue
		@Column(name="l_id")
		private int lid;
		@Column(name="l_amount")
		private int lamount;
		@Column(name="l_tenure")
		private int ltenure;
		@Column(name="l_roi")
		private int lroi;
		@Column(name="l_emi")
		private int lemi;
		@OneToOne(mappedBy="loan")
		private Client client;
		@OneToOne(mappedBy="loan")
		private Applicant applicant;
		
		
		
		public Applicant getApplicant() {
			return applicant;
		}
		public void setApplicant(Applicant applicant) {
			this.applicant = applicant;
		}
		
		public int getLid() {
			return lid;
		}
		
		public void setLid(int lid) {
			this.lid = lid;
		}
		public int getLamount() {
			return lamount;
		}
		public void setLamount(int lamount) {
			this.lamount = lamount;
		}
		public int getLtenure() {
			return ltenure;
		}
		public void setLtenure(int ltenure) {
			this.ltenure = ltenure;
		}
		public int getLroi() {
			return lroi;
		}
		public void setLroi(int lroi) {
			this.lroi = lroi;
		}
		public int getLemi() {
			return lemi;
		}
		public void setLemi(int lemi) {
			this.lemi = lemi;
		}
		public Client getClient() {
			return client;
		}
		public void setClient(Client client) {
			this.client = client;
		}
		
		
}
