package com.gladiator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Client {
		@Id
		@GeneratedValue
		@Column(name="c_id")
		private int cid;
		
		
		@OneToOne(mappedBy="client")
		private Applicant applicant;
		
		
		@OneToOne
		@JoinColumn(name="l_cid")
		private Loan loan;


		public int getCid() {
			return cid;
		}


		public void setCid(int cid) {
			this.cid = cid;
		}


		public Applicant getApplicant() {
			return applicant;
		}


		public void setApplicant(Applicant applicant) {
			this.applicant = applicant;
		}


		public Loan getLoan() {
			return loan;
		}


		public void setLoan(Loan loan) {
			this.loan = loan;
		}
		
		
}
