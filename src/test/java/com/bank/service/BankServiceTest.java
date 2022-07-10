package com.bank.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.bank.model.Bank;

public class BankServiceTest {

	@Test
	public void TestLogin()
	{
		Bank b=new Bank();
		b.setEmail1("uma@gmail.com");
		b.setPassword1("1234");
		int actual=BankService.customerLogin(b);
		assertEquals(1, actual);
	}
	
	/*@Test
	public void TestLogin1()
	{
		Bank b=new Bank();
		b.setEmail1("uma@gmail.com");
		b.setPassword1("1234");
		int actual=BankService.customerLogin(b);
		assertEquals(0, actual);
	} */
	
	@Test
	public void Testlogin()
	{
		Bank b1=new Bank();
		b1.setEmail1("sai@gmail.com");
		b1.setPassword1("1234");
		int actual=BankService.Employeelogin(b1);
		assertEquals(0, actual);
	}
}
