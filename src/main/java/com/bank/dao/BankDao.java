package com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.bank.model.Bank;


public class BankDao {
	
	public static int customerLogin(Bank b) 
{
		String url="jdbc:mysql://localhost:3306/onlinebank";
		String root="root";
		String password="SaiNaidu2428@";
		int customerLoginSuccess=0;
		try {
			Connection con= DriverManager.getConnection(url, root, password);
			PreparedStatement pstcustomerlogin=con.prepareStatement("Select * from customer where Email=? ;");
			pstcustomerlogin.setString(1, b.getEmail1());
  	     ResultSet rs= pstcustomerlogin.executeQuery();
  	     if(rs.next()) {
  	    	PreparedStatement pst1=con.prepareStatement("select * from customer where email=?and password=?;");
  	         pst1.setString(1, b.getEmail1());
  	         pst1.setString(2, b.getPassword1());
  			 ResultSet rs1=pst1.executeQuery();
  			
  			 
  			 if(rs1.next()) {
  				customerLoginSuccess=1;//login success
  			 }
  			 else { customerLoginSuccess=0; }//invalid details
  	    	 
  	     }else { customerLoginSuccess=2;}// details not found
  	    
		} catch (SQLException e) {	
		 e.printStackTrace();
		}
		return customerLoginSuccess;
}

	public static int register(Bank b)
{   		
              
		
		String url="jdbc:mysql://localhost:3306/onlinebank";
		String root="root";
		String password="SaiNaidu2428@";
		
		try {
			Connection con =DriverManager.getConnection(url, root, password);
			PreparedStatement pst=con.prepareStatement("Insert into customer(Adno,Name,city,phonenumber,Email,password,balance) values(?,?,?,?,?,?,?);");
			pst.setString(1,b.getAdno());         
			pst.setString(2,b.getName());
			pst.setString(3,b.getCity());
			pst.setString(4,b.getMno());
			pst.setString(5,b.getEmail2());
			pst.setString(6,b.getPassword2());
			pst.setInt(7, b.getBalance());
			pst.executeUpdate();
		 }	
				
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
		
}

	public static void accountdetials(Bank b) {

		String url="jdbc:mysql://localhost:3306/onlinebank";
		String root="root";
		String password="SaiNaidu2428@";
		try {
			Connection con =DriverManager.getConnection(url, root, password);
     PreparedStatement pstaccdetails=con.prepareStatement("Select accno,status from customer where email=? and password=?");
         pstaccdetails.setString(1, b.getEmail1());
         pstaccdetails.setString(2, b.getPassword1());
            ResultSet rs= pstaccdetails.executeQuery();
            
              rs.next();
            int c= rs.getInt(1);
            b.setAccno(c);
        	String d =rs.getString(2);
        	b.setStatus(d);
                 
		 }	
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void customerviewbalance(Bank b) {
		
		String url="jdbc:mysql://localhost:3306/onlinebank";
		String root="root";
		String password="SaiNaidu2428@";
		
		try {
			Connection con=DriverManager.getConnection(url, root, password);
			PreparedStatement pstcustviewbalance=con.prepareStatement("select balance from customer where email=? and password=? ;");
			pstcustviewbalance.setString(1, b.getEmail1());
			pstcustviewbalance.setString(2,b.getPassword1());
			
			ResultSet rs=pstcustviewbalance.executeQuery();
			rs.next();
			int c=rs.getInt(1);
			b.setBalance(c);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public static int customerdeposit(Bank b) {
		String url="jdbc:mysql://localhost:3306/onlinebank";
		String root="root";
		String password="SaiNaidu2428@";
		int result=0;
		try {
			Connection con=DriverManager.getConnection(url, root, password);
			PreparedStatement pstcustviewbalance=con.prepareStatement("select balance from customer where email=? and password=? ;");
			pstcustviewbalance.setString(1, b.getEmail1());
			pstcustviewbalance.setString(2,b.getPassword1());
			
			ResultSet rs=pstcustviewbalance.executeQuery();
			rs.next();
			int balance =rs.getInt(1); //balance
			int ammount=b.getAmmount();
		    int add = balance+ammount;
  PreparedStatement pstcustdeposit =con.prepareStatement("Update customer set balance=? where email=? and password= ?;");
                   pstcustdeposit.setInt(1, add);
                   pstcustdeposit.setString(2, b.getEmail1());
                   pstcustdeposit.setString(3,b.getPassword1());
                   
               result= pstcustdeposit.executeUpdate();
   	    b.setBalance(add);//gives updated balance
      if(result==pstcustdeposit.executeUpdate()) {
    	  return 1; 
    	  } else return 0;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
		
		
	}
	
	public static int customerwithdraw(Bank b) {
		
		String url="jdbc:mysql://localhost:3306/onlinebank";
		String root="root";
		String password="SaiNaidu2428@";
		int result=-1;
		try {
			Connection con=DriverManager.getConnection(url, root, password);
			PreparedStatement pstcustviewbalance=con.prepareStatement("select balance from customer where email=? and password=? ;");
			pstcustviewbalance.setString(1, b.getEmail1());
			pstcustviewbalance.setString(2,b.getPassword1());
			
			ResultSet rs=pstcustviewbalance.executeQuery();
			rs.next();
			int balance =rs.getInt(1); 
			int ammount=b.getAmmount();
			
	if(ammount<balance) {		
		    int sub = balance-ammount;
  PreparedStatement pstcustwithdraw =con.prepareStatement("Update customer set balance=? where email=? and password= ?;");
                   pstcustwithdraw.setInt(1, sub);
                   pstcustwithdraw.setString(2, b.getEmail1());
                   pstcustwithdraw.setString(3,b.getPassword1());
                result= pstcustwithdraw.executeUpdate();
                   b.setBalance(sub);
               	if(result==pstcustwithdraw.executeUpdate()) {
            		return result=1;
            	}else return result=0;
    }
	else  { return result; }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}return result;
	
}
	
	public static int customertransfer(Bank b) {
		String url="jdbc:mysql://localhost:3306/onlinebank";
		String root="root";
		String password="SaiNaidu2428@";
		int result=-1;
		try {
			Connection con=DriverManager.getConnection(url, root, password);
			PreparedStatement pstcustviewbalance=con.prepareStatement("select balance from customer where email=? and password=? ;");
			pstcustviewbalance.setString(1, b.getEmail1());
			pstcustviewbalance.setString(2,b.getPassword1());
			ResultSet rs=pstcustviewbalance.executeQuery();
			rs.next();
			
			int senderoldbalance =rs.getInt(1); 
			int ammount=b.getAmmount();
			int receipentaccno=b.getReceipientacc();
			
		PreparedStatement pstreceipient =con.prepareStatement("select balance from customer where accno=?");
		pstreceipient.setInt(1, receipentaccno);
		ResultSet rs1=pstreceipient.executeQuery();
		rs1.next();
		int receipientoldbalance = rs1.getInt(1);
			
			if(ammount<senderoldbalance) {
				int sub = senderoldbalance-ammount; 
				b.setBalance(sub);
				int add=   receipientoldbalance+ammount;
	PreparedStatement pstupdatesender = con.prepareStatement("update customer set balance=? where email=? and password=?");	
                      pstupdatesender.setInt(1, sub);
                      pstupdatesender.setString(2, b.getEmail1());
                      pstupdatesender.setString(3,b.getPassword1());
                    int result1=  pstupdatesender.executeUpdate();
				
    PreparedStatement pstupdatereceiver = con.prepareStatement("update customer set balance=? where accno=?");	
                      pstupdatereceiver.setInt(1,add);
                      pstupdatereceiver.setInt(2,b.getReceipientacc());
                    int result2=  pstupdatereceiver.executeUpdate(); 
                    
               if(result1==pstupdatesender.executeUpdate()&&result2==pstupdatereceiver.executeUpdate()) {
            	   return result=1;
               }else {  return result=0;  }
               
			}
			else return -1; 
	 }catch (SQLException e) {
		
		e.printStackTrace();
       }
		return result;
   }
	
	public static int EmployeeLogin(Bank b) {
		int result = 5;
	 try {
		 String url="jdbc:mysql://localhost:3306/onlinebank";
			String root="root";
			String password="SaiNaidu2428@";
		Connection con = DriverManager.getConnection(url, root, password);
		PreparedStatement pstemplogin=con.prepareStatement("select * from employee where email=? and password=?");
		pstemplogin.setString(1,b.getEmail1());
		pstemplogin.setString(2,b.getPassword1());
		ResultSet rs =pstemplogin.executeQuery();
		if(rs.next()) {
			return result =1;
		}
		else return result=0;
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	return	result;
	}
	public static void Employeeviewbalance(Bank b) {
		 String url="jdbc:mysql://localhost:3306/onlinebank";
			String root="root";
			String password="SaiNaidu2428@";
      try {
		Connection con =DriverManager.getConnection(url, root, password);
		PreparedStatement pstbalance = con.prepareStatement("select balance from customer where accno=?"); 
		pstbalance.setInt(1, b.getAccno());
		ResultSet rs=pstbalance.executeQuery();
		rs.next();
	    int balance=rs.getInt(1);
	    b.setBalance(balance);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}
	public static int employeedeposit(Bank b) {
		String url="jdbc:mysql://localhost:3306/onlinebank";
		String root="root";
		String password="SaiNaidu2428@";
		int result =0;
  try {
	Connection con =DriverManager.getConnection(url, root, password);
	PreparedStatement pstbalance = con.prepareStatement("select balance from customer where accno=?"); 
	pstbalance.setInt(1, b.getAccno());
	ResultSet rs=pstbalance.executeQuery();
	rs.next();
    int balance=rs.getInt(1);
    int ammount=b.getAmmount();
    int add=balance+ammount;
    PreparedStatement pstupdate =con.prepareStatement("update customer set balance=? where accno=?");
    pstupdate.setInt(1, add);
    pstupdate.setInt(2, b.getAccno());
   result =  pstupdate.executeUpdate();
   if(result==pstupdate.executeUpdate())
   {   b.setBalance(add);
	   return result=1;
   }
   else {return result;}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
    return result;
		
	}
	public static int employeewithdraw(Bank b) {
		String url="jdbc:mysql://localhost:3306/onlinebank";
		String root="root";
		String password="SaiNaidu2428@";
		int result =-1;
  try {
	Connection con =DriverManager.getConnection(url, root, password);
	PreparedStatement pstbalance = con.prepareStatement("select balance from customer where accno=?"); 
	pstbalance.setInt(1, b.getAccno());
	ResultSet rs=pstbalance.executeQuery();
	rs.next();
    int balance=rs.getInt(1);
    int ammount=b.getAmmount();
    if(ammount<balance) {
    int sub=balance-ammount;
    PreparedStatement pstupdate =con.prepareStatement("update customer set balance=? where accno=?");
    pstupdate.setInt(1, sub);
    pstupdate.setInt(2, b.getAccno());
   result =  pstupdate.executeUpdate();
   if(result==pstupdate.executeUpdate())
   {   b.setBalance(sub);
	   return result=1;
   }
   else {return result=0;}
   
    }else { return result;}	
    
	} catch (SQLException e) {
		e.printStackTrace();
	}
  
    return result;
		
	}
	public static int employeetransfer(Bank b) {
		String url="jdbc:mysql://localhost:3306/onlinebank";
		String root="root";
		String password="SaiNaidu2428@";
		int result =-1;
  try {
	Connection con =DriverManager.getConnection(url, root, password);
	PreparedStatement pstsenderbalance = con.prepareStatement("select balance from customer where accno=?"); 
	pstsenderbalance.setInt(1, b.getAccno());   //account no has sender account number
	ResultSet rs=pstsenderbalance.executeQuery();
	rs.next();
    int senderbalance=rs.getInt(1);
    
    int ammount=b.getAmmount();
    
    PreparedStatement pstreceipientbalance = con.prepareStatement("select balance from customer where accno=?"); 
	pstreceipientbalance.setInt(1, b.getReceipientacc());   // receiver account number
	ResultSet rs1=pstreceipientbalance.executeQuery();
	rs1.next();
	int receipientbalance=rs1.getInt(1);
    if(ammount<senderbalance) {
    	
    	int sub= senderbalance-ammount;
    	b.setBalance(sub);
    	
    	int add =receipientbalance+ammount;
    	
    	PreparedStatement pstsenderbalanceupdate = con.prepareStatement("update customer set balance=? where accno=?"); 
    	pstsenderbalanceupdate.setInt(1, sub);
    	pstsenderbalanceupdate.setInt(2, b.getAccno());   
    	result=pstsenderbalanceupdate.executeUpdate();
    	
    	PreparedStatement pstsreceipientbalanceupdate = con.prepareStatement("update customer set balance=? where accno=?"); 
    	pstsreceipientbalanceupdate.setInt(1, add);
    	pstsreceipientbalanceupdate.setInt(2, b.getReceipientacc());   
    	int result1=pstsreceipientbalanceupdate.executeUpdate();
    	
    	if(result==pstsenderbalanceupdate.executeUpdate() && result1==pstsreceipientbalanceupdate.executeUpdate()) {
    		return result=1;
    	}else return result=0;
    		
    }else return result=-1;
    
	}catch (SQLException e) {
		e.printStackTrace();
	}
return result;
  
}
	public static ResultSet pending() {
		
		ResultSet rs=null;
	
		String url="jdbc:mysql://localhost:3306/onlinebank";
		String root="root";
		String password="SaiNaidu2428@";
	
  try {
	Connection con =DriverManager.getConnection(url, root, password);
	PreparedStatement pstpending= con.prepareStatement("select Accno from customer where status=?"); 
	String pending="pending";
	pstpending.setString(1,pending);
     rs =pstpending.executeQuery();
   return rs;
  
	}catch (SQLException e) {
		e.printStackTrace();
	}
return rs;

}
	public static void approve(Bank b) {

		String url="jdbc:mysql://localhost:3306/onlinebank";
		String root="root";
		String password="SaiNaidu2428@";
		
  try {
	Connection con =DriverManager.getConnection(url, root, password);
	PreparedStatement pstapprove= con.prepareStatement("Update customer set status='Approved' where accno=?"); 
    pstapprove.setInt(1,b.getAccno());
	pstapprove.executeUpdate();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
 }
	public static void reject(Bank b) {
		String url="jdbc:mysql://localhost:3306/onlinebank";
		String root="root";
		String password="SaiNaidu2428@";
		
  try {
	Connection con =DriverManager.getConnection(url, root, password);
	PreparedStatement pstapprove= con.prepareStatement("Update customer set status='Rejected' where accno=?"); 
    pstapprove.setInt(1,b.getAccno());
	pstapprove.executeUpdate();
	}catch (SQLException e) {
		e.printStackTrace();
	}
		
	}
	public static int employeeregister(Bank b) {
		String url="jdbc:mysql://localhost:3306/onlinebank";
		String root="root";
		String password="SaiNaidu2428@";
		try {
			Connection con =DriverManager.getConnection(url, root, password);
			PreparedStatement pst=con.prepareStatement("Insert into customer(Adno,Name,city,phonenumber,Email,password,balance,status) values(?,?,?,?,?,?,?,?);");
			pst.setString(1,b.getAdno());         
			pst.setString(2,b.getName());
			pst.setString(3,b.getCity());
			pst.setString(4,b.getMno());
			pst.setString(5,b.getEmail2());
			pst.setString(6,b.getPassword2());
			pst.setInt(7, b.getBalance());
			pst.setString(8, "Approved");
			pst.executeUpdate();
		 }	
				
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
	
}