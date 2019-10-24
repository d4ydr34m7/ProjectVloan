package com.gladiator.service;


import org.springframework.stereotype.Service;

import com.gladiator.entity.Applicant;
import com.gladiator.entity.EmploymentDet;
import com.gladiator.entity.Loan;
import com.gladiator.entity.Vehicle;

@Service
public class LoanQuotes {
	public int getMaxTenure(Applicant applicant) {
		if(70-applicant.getAge()>=7) 
			return 7*12;
		else 
			return (70-applicant.getAge())*12;
	}
	
	public int getMaxLoanAmount(Applicant applicant,Vehicle vehicle,EmploymentDet empDetails) {
		if(getMaxTenure(applicant)==84) 
			return (int)Math.min(empDetails.getMonthlySal()*30, (vehicle.getExprice()-vehicle.getExprice()*0.01));
		else if(getMaxTenure(applicant)==72)
			return (int)Math.min(empDetails.getMonthlySal()*16, (vehicle.getExprice()-vehicle.getExprice()*0.01));
		else
			return (int)Math.min(empDetails.getMonthlySal()*10, (vehicle.getExprice()-vehicle.getExprice()*0.01));		
	}
	
	public int CalculateEmi(Applicant applicant,Vehicle vehicle,EmploymentDet empDetails) {
		double num;
		return (int)( (double) Math.ceil((double)(getMaxLoanAmount(applicant,vehicle,empDetails) *(double)10/(double)1200* Math.pow((1+(double)10/(double)1200),getMaxTenure(applicant)))/(double)(Math.pow((1+(double)10/(double)1200),getMaxTenure(applicant))-1)* 100) / (double)100);
		
	}
}
