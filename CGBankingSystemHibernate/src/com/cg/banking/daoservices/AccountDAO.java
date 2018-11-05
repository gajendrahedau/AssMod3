package com.cg.banking.daoservices;
import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
public interface AccountDAO extends JpaRepository<Account, Long>{
	/*Account save(Account account);
	Account creditAmount(long accountNo, float amount);
	Account extractAmount(long accountNo, float amount);
	Account findOne(long accountNo);
	List<Account> findAll();
	void saveTransaction(long accountNo, float amount,String type);
	List<Transaction> getTransactionAll(long accountNo);
	void changeStatus(long accountNo);*/
}