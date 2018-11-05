package com.cg.banking.beans;
import java.util.List;
import javax.lang.model.element.Name;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Query;
@Entity
@NamedQueries({
@NamedQuery(name="FindAll",query="select a from Account a"),
@NamedQuery(name="AllTransaction",query="select t from Transaction t")
})
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long accountNo;
	
	private int pinNumber;
	private String accountType,status;
	private float accountBalance;
	
	@OneToMany(mappedBy="account")
	private List<Transaction> transactions;

	public Account(String accountType, float accountBalance) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public Account(int pinNumber, String accountType, String status,
			float accountBalance, List<Transaction> transactions) {
		super();
		this.pinNumber = pinNumber;
		this.accountType = accountType;
		this.status = status;
		this.accountBalance = accountBalance;
		this.transactions = transactions;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", pinNumber=" + pinNumber
				+ ", accountType=" + accountType + ", status=" + status
				+ ", accountBalance=" + accountBalance + "]";
	}

	public Account() {
		super();
	}
	public int getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}	
	
	

}