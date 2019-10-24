package com.gladiator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gladiator.dao.RegistrationDao;
import com.gladiator.entity.Applicant;
import com.gladiator.entity.EmploymentDet;
import com.gladiator.entity.Loan;
import com.gladiator.entity.Vehicle;
@Service
public class RegistrationService {
	@Autowired
	private RegistrationDao registrationDao;
	
	public void register(Applicant applicant, Vehicle vehicle, EmploymentDet empDetails,Loan loan) {
		registrationDao.save(applicant,vehicle,empDetails,loan);
		//sending email code here
	}

	public List<String> fetchMake() {
		// TODO Auto-generated method stub
		return registrationDao.fetchMake();
	}
	
	public List<String> fetchModel(String make) {
		// TODO Auto-generated method stub
		return registrationDao.fetchModel(make);
	}
	
	public String fetchCarPrice(String make,String model) {
		// TODO Auto-generated method stub
		 return registrationDao.fetchCarPrice(make,model);
		
	}
}
