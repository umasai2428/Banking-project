package com.bank.service;
import java.sql.ResultSet;

import com.bank.dao.BankDao;
import com.bank.model.Bank;

public class BankService {
	
    public static int customerLogin(Bank b) {
	 int customerLoginSuccess= BankDao.customerLogin(b);
	return customerLoginSuccess;
	 }
 
   public static int register(Bank b11) {
	return BankDao.register(b11);   
   }

   public static void accountdetails(Bank b) {
	     BankDao.accountdetials(b);
	     }

    public static void customerviewbalance(Bank b) {
    	BankDao.customerviewbalance(b);	
}
 
	public static int customerdeposit(Bank b) {
		return BankDao.customerdeposit(b);	
	}
	
	public static int customerwithdraw(Bank b) {
		return BankDao.customerwithdraw(b);
		
	}
	public static int customertransfer(Bank b) {
		return BankDao.customertransfer(b);
  }
////////////////////////////////////////////////////////////////////////////////////////////
	public static int Employeelogin(Bank b) {
		return BankDao.EmployeeLogin(b);
		
	}

	public static void employeeviewbalance(Bank b) {
	 BankDao.Employeeviewbalance(b);
		
	}

	public static int employeedeposit(Bank b) {
		return BankDao.employeedeposit(b);
		
	}

	public static int employeewithdraw(Bank b) {
		return BankDao.employeewithdraw(b);
	}

	public static int employeetransfer(Bank b) {
		 return BankDao.employeetransfer(b);
		
	}

	public static ResultSet pending() {
		return BankDao.pending();
		
	}

	public static void approve(Bank b) {
	BankDao.approve(b);
		
	}

	public static void reject(Bank b) {
		BankDao.reject(b);
		
	}

	public static int employeeregister(Bank b) {
		
		return BankDao.employeeregister(b);
	}   
}