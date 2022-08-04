package Bank;
import java.sql.SQLException;
import java.lang.*;
import java.util.Scanner;
public class Menu {

	public static void main(String[] args) throws SQLException {
		int option = -1;
		float bal=0;
		Scanner sc = new Scanner(System.in);
		Account acc = new Account();
		Transcation tst = new Transcation();
		
		System.out.println("Welcome to Bank!");
		System.out.println("Choose\n"
				+ "1. Create Account\n"
				+"2. Deposite\n"
				+"3. Withdraw\n"
				+"4. View Balance");
		option = sc.nextInt();
		
		switch(option){
		case 1: acc.create();break;
		case  2: tst.deposite();break;
		case 3: tst.withdrawl();break;
		case 4: bal=tst.viewBalance();
	            System.out.println("Balance : "+bal);break;
		default :System.out.println("Enter Valid Opition");
		}
	

	sc.close();
	System.exit(0);
	}

}
