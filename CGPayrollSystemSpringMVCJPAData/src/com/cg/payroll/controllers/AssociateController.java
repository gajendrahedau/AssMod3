package com.cg.payroll.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.services.PayrollServices;

@Controller
public class AssociateController {
	
	@Autowired
	private PayrollServices payrollServices;
	
	@RequestMapping("/registerAssociate")
	public ModelAndView registerAssociateAction(@Valid @ModelAttribute Associate associate,
			BindingResult result) throws PayrollServicesDownException {
		
		if(result.hasErrors()) 
			return new ModelAndView("registrationPage");
		
		associate=payrollServices.acceptAssociateDetails(associate);
		
		return new ModelAndView("registrationSuccessPage","associate",associate);
		
	}
}
