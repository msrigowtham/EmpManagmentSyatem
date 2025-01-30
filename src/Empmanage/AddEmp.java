package Empmanage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AddEmp implements connact { //class addemp id implements tha connact interface
	Scanner scan=new Scanner(System.in);//scanner

//	Add method
	
	public void AdEmp(Connection con) throws SQLException {
		
//		Local date method
		
		LocalDate join = LocalDate.now();
		DateTimeFormatter form=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formate =form.format(join);
		
//		query to add data
		
		String add_query="Insert into emp(id,name,salary,data) value(?,?,?,?)";
		System.out.println("Enter id ");
		int id=scan.nextInt();
		System.out.println("Enter name");
		String name1=scan.next();
		System.out.println("Enter salary ");
		int salary=scan.nextInt();
		
//		sent query to database
		
		PreparedStatement per= con.prepareStatement(add_query);
		per.setInt(1,id);
		per.setString(2, name1);
		per.setInt(3, salary);
		per.setString(4, formate);
		int value=per.executeUpdate();
		System.out.println("Data added successfully");
		
		// TODO Auto-generated method stub
		
	}
	
//	get or view the data

	@Override
	public void GetEmp(Connection con) throws SQLException {
		
//		date
		LocalDate join = LocalDate.now();
		DateTimeFormatter form=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formate =form.format(join);
		
//		sent query to database
		
		String get_query="SELECT * FROM emp";
		Statement sta= con.createStatement();
		ResultSet res=sta.executeQuery(get_query);
		
//		get tha data in database and stored in variable
		
		while(res.next()) {
			int id =res.getInt("Id");
			String name1=res.getString("Name");
			int salary=res.getInt("Salary");
			String Date=res.getString("data");			
			System.out.println("id"+id+"    "+"Name"+name1+"     "+"Salary"+salary+"    "+"Date "+Date);
		}
		// TODO Auto-generated method stub
		
	}
	
//	Update the data

	@Override
	public void UpEmp(Connection con) throws SQLException {
		
//		date
		
		LocalDate join = LocalDate.now();
		DateTimeFormatter form=DateTimeFormatter.ofPattern("dd-MM-yyyy:ss.SS");
		Instant now = Instant.now();
		String formate =form.format(now);
		
//		add Update data
		
		  System.out.println("Enter Id");
		  int id =scan.nextInt();
		  System.out.println("Enter Name");
		  String name1=scan.next();
		  System.out.println("Enter Salary");
		  int salary=scan.nextInt();
		  
//		  send update query to database
		  
		  String up_query="UPDATE emp SET name=?,salary=?,data=? WHERE id=?";
		  PreparedStatement per=con. prepareStatement(up_query);
		  per.setInt(1,id);
		  per.setString(2,name1);
		  per.setInt(3,salary);
		  per.setString(4, formate);
		  per.executeUpdate();
		  
		  System.out.println("Updated successfully");
		// TODO Auto-generated method stub
		
	}

//	Delete the data
	
	@Override
	public void DelEmp(Connection con) throws SQLException {
		
//		enter tha id to delete column
		System.out.println("Enter id");
		int id=scan.nextInt();
		
//		send query to delete data to database
		
		String D_query="DELETE FROM emp WHERE id=?";
		PreparedStatement per=con.prepareStatement(D_query);
		per.setInt(1,id);
		per.executeUpdate();
		
		System.out.println("Delete successfully");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EmpDetails(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		
	}	

}
