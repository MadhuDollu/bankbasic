package Amdocs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         try {
        	 Class.forName("oracle.jdbc.driver.OracleDriver");
        	 String url="jdbc:oracle:thin:@localhost:1521:orcl";
        	 String userName="scott";
        	 String password="tiger";
        	 Connection con= DriverManager.getConnection(url,userName,password);
        	 Statement stmn=con.createStatement();
        	 ResultSet rs=stmn.executeQuery("select * from customer");
        	 while(rs.next())
        	 {
        		 System.out.println("number:"+rs.getString(1)+"\nname:"+rs.getString(2)+"\nmobile:"+rs.getString(3)+"\nmail"+rs.getString(4)+"\naddress"+rs.getString(5));
        		 System.out.println();
        	 }
        	 if(con!=null) {
        		 System.out.println("Connected");
        	 }
        	 else
        		 System.out.println("Not Connected");
         } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         catch(ClassNotFoundException e)
         {
        	 e.printStackTrace();
         }
         finally {
         }
         }
	}


