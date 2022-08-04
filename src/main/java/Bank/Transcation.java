package Bank;
import java.lang.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Transcation {
	Scanner sc = new Scanner(System.in);
	float amount;
	int accountnum;
	float accBal;
	float totalBal = -1.0f;
	Statement state() throws SQLException {
	Connector conObj = new Connector();
	Connection con = conObj.connect();
	if(con != null) {
		System.out.println("Connection Successfull!");
	}
	Statement stmn=con.createStatement();
	return stmn;
	}
	public void deposite() throws SQLException {
		
		System.out.println("enter the account Number");
		accountnum=sc.nextInt();
		System.out.println("enter the amount to Deposite");
		amount=sc.nextFloat();
		if (amount<=0) {
			System.out.println("Deposite valid amount");
			System.exit(1);
		}
		else {
		    Statement stmn=state();
		    ResultSet rs=stmn.executeQuery("select bal from accounts where accno="+accountnum);
		    while(rs.next()) {
		    	accBal = rs.getFloat(1);
		    }
		    totalBal = (amount+accBal);
		    ResultSet rs1=stmn.executeQuery("update accounts set bal="+totalBal+" where accno="+accountnum);
		    if(rs1!=null) {
		    	System.out.println("Money Deposited");
				stmn.executeQuery("insert into transactions (ttype,tamount,bal,accno) values('deposite',"+amount+","+totalBal+","+accountnum+")");

				System.out.println("Balance: "+totalBal);
				System.exit(0);
		    }
		    else {
		    	System.out.println("Not Deposited");
		    	System.exit(1);
		    }
		
		}
	}

	public void withdrawl() throws SQLException {
		
		System.out.println("enter the account Number");
		accountnum=sc.nextInt();
		System.out.println("enter the amount to Withdrawl");
		amount=sc.nextFloat();
		
	    Statement stmn=state();
	    ResultSet rs=stmn.executeQuery("select bal from accounts where accno="+accountnum);
	    while(rs.next()) {
	    accBal = rs.getFloat(1);
	    }
	   
	    if(accBal<=0 & amount>accBal) {
	    	System.out.println("Insufficient Funds");
	    }
	    else {
	    	totalBal = (accBal-amount);
		    ResultSet rs1=stmn.executeQuery("update accounts set bal="+totalBal+" where accno="+accountnum);
		    if(rs1!=null) {
				System.out.println("Money Withdraw Sucessfully");
				stmn.executeQuery("insert into transactions (ttype,tamount,bal,accno) values('withdraw',"+amount+","+totalBal+","+accountnum+")");
				System.out.println("Balance : "+totalBal);
				System.exit(0);
		    }
		   }
	    
	 
    
	   
	    }
	

	public float viewBalance() throws SQLException {
		
		System.out.println("enter the account Number");
		accountnum=sc.nextInt();
	    Statement stmn=state();
	    ResultSet rs=stmn.executeQuery("select bal from accounts where accno="+accountnum);
		while(rs.next()) {
	    	return rs.getFloat(1);
		}
		return -1.0f;
	}

}
