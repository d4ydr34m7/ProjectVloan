package com.gladiator.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.gladiator.entity.Applicant;
import com.gladiator.entity.EmploymentDet;
import com.gladiator.entity.Loan;
import com.gladiator.entity.Vehicle;
import com.gladiator.service.LoanQuotes;
import com.gladiator.service.RegistrationService;
	
	@Controller
	@SessionAttributes({"applicant","vehicle","empDetails","loan"})
	public class RegistrationController {
		
			@Autowired
			private RegistrationService registrationService;
			
			@Autowired
			private LoanQuotes loanQuotes;
			
			
			
			@RequestMapping(path="/model.lti")
			
			public @ResponseBody String getModel(@RequestParam(value="cMake") String make) {
				 
				// System.out.println(registrationService.fetchModel(make));
				
				 Iterator<String> iterator=registrationService.fetchModel(make).iterator();
				 String[] modelArray=new String[registrationService.fetchModel(make).size()];
				 for(int i=0;i<registrationService.fetchModel(make).size();i++) {
					 modelArray[i]=registrationService.fetchModel(make).get(i);
				 }
				 return Arrays.toString(modelArray);
			}
@RequestMapping(path="/carPrice.lti")
			
			public @ResponseBody String getCarPrice(@RequestParam(value="cMake") String make , @RequestParam(value="cModel") String model) {
				 
				// System.out.println(registrationService.fetchModel(make));
				System.out.println(registrationService.fetchCarPrice(make, model));
				 return registrationService.fetchCarPrice(make, model) ;
			}
			
			@RequestMapping(path="/emi.lti")
			public @ResponseBody String getEmi(@RequestParam(value="lAmount") int lAmount,@RequestParam(value="lTenure") int lTenure) {
				 
				// System.out.println(registrationService.fetchModel(make));
				int Emi= (int)( (double) Math.ceil((double)(lAmount *(double)10/(double)1200* Math.pow((1+(double)10/(double)1200),lTenure))/(double)(Math.pow((1+(double)10/(double)1200),lTenure)-1)* 100) / (double)100);
				return Integer.toString(Emi);
				 

			}
			
			
			@RequestMapping(path="/reg.lti")
			public String make(Model model) {
				model.addAttribute("make",registrationService.fetchMake());
				return "register.jsp";
			}
			
			
			@RequestMapping(path="/regisfinal.lti")
			public String empDetail(Loan loan,Model model) {
				model.addAttribute("loan",loan);
				return "regisfinal.jsp";
			}
			
			@RequestMapping(path="/cardet.lti")
			//public String register(HttpServeltRequest req) {}
			//public String register(@RequestParam("name") String name, @RequestParam) {}
			public String newForm(Applicant applicant, Vehicle vehicle,EmploymentDet empDetails ,Model model) {
				System.out.println(applicant);
				model.addAttribute("applicant",applicant);
				model.addAttribute("empDetails",empDetails);
				model.addAttribute("vehicle",vehicle);
				model.addAttribute("maxTenure",loanQuotes.getMaxTenure(applicant));
				model.addAttribute("maxLoanAmount",loanQuotes.getMaxLoanAmount(applicant, vehicle, empDetails));
				model.addAttribute("calcEmi",loanQuotes.CalculateEmi(applicant, vehicle, empDetails));
				return "cardet.jsp";
			}
			
			@RequestMapping(path="/success.lti")
			public String empDetail(Applicant applicant,Vehicle vehicle ,Loan loan,EmploymentDet empDetails) {
				System.out.println(applicant.getAge()+" "+vehicle.getExprice()+" "+empDetails);
				registrationService.register(applicant,vehicle,empDetails,loan);
				return "success.jsp";
			}
			
			@RequestMapping(path="/emiSche.lti")
			public String emiScheduler(Loan loan ,Model model) {
				model.addAttribute("loan",loan);
				return "emiScheduler.jsp";
			}
	}

