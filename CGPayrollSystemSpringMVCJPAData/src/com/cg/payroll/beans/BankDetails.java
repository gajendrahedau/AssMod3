package com.cg.payroll.beans;

import javax.persistence.Embeddable;

@Embeddable
public class BankDetails {
	
	@Override
	public String toString() {
		return "BankDetails [accountNumber=" + accountNumber + ", bankName="
				+ bankName + ", ifscCode=" + ifscCode + "]";
	}
	
	private long accountNumber ;
	
	private String bankName ;
	
	private String ifscCode ;
	
	public BankDetails() {
		super();
	}
	
	public BankDetails(long accountNumber, String bankName, String ifscCode) {
		super();
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
}
