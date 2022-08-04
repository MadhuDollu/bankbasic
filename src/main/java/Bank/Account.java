package Bank;
import java.lang.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Account {

	public void create() throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("entere Customer name");
		String customerName=sc.nextLine();
		System.out.println("enter customer moblie number");
		String phoneNO=sc.nextLine();
		System.out.println("enter customer email");
		String email=sc.nextLine();
		System.out.println("enter customer Address");
		String  addr=sc.nextLine();
		String accountType=null;
		int chooseAcc;
		System.out.println("Choose account type\n1.Savings\n2. Current");
		chooseAcc = sc.nextInt();
		switch(chooseAcc) {
		case 1: accountType = "Savings"; break;
		case 2: accountType = "Current"; break;
		default: System.out.println("Invalid Account Type!");
		}
		ResultSet cId;
		ResultSet res = null;
		int customerId = -1;
		Connector conObj = new Connector();
		Connection con = conObj.connect();
		if(con != null) {
			System.out.println("Connection Successfull!");
		}
		Statement stmn=con.createStatement();
		PreparedStatement ps = con.prepareStatement("insert into customer(cname,mobile,email,address ) values (?, ?, ?, ?)");
		ps.setString(1, customerName);
		ps.setString(2, phoneNO);
		ps.setString(3, email);
		ps.setString(4, addr);
		int i = ps.executeUpdate();
   	    cId=stmn.executeQuery("select cid from customer where mobile = "+phoneNO);
   	    while(cId.next()) {
   	    	customerId = cId.getInt(1);
   	    	
   	    }
   	    if(customerId != -1) {
   	    	PreparedStatement ps1 = con.prepareStatement("insert into accounts (acctype,bal,cid) values (?, ?, ?)");
   	    	ps1.setString(1, accountType);
   	    	ps1.setFloat(2, 0.0f);
   	    	ps1.setInt(3, customerId);
   	    	i = ps1.executeUpdate();
   	    	System.out.println("Account Created");
   	    }
   	    
   	    else {
   	    	System.out.println("Account Not created");
   	    	System.exit(1);
   	    }
   	    con.close();
		sc.close();
		System.exit(0);
	}

}
