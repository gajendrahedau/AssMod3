package com.cg.project.daoservices;


import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.project.beans.Account;
import com.cg.project.beans.Transaction;



public class BankingDAOServices {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA-PU");
	

	
	public Account save(Account account) {
		EntityManager entityManager=factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(account);
		entityManager.getTransaction().commit();
		entityManager.close();
		return account;
		
	}
	
	public Account findOne(long accountNo) {
		EntityManager entityManager=factory.createEntityManager();
		return entityManager.find(Account.class, accountNo);
	}

	public ArrayList<Account> findAll(){
		
		EntityManager entityManager=factory.createEntityManager();
		Query query=entityManager.createQuery("from Account a");
		ArrayList<Account>list=(ArrayList<Account>)query.getResultList();
		return list;

	}
		
	
}
