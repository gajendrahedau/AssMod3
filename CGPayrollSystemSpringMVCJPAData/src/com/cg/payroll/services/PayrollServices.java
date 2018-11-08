package com.cg.payroll.services;

import java.util.ArrayList;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;

public interface PayrollServices {
	Associate acceptAssociateDetails(Associate associate) throws PayrollServicesDownException;
	
	int calculateNetSalary(int associateId) throws AssociateDetailsNotFoundException,PayrollServicesDownException;
	
	Associate getAssociateDetails(int associateId) throws PayrollServicesDownException,AssociateDetailsNotFoundException;

	ArrayList<Associate>  getAllAssociateDetails() throws PayrollServicesDownException;

	Associate getUpdate(Associate associate);
}
