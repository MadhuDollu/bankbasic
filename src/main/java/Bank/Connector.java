package Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	Connection connect(){
		Connection con;
			try {
		
		   	 Class.forName("oracle.jdbc.driver.OracleDriver");
		   	 String url="jdbc:oracle:thin:@localhost:1521:orcl";
		   	 String userName="scott";
		   	 String password="tiger";
		   	 con= DriverManager.getConnection(url,userName,password);
		   	 
		   	 if(con!=null) {
		   		 //System.out.println("Connected");
		   		 return con;
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
		//    	System.out.println("Not Connected!");
		    }
		return null;
	}
	
}
