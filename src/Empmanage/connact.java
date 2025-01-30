package Empmanage;

import java.sql.Connection;
import java.sql.SQLException;

public interface connact {
	
	
	void AdEmp(Connection con) throws SQLException;
	void GetEmp(Connection con) throws SQLException;
	void UpEmp(Connection con) throws SQLException;
	void DelEmp(Connection con) throws SQLException;
    void EmpDetails(Connection con) throws SQLException;
	 

}
