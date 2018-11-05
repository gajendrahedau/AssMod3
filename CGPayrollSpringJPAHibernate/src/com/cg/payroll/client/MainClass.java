package com.cg.payroll.client;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
public class MainClass {
	public static void main(String[] args) throws AssociateDetailsNotFoundException {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("projectbeans.xml");
		PayrollServices payrollServices=(PayrollServices)context.getBean("payrollServices");
		try {
			int associateId1=payrollServices.acceptAssociateDetails(20000, "Gajendra", "Hedau", "A", "SR. CON.", "ASDFG454H", "GAJ@gmail.com", 50000, 2000, 3000, 123456789, "SBI", "SBI0098");
			System.out.println("Your Associate Id is : "+associateId1);
			
			int associateId2=payrollServices.acceptAssociateDetails(15000, "Atull", "Hedau", "A", "SR. CON.", "ASDFG454H", "GAJ@gmail.com", 50000, 2000, 3000, 123456789, "SBI", "SBI0098");
			System.out.println("Your Associate Id is : "+associateId2);
			
			int associateId3=payrollServices.acceptAssociateDetails(12000, "Anuu", "Hedau", "b", "SR. CON.", "ASDFG454H", "GAJ@gmail.com", 50000, 2000, 3000, 123456789, "SBI", "SBI0098");
			System.out.println("Your Associate Id is : "+associateId3);
			
			int associateId4=payrollServices.acceptAssociateDetails(10000, "Ashutosh", "Hedau", "g", "SR. CON.", "ASDFG454H", "GAJ@gmail.com", 50000, 2000, 3000, 123456789, "SBI", "SBI0098");
			System.out.println("Your Associate Id is : "+associateId4);
			
			System.out.println("ALL\n");
			ArrayList<Associate> list=payrollServices.getAllAssociateDetails();
			for (Associate associate : list) {
				System.out.println(associate);
			}
			
			
			System.out.println("Total\n");
			System.out.println(payrollServices.calculateNetSalary(2));
			
			System.out.println("Salary\n"+payrollServices.getAssociateDetails(2));
			
			System.out.println("ALL\n");
			ArrayList<Associate> list1=payrollServices.getAllAssociateDetails();
			for (Associate associate : list1) {
				System.out.println(associate);
			}
			
			
			
			System.out.println("ALL\n");
			ArrayList<Associate> list2=payrollServices.getAllAssociateDetails();
			for (Associate associate : list2) {
				System.out.println(associate);
			}
			
		} catch (PayrollServicesDownException e) {
			e.printStackTrace();
		}
		
		
		/*PayrollServices payrollServices=new PayrollServicesImpl();
		try {
			int associateId1=payrollServices.acceptAssociateDetails(20000, "Gajendra", "Hedau", "A", "SR. CON.", "ASDFG454H", "GAJ@gmail.com", 50000, 2000, 3000, 123456789, "SBI", "SBI0098");
			
			
			int associateId2=payrollServices.acceptAssociateDetails(15000, "Atull", "Hedau", "A", "SR. CON.", "ASDFG454H", "GAJ@gmail.com", 50000, 2000, 3000, 123456789, "SBI", "SBI0098");
			
			int associateId3=payrollServices.acceptAssociateDetails(12000, "Anuu", "Hedau", "b", "SR. CON.", "ASDFG454H", "GAJ@gmail.com", 50000, 2000, 3000, 123456789, "SBI", "SBI0098");

			
			int associateId4=payrollServices.acceptAssociateDetails(10000, "Ashutosh", "Hedau", "g", "SR. CON.", "ASDFG454H", "GAJ@gmail.com", 50000, 2000, 3000, 123456789, "SBI", "SBI0098");
			
			System.out.println("ALL\n");
			ArrayList<Associate> list=payrollServices.getAllAssociateDetails();
			for (Associate associate : list) {
				System.out.println(associate);
			}
			
			
			System.out.println("Total\n");
			System.out.println(payrollServices.calculateNetSalary(2));
			
			System.out.println("Salary\n"+payrollServices.getAssociateDetails(2));
			
			System.out.println("ALL\n");
			ArrayList<Associate> list1=payrollServices.getAllAssociateDetails();
			for (Associate associate : list1) {
				System.out.println(associate);
			}
			
			
			System.out.println("\n");
			
			a.setFirstName("WELLL");
			
			
			System.out.println("After Update-\n"+payrollServices.getUpdate(a));
			
			System.out.println("ALL\n");
			ArrayList<Associate> list1=payrollServices.getAllAssociateDetails();
			for (Associate associate : list1) {
				System.out.println(associate);
			}
			
			
		} catch (PayrollServicesDownException e) {
			e.printStackTrace();
		} catch (AssociateDetailsNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}
}


