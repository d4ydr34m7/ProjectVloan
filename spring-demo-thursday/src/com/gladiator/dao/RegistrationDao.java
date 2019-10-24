package com.gladiator.dao;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gladiator.entity.Applicant;
import com.gladiator.entity.EmploymentDet;
import com.gladiator.entity.Loan;
import com.gladiator.entity.Vehicle;

@Repository
public class RegistrationDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void save(Applicant applicant ,Vehicle vehicle,EmploymentDet empDetails,Loan loan) {
		applicant.setVehicle(vehicle);
		applicant.setEmpDet(empDetails);
		applicant.setLoan(loan);
		System.out.println("asdasd");
		System.out.println("1");
		entityManager.merge(applicant);
		System.out.println("4");
	}

	public List<String> fetchMake() {
		Query q=entityManager.createQuery("select distinct v.cmake from Vehicle v");
	   
		return q.getResultList();
	}
	public List<String> fetchModel(String make) {
		Query q=entityManager.createQuery("select distinct v.cmodel from Vehicle v where v.cmake=:mk");
		q.setParameter("mk", make);
		return q.getResultList();
	}
	
	public String fetchCarPrice(String make,String model) {
		Query q=entityManager.createQuery("select distinct v.exprice from Vehicle v where v.cmodel=:mo and v.cmake=:mk");
		q.setParameter("mk", make.trim());
		q.setParameter("mo", model.trim());
		System.out.println(make);
		System.out.println(model.trim());
		return q.getSingleResult().toString();
	}
}
