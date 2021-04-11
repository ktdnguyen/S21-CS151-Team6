package application;
import java.sql.*;

public class JDBC {
	
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/walletmanager?useSSL=false";
	
	// By default, database username is "root", user must input their correct values for DB_USERNAME and DB_PASSWORD
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "Bobby";
	private static final String INSERT_QUERY = "INSERT INTO user (user_name, password) VALUES (?, ?)";

	
	public void insertRecord(String username, String  password) throws SQLException {
			
			// load JDBC driver for MySQL
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	        // Establish connection
	        try (Connection connection = DriverManager
	            .getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	
	            // use connection obj to write statement
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);
	
	            System.out.println(preparedStatement);
	            // execute the prepared query
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
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
	
		}

}
