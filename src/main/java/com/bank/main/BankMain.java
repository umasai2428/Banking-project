package com.bank.main;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bank.model.Bank;
import com.bank.service.BankService;

public class BankMain {
	private static final Logger log=LogManager.getLogger(BankMain.class);
	public static void main(String args[]) throws SQLException { 
		System.out.println("1.Customer Login");
		System.out.println("2.Employee login");
		System.out.println("Select Option ");
		Scanner sc1=new Scanner (System.in);
		int option=sc1.nextInt();
		switch (option) {
		
		case 1 :
			log.info("entering detailes to login");
			
		Scanner sc=new Scanner(System.in);
	    System.out.println("Enter EmailId");
	    String Email1=sc.next();
	    System.out.println("Enter Password");
	    String password1=sc.next();  
        Bank b=new Bank();
	    b.setEmail1(Email1);
	    b.setPassword1(password1);
	    
	   int userLogin= BankService.customerLogin(b);
	   
	    if(userLogin==0) {
	    	System.out.println("Invalid login deatils");
	    }
	    else if(userLogin==1) 
	{
	    	
	    System.out.println("welcome customer");
		System.out.println("Select Operation");
        System.out.println("1.Check Account Details And Status");
		System.out.println("2.View Balence");
		System.out.println("3.Deposit Money");
		System.out.println("4.Withdraw Money");
		System.out.println("5.Transfer Money");
		System.out.println("6.Exit");
		Scanner sc2=new Scanner(System.in);
		int option1=sc.nextInt();
		while(option1!=6) {
			
		
		switch(option1) {
		case 1:  //check account details
			   BankService.accountdetails(b);
			   System.out.println("Your Account Details");
		       System.out.println("AccountNumber: "+b.getAccno());
		       System.out.println("AccountStatus "+b.getStatus());
		       System.out.println("IfscNumber SBI001");
		break;
		
		case 2:  //view balance
			     BankService.customerviewbalance(b);
		        System.out.println(" Balance :"+b.getBalance());
		break;
		
		case 3: //deposit money
		        System.out.println("Enter Ammount");
		         int depositammount=sc2.nextInt();
		        
		        if(depositammount>0) {
		        	 b.setAmmount(depositammount);
		        	int result = BankService.customerdeposit(b);	 
		        	 if(result==1) 
		        	 {
			             System.out.println("Deposit successfull");
			             System.out.println("Your Current Balance is:"+b.getBalance());
			             
			          } else {System.out.println("Deposit failed");}
		        	 
		         }else{ System.out.println("Invalid Ammount"); }
		       
		break;
		
		case 4: //withdraw money
			System.out.println("Enter Ammount");
             int withdrawammount=sc2.nextInt();
             if(withdrawammount>0) {
             b.setAmmount(withdrawammount);
             int result= BankService.customerwithdraw(b);
             if(result==-1) {
            	 System.out.println("Insufficient Balance");
             }else if(result==1) {
            	 System.out.println("withdraw successful");
            	 System.out.println("Your Current Balance :"+b.getBalance()); 
            	 
             }else {System.out.println("withdraw failed");};
             
             }else { System.out.println("Invalid Ammount");}
			
		break;
		
		case 5: //Transfer money
			System.out.println("Enter Receipient Account Number");
			int receipientaccno=sc2.nextInt();
			System.out.println("Enter Ammount");
			int transferammount=sc2.nextInt();
		    if(transferammount>0) {
		    	b.setAmmount(transferammount);
		    	b.setReceipientacc(receipientaccno);
		    	int result =BankService.customertransfer(b);
		    	if(result==-1) {
		    		System.out.println("Insufficient Balance");
		    	}
		    	else if(result==1) {
		    		System.out.println("Transfersuccessful");
		    		System.out.println("Your Current Balance :"+b.getBalance());
		    	}else {System.out.println("Transfer Failed"); }
		    	
		    }else  {System.out.println("Invalid Amoount"); }
			
		break;
		
		default : System.out.println("Select Appropriate Option");
	     }  
		    System.out.println("");
	     
			System.out.println("Select Operation");
	        System.out.println("1.Check Account Details And Status");
			System.out.println("2.View Balence");
			System.out.println("3.Deposit Money");
			System.out.println("4.Withdraw Money");
			System.out.println("5.Transfer Money");
			System.out.println("6.Exit");
			 option1=sc2.nextInt();
			 
	} System.out.println("ThankYou!!");
}
	    
	 else if(userLogin==2) {
	  System.out.println("Details not found!!");
	  System.out.println("Kindly register");
	  System.out.println("Enter AdharNo");
		String adno=sc.next();
		
		System.out.println("Enter Full Name");
		String name=sc.next();
		
		System.out.println("Enter city");
		String city=sc.next();
		sc.nextLine();
		
	    System.out.println("Enter MobileNumber");
	    String Mno=sc.next();
	    sc.nextLine();
	    
	    System.out.println("Enter EmailId");
	    String Email2=sc.next();
	    
	    System.out.println("Set Password");
	    String password2=sc.next();
	  
	    System.out.println("Deposit Minimum rs 500/-");
	    int balance=sc.nextInt();
	    
	    b.setAdno(adno);
	    b.setName(name);
	    b.setCity(city);
	    b.setMno(Mno);
	    b.setEmail2(Email2);
	    b.setPassword2(password2);  
	    b.setBalance(balance);
	    
	   int result= BankService.register(b);
	    if (result==0) {
        System.out.println("Registration  succesfull");
        log.info("successfylly completed registration");
        //
        System.out.println("After verification your account will be Activate ");
        System.out.println("You can login with you Email and password and you can get your account details");
	    }
	    else { System.out.println("Registration failed");
	    }   
     }	    
  break;
		

		case 2:   
			log.info("entering detailes to login employee");
			Scanner sc3=new Scanner(System.in);
		    System.out.println("Enter EmailId");
		    String EmailEmployeeid=sc3.next();
		    System.out.println("Enter Password");
		    String passwordEmployee=sc3.next();  
	        Bank b1=new Bank();
		    b1.setEmail1(EmailEmployeeid);
		    b1.setPassword1(passwordEmployee); 
		    int result =BankService.Employeelogin(b1);
		   
		    if(result==1) {
		    	
		    	System.out.println("Welcome Employee");
		    	System.out.println("Select Operation");
		    	System.out.println("1. Open Account For Customer");
		    	System.out.println("2.Accept or Reject Account");
		    	System.out.println("3.View customer balance");
		    	System.out.println("4.Deposit Money");
		    	System.out.println("5.Withdraw Money");
		    	System.out.println("6.Transfer Money");
		    	System.out.println("7.Exit");
		    	
		    	Scanner sc4 =new Scanner(System.in);
		    	int option1=sc4.nextInt();
		        while(option1!=7) {
		        	
		    	switch(option1) {
		    	case 1:
		    		
		    		System.out.println("Enter AdharNo");
		    		String adno=sc4.next();
		    		
		    		System.out.println("Enter Full Name");
		    		String name=sc4.next();
		    		
		    		System.out.println("Enter city");
		    		String city=sc4.next();
		    		sc4.nextLine();
		    		
		    	    System.out.println("Enter MobileNumber");
		    	    String Mno=sc4.next();
		    	    sc4.nextLine();
		    	    
		    	    System.out.println("Enter EmailId");
		    	    String Email2=sc4.next();
		    	    
		    	    System.out.println("Set Password");
		    	    String password2=sc4.next();
		    	  
		    	    System.out.println("Deposit Minimum rs 500/-");
		    	    int balance=sc4.nextInt();
		    	    
		    	    b1.setAdno(adno);
		    	    b1.setName(name);
		    	    b1.setCity(city);
		    	    b1.setMno(Mno);
		    	    b1.setEmail2(Email2);
		    	    b1.setPassword2(password2);  
		    	    b1.setBalance(balance);
		    	    
		    		int result1=BankService.employeeregister(b1);
		    		if(result1==0) {
		    			System.out.println("Registration Sucessfull ");
		    			System.out.println("Customer can login with Emailid and Password");
		    			log.info("successfully registered employee login");
		    		}
		    		else { System.out.println("Registration Failed");}
		    		
		    		break;
		    	
		    	case 2: 
		    		    ResultSet rs=BankService.pending();
	    		    	System.out.println("pending accounts :");
		    		    while(rs.next()) {
		    		    	System.out.println("  "+rs.getInt(1));
		    		    }
		    		    System.out.println("Select operation");
		    		    System.out.println("1.Select Approve ");
		    		    System.out.println("2.Select Reject");
		    		    System.out.println("3.Exit");
		    		    int choice=sc4.nextInt();
		    		    while(choice!=3) {
		    		    	
		    		    switch(choice) {
		    		    case 1:
		    		    System.out.println("Enter Account Number");
				    	int accno=sc4.nextInt();
				    	b1.setAccno(accno);
				    	BankService.approve(b1);
				    	System.out.println("Account Approved");
				    	break;
				    	
		    		    case 2:
		    		    	System.out.println("Enter Account Number");
		    		    	accno =sc4.nextInt();
		    		    	b1.setAccno(accno);
		    		    	BankService.reject(b1);
				    	System.out.println("Account Rejected");
				    	break;
		    		    }
		    		    System.out.println("Select operation");
		    		    System.out.println("1.Select Account Number To Approve ");
		    		    System.out.println("2.Select Account Number To Reject");
		    		    System.out.println("3.Exit");
		    		     choice=sc4.nextInt();
		    		    }  
		    		    
		    		    
		    	break;
		    	
		    	case 3: 
		    		System.out.println("Enter Customer Account Number");
		    	      int accno=sc4.nextInt();
		    	    b1.setAccno(accno);
		    	    BankService.employeeviewbalance(b1);
		    	System.out.println("Balance : "+b1.getBalance());
		    	
		    		
		    	break;
		    	
		    	case 4: System.out.println("Enter Customer Account Number");
		    		    accno= sc4.nextInt();
		    		    System.out.println("Enter Ammount");
		    		    int ammount = sc4.nextInt();
		    		    b1.setAmmount(ammount);
		    		    b1.setAccno(accno);
		    		    int result11 =BankService.employeedeposit(b1);
		    		    if(result11==1) {
		    		    	System.out.println("Deposit successfull");
		    		    	System.out.println("Current balance :"+b1.getBalance());
		    		    }else { System.out.println("Deposit Failed");}
		    		    
		    		    break;
		    		    
		    	case 5: 	 
		    		
		    		 System.out.println("Enter Customer Account Number");
		    		    accno= sc4.nextInt();
		    		    System.out.println("Enter Ammount");
		    		     ammount = sc4.nextInt();
		    		     if(ammount>0) {
		    		    b1.setAmmount(ammount);
		    		    b1.setAccno(accno);
		    		    result1 =BankService.employeewithdraw(b1);
		    		    
		    		    if(result1==-1) {
		    		    	System.out.println("Insufficient Balance");
		    		    }
		    		    else if(result==1)
		    		    { 
		    		    	System.out.println("Withdrawl successfull");
		    		    	System.out.println("Current balance :"+b1.getBalance());
		    		    	
		    		    }
		    		    else { System.out.println("Withdrawl Failed");}
		    		    
		    		     }else { System.out.println("Invalid ammount");}
		    		     
		    		     break;
		    	case 6:
		    		System.out.println("Enter Sender Accnount Number");
		    		int senderacc=sc4.nextInt();
		    		b1.setAccno(senderacc);
		    		System.out.println("Enter Receipient Accnot Number");
		    		int receipientacc=sc4.nextInt();
		    		b1.setReceipientacc(receipientacc);
		    		System.out.println("Enter Ammount");
		    		ammount=sc4.nextInt();
		    		b1.setAmmount(ammount);
		    		if(ammount>0) {
		    			result1=BankService.employeetransfer(b1);
		    			if(result==-1) {
		    				System.out.println("Insufficient Balance");
		    			}
		    			else if(result==1) {
		    				System.out.println("Transaction successful");
		    				
		    				System.out.println("Sender Balance After Transaction :"+b1.getBalance());
		    			}else { System.out.println("Transaction Failed");}
		    			
	
		    			
		    		}else {System.out.println("Invalid ammount");}
		    		
		    		  break; 
		    	default : System.out.println("Select Appropriate Option");	  
		    		  
		    	}
		    	
		       System.out.println("");
		        
		       System.out.println("Select Operation");
		    	System.out.println("1. Open Account For Customer");
		    	System.out.println("2.Accept or Reject Account");
		    	System.out.println("3.View customer balance");
		    	System.out.println("4.Deposit Money");
		    	System.out.println("5.Withdraw Money");
		    	System.out.println("6.Transfer Money");
		    	System.out.println("7.Exit");
		    	
		          option1=sc4.nextInt();
		      } System.out.println("ThankYou!!");  
		        	
		    }     
		        else if (result==0) {
		    	System.out.println("Invalid login Details");
		    }
			break;
		}
		
	}
	

}