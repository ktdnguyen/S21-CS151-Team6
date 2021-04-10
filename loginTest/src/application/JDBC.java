package application;

import java.sql.*;
public class JDBC {
	public static void main(String[] args) {
		String user = "root";
      String pw = "Bobby";
		
		try 
		{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/walletmanager?serverTimezone=EST5EDT", user, pw);
			Statement myStmt = myConn.createStatement();
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
	}

}
