package Empmanage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public abstract class EmpStart implements connact {
	
	
	
	   
	     public static void main(String[] args) throws SQLException {
	    	 
//			Connaction DB
	    	 String url="jdbc:mysql://localhost:3306/empmanag";
	    	 String name="root";
	    	 String password="2004";
	    	 Connection con=DriverManager.getConnection(url, name, password);
	    	 Scanner scan =new Scanner(System.in);
	    	 AddEmp Employee= new AddEmp();
	    	 
	    	 System.out.println("Enter your choice");
	    	 System.out.println("1.Add Data");
	    	 System.out.println("2.Get Data");
	    	 System.out.println("3.Update Data");
	    	 System.out.println("4.Delete Data");
	    	 int choice =scan.nextInt();
	    	 
	    	 switch(choice) {
	    	 case 1:
	    		 Employee.AdEmp(con);
	    		 break;
	    	 case 2:
	    		 Employee.GetEmp(con);
	    		 break;
	    	 case 3:
	    		 Employee.UpEmp(con);
	    		 break;
	    	 case 4:
	    		 Employee.DelEmp(con);
	    		 break;
	    		 
	    	 }
	    	 
		}

}
