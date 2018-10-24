package com.cg.project.client;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.project.beans.Account;
import com.cg.project.exceptions.AccountBlockedException;
import com.cg.project.exceptions.AccountNotFoundException;
import com.cg.project.exceptions.BankingServicesDownException;
import com.cg.project.exceptions.InvalidAccountTypeException;
import com.cg.project.exceptions.InvalidAmountException;
import com.cg.project.services.BankingServices;
import com.cg.project.services.BankingServicesImpl;



public class MainClass {

	public static void main(String[] args) throws AccountBlockedException {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager=factory.createEntityManager();
		BankingServices bankingServices=new BankingServicesImpl();
		try {
			bankingServices.openAccount("Savings", 10000);
			List<Account>list=bankingServices.getAllAccountDetails();
			for (Account account : list) {
				System.out.println(account);
			}
			System.out.println("Details of a particular account :");
			Account acc=bankingServices.getAccountDetails(1);
			System.out.println(acc);
			
			/*float amount1=bankingServices.depositAmount(1,5000);
			 System.out.println("Total Amount  "+amount1);*/
		} catch (InvalidAmountException | InvalidAccountTypeException
				| BankingServicesDownException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
		}


	}

}
