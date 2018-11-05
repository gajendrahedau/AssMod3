package com.cg.banking.services;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

@Component(value="bankingServices")
public class BankingServicesImpl implements BankingServices {
	//AccountDAO dao=new AccountDAOImpl();
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	public long openAccount(String accountType, float initBalance)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
			if(initBalance<1000) throw new InvalidAmountException("Minimum Amount for opening an account is 1000.");
			Account account=new Account(accountType,initBalance);
			account=accountDAO.save(account);
		return account.getAccountNo();
	}

	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
			Account account=getAccountDetails(accountNo);
			if(accountStatus(accountNo).equals("Blocked")) throw new AccountBlockedException("Account is Blocked");			
			account.setAccountBalance(account.getAccountBalance()+amount);
			account=accountDAO.save(account);
			//accountDAO.saveTransaction(accountNo,amount,"Deposit");
		return account.getAccountBalance();
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
			AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
			Account account=getAccountDetails(accountNo);
			if(accountStatus(accountNo).equals("Blocked")) throw new AccountBlockedException("Account is Blocked");
			if(account.getPinNumber()!=pinNumber){
				throw new InvalidPinNumberException("Pin is Incorrect");
			} 
			if((account.getAccountBalance()-1000)<amount) throw new InsufficientAmountException("Balance is low.");
			account.setAccountBalance(account.getAccountBalance()-amount);
			account=accountDAO.save(account);
			//accountDAO.saveTransaction(accountNo,amount,"Withdraw");
		return account.getAccountBalance();
	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
		Account accountTo=getAccountDetails(accountNoTo);
		Account accountFrom=getAccountDetails(accountNoFrom);
		withdrawAmount(accountNoFrom, transferAmount, pinNumber);
		depositAmount(accountNoTo, transferAmount);
		return true;
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		Account account=accountDAO.findById(accountNo).get();
		if(account==null) throw new AccountNotFoundException("Account Not Exist");
		return account;
	}

	@Override
	public List<Account> getAllAccountDetails() throws BankingServicesDownException {
		return accountDAO.findAll();
	}
	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		//return accountDAO.getTransactionAll(accountNo);
		return null;
	}
	@Override
	public String accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		Account account=getAccountDetails(accountNo);
		return account.getStatus();
	}
}
