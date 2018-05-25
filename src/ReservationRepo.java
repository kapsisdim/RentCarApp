import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationRepo extends Database {

    //SQL STATEMENTS    
    public void insertReservation(int reservation_id, int customer_id, int store_id, String pick_up_date, String pick_up_time, String drop_out_location, String return_date, String return_time, int car_id, int total_cost)
    {    	
    	try{
    		Statement st = this.conn.createStatement();
    		int val = st.executeUpdate("INSERT INTO reservations VALUES(" + "'" +reservation_id+ "'" + "," + "'" +customer_id+ "'" + "," + "'" +car_id+ "'" + "," + "'" +store_id+ "'" + "," + "'" +pick_up_date+ "'" + "," + "'" +pick_up_time+ "'" + "," + "'" +drop_out_location+ "'" + "," + "'" +return_date+ "'" + "," + "'" +return_time+ "'" + "," + "'" +total_cost+ "'" +")" );
    	}catch(SQLException e){
    		System.out.println("SQL statement is not executed!");
    	}
    }
    
    //SQL PREPARED STATEMENTS
  	public void preparedInsertReservation(int customer_id, int store_id, String pick_up_date, String pick_up_time, String drop_out_location, String return_date, String return_time, int car_id, int total_cost)
  	{    	
		try{
			PreparedStatement statement = this.conn.prepareStatement("INSERT INTO reservations(customer_id, car_id, store_id, pick_up_date, pick_up_time, drop_out_location, return_date, return_time, car_id, total_cost) VALUES (?,?,?,?,?,?,?,?,?)");
			statement.setInt(1, customer_id);
			statement.setInt(2, car_id);
			statement.setInt(3, store_id);
			statement.setString(4, pick_up_date);
			statement.setString(5, pick_up_time);
			statement.setString(6, drop_out_location);
			statement.setString(7, return_date);
			statement.setString(8, return_time);
			statement.setInt(9, total_cost);
			statement.executeUpdate();    		
		}catch(Exception e) {
			System.out.println("SQL statement is not executed!");
		}
  	}
}
