import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseRepository extends Database {

    //SQL STATEMENTS
    public void insertCar(int car_id, String size, int seates, int doors, String type, int price)
    {
    	try{
    		Statement st = this.conn.createStatement();  
    		int val = st.executeUpdate("INSERT INTO cars VALUES(" + "'" +car_id+ "'" + "," + "'" +size+ "'" + "," + "'" +seates+ "'" + ","+ "'" +doors+ "'" + "," + "'" +type+ "'" + ","+ "'" +price+ "'" + ")" );
    	}catch(SQLException e){
    		System.out.println("SQL statement is not executed!");
    	}
    }
    
    public void insertCustomer(int id, String first_name, String last_name, String email, int phone_number, int license)
    {
    	try{
    		Statement st = this.conn.createStatement();  
    		int val = st.executeUpdate("INSERT INTO customers VALUES(" + "'" +id+ "'" + "," + "'" +first_name+ "'" + "," + "'" +last_name+ "'" + ","+ "'" +email+ "'" + "," + "'" +phone_number+ "'" + ","+ "'" +license+ "'" + ")" );
    	}catch(SQLException e){
    		System.out.println("SQL statement is not executed!");
    	}  	
    }
    
    
    
    //SQL PREPARED STATEMENTS
    public void preparedInsertCar(String size, int seates, int doors, String type, int price)
    {
    	try{
    		PreparedStatement statement = this.conn.prepareStatement("INSERT INTO cars(size, seates, doors, type, price) VALUES (?,?,?,?,?)");
    		statement.setString(1, size);
    		statement.setInt(2, seates);
    		statement.setInt(3, doors);
    		statement.setString(4, type);
    		statement.setInt(5, price);
    		statement.executeUpdate();
    	}catch(Exception e) {
    		System.out.println("SQL statement is not executed!");
    	}
    }

    public void preparedInsertCustomer(String first_name, String last_name, String email, int phone_number, int license)
    {
    	try{
    		PreparedStatement statement = this.conn.prepareStatement("INSERT INTO cars(size, seates, doors, type, price) VALUES (?,?,?,?,?)");
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
	
	DatabaseRepository()
	{
		
	}
}
