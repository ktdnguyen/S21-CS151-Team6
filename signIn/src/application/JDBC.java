package application;

import java.sql.*;

public class JDBC {
	
	private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/walletmanager?serverTimezone=EST5EDT\\";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "Bobby";
	private static final String INSERT_QUERY = "INSERT INTO user (user_name, password) VALUES (?, ?)";

	
	public void insertRecord(String name, String  password) throws SQLException {
			
			// load and register JDBC driver for MySQL
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	        // Step 1: Establishing a Connection and 
			// try-with-resource statement will auto close the connection.
	        try (Connection connection = DriverManager
	            .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
	
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
	            preparedStatement.setString(1, name);
	            preparedStatement.setString(2, password);
	
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            // print SQL exception information
	            printSQLException(e);}
	        }
	        
	        public static void printSQLException(SQLException ex) {
	            for (Throwable e: ex) {
	                if (e instanceof SQLException) {
	                    e.printStackTrace(System.err);
	                    System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                    System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                    System.err.println("Message: " + e.getMessage());
	                    Throwable t = ex.getCause();
	                    while (t != null) {
	                        System.out.println("Cause: " + t);
	                        t = t.getCause();
	                    }
	                }
	            }
	    }
	        
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	
		}

}
