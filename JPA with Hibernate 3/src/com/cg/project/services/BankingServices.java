package com.cg.project.services;

import java.util.List;

import com.cg.project.beans.Account;
import com.cg.project.beans.Transaction;
import com.cg.project.exceptions.AccountBlockedException;
import com.cg.project.exceptions.AccountNotFoundException;
import com.cg.project.exceptions.BankingServicesDownException;
import com.cg.project.exceptions.InsufficientAmountException;
import com.cg.project.exceptions.InvalidAccountTypeException;
import com.cg.project.exceptions.InvalidAmountException;
import com.cg.project.exceptions.InvalidPinNumberException;

public interface BankingServices {
	long openAccount(String accountType,float initBalance)
			throws InvalidAmountException,InvalidAccountTypeException,BankingServicesDownException;

	float depositAmount(long accountNo,float amount)
			throws
			AccountNotFoundException,BankingServicesDownException, AccountBlockedException;

	float withdrawAmount(long accountNo,float amount,int pinNumber)
			throws InsufficientAmountException,
			AccountNotFoundException,InvalidPinNumberException,
			BankingServicesDownException ,AccountBlockedException;

	boolean fundTransfer(long accountNoTo,long accountNoFrom,float transferAmount,int pinNumber)
			throws InsufficientAmountException,AccountNotFoundException,InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException  ;

	Account getAccountDetails(long accountNo)
			throws  AccountNotFoundException,BankingServicesDownException;

	List<Account> getAllAccountDetails()
			throws BankingServicesDownException;

	List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException,
			AccountNotFoundException;

	public String accountStatus(long accountNo)
			throws BankingServicesDownException,
			AccountNotFoundException, AccountBlockedException;
}


