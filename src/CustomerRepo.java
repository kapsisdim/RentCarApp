import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerRepo extends Database {

	//SQL QUERIES
    public void insertCustomer(int id, String first_name, String last_name, String email, int phone_number, int license)
    {
    	try{
    		Statement st = this.conn.createStatement();  
    		int val = st.executeUpdate("INSERT INTO customers VALUES(" + "'" +id+ "'" + "," + "'" +first_name+ "'" + "," + "'" +last_name+ "'" + ","+ "'" +email+ "'" + "," + "'" +phone_number+ "'" + ","+ "'" +license+ "'" + ")" );
    	}catch(SQLException e){
    		System.out.println("SQL statement is not executed!");
    	}  	
    }
    
    //PREPARED STATEMENTS
    public void preparedInsertCustomer(String first_name, String last_name, String email, int phone_number, int license)
    {
    	try{
    		PreparedStatement statement = this.conn.prepareStatement("INSERT INTO customers(first_name, last_name, email, phone_number, license) VALUES (?,?,?,?,?)");
    		statement.setString(1, first_name);
    		statement.setString(2, last_name);
    		statement.setString(3, email);
    		statement.setInt(4, phone_number);
    		statement.setInt(5, license);
    		statement.executeUpdate();
    	}catch(Exception e) {
    		System.out.println("SQL statement is not executed!");
    	}
    }
    
}
