package com.cg.project.services;

import java.util.List;

import com.cg.project.beans.Account;
import com.cg.project.beans.Transaction;
import com.cg.project.daoservices.BankingDAOServices;
import com.cg.project.exceptions.AccountBlockedException;
import com.cg.project.exceptions.AccountNotFoundException;
import com.cg.project.exceptions.BankingServicesDownException;
import com.cg.project.exceptions.InsufficientAmountException;
import com.cg.project.exceptions.InvalidAccountTypeException;
import com.cg.project.exceptions.InvalidAmountException;
import com.cg.project.exceptions.InvalidPinNumberException;

public class BankingServicesImpl implements BankingServices {
	private BankingDAOServices bankingDAO=new BankingDAOServices();
	@Override
	public long openAccount(String accountType, float initBalance)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
			Account account = null;
			account = new Account(accountType, initBalance);
			account=bankingDAO.save(account);
		
		return account.getAccountNo();
	}

	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		
		Account account=getAccountDetails(accountNo);
		
		account.setAccountBalance(account.getAccountBalance()+amount);
		
		((Transaction) account.getTransactions()).setAmount(amount);
		((Transaction) account.getTransactions()).setTransactionType("Deposit");
		return account.getAccountBalance();
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
			AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		
		Account account=getAccountDetails(accountNo);
		float balance=account.getAccountBalance();
		if (account.getPinNumber()==pinNumber){
			account.setAccountBalance(account.getAccountBalance()-amount);
			((Transaction) account.getTransactions()).setAmount(amount);
			((Transaction) account.getTransactions()).setTransactionType("Withdrawal");
			return account.getAccountBalance();
		}
		return balance;
	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
		Account accountOfReceiver=getAccountDetails(accountNoTo);
		Account accountOfSener=getAccountDetails(accountNoFrom);
		if (accountOfSener.getPinNumber()==pinNumber){
			((Transaction) accountOfSener.getTransactions()).setAmount(transferAmount);
			((Transaction) accountOfSener.getTransactions()).setTransactionType("Withdrawal");
			((Transaction) accountOfReceiver.getTransactions()).setTransactionType("Withdrawal");
			
			
			accountOfSener.setAccountBalance(accountOfSener.getAccountBalance()-((Transaction) accountOfSener.getTransactions()).getAmount());
			accountOfReceiver.setAccountBalance(accountOfReceiver.getAccountBalance()+((Transaction) accountOfReceiver.getTransactions()).getAmount());
		}
		return false;
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		Account account=bankingDAO.findOne(accountNo);
		if(account==null) throw new AccountNotFoundException("Account does not exist: getAccountDetails");
		return account;
	}

	@Override
	public List<Account> getAllAccountDetails() throws BankingServicesDownException {
		return bankingDAO.findAll();
		
	}

	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		/*Account account=accountDAO.findOne(accountNo);
		Transaction transaction=account.getTransaction();
		return transaction;*/
		return null;
	}

	@Override
	public String accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		Account account=getAccountDetails(accountNo);
		return account.getStatus();
	}
}
