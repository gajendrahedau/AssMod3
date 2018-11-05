package com.cg.banking.main;
import java.util.List;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;

public class MainClass {
	public static void main(String[] args) {
		// EntityManagerFactory factory=EntityManagerFactoryProvider.getEntityManagerFactory();
		
		ApplicationContext context=new ClassPathXmlApplicationContext("");
		BankingServices bservices=(BankingServices)context.getBean("bankingServices");
		
		try {
			long accountNo1=bservices.openAccount("Salary", 40000);
			
			long accountNo2=bservices.openAccount("Saving", 30000);
			
			long accountNo3=bservices.openAccount("Salary", 20000);
			
			long accountNo4=bservices.openAccount("Saving", 10000);
			
			System.out.println(bservices.getAccountDetails(accountNo2));
			
			System.out.println(bservices.depositAmount(1, 30000));
			
			System.out.println(bservices.getAccountDetails(accountNo1));
			
			System.out.println(bservices.withdrawAmount(2, 10000, 0000));
			
			System.out.println(bservices.getAccountDetails(accountNo2));
			
			//System.out.println(bservices.getAllAccountDetails());
			
			System.out.println(bservices.getAccountAllTransaction(2));
		} catch (InvalidAmountException | InvalidAccountTypeException
				| BankingServicesDownException e) {
			e.printStackTrace();
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		} catch (AccountBlockedException e) {
			e.printStackTrace();
		} catch (InsufficientAmountException e) {
			e.printStackTrace();
		} catch (InvalidPinNumberException e) {
			e.printStackTrace();
		}
	}
}
