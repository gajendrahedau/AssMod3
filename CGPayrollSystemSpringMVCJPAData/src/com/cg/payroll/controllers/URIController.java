package com.cg.payroll.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.payroll.beans.Associate;

@Controller
public class URIController {
	
	Associate associate;
	
	@RequestMapping("/")
	public String getIndexPage(){
		return "indexPage";
	}
	
	@RequestMapping("/registrationPage")
	public String getRegistrationPage() {
		return "registrationPage";
	}
	
	@ModelAttribute
	public Associate getAssociate() {
		associate=new Associate();
		return associate;
	}
}
