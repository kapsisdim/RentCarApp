import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CarRepo extends Database {
	
	//SQL QUERIES
	public int selectCarPrice(int id)
	{
		int car_id = 0;

		ResultSet result;
		try{
			Statement st = this.conn.createStatement();
			result = st.executeQuery("SELECT price FROM cars WHERE car_id ="+id);
			
			if(result.next()){
				car_id = result.getInt(1);
			}
		}catch(SQLException e){
    		System.out.println("SQL statement is not executed!");
		}
		
		return car_id;
	}
	
    public void insertCar(int car_id, String size, int seates, int doors, String type, int price, int store_id)
    {
    	try{
    		Statement st = this.conn.createStatement();  
    		int val = st.executeUpdate("INSERT INTO cars VALUES(" + "'" +car_id+ "'" + "," + "'" +size+ "'" + "," + "'" +seates+ "'" + ","+ "'" +doors+ "'" + "," + "'" +type+ "'" + ","+ "'" +price+ "'" + "," + "'" +store_id+ "'" + ")" );
    	}catch(SQLException e){
    		System.out.println("SQL statement is not executed!");
    	}
    }
    
    public void selectAllCars()
    {
    	ResultSet result;
    	try{
	    	Statement st = this.conn.createStatement();
	    	result = st.executeQuery("SELECT * FROM cars");
	    	
	    	while (result.next()) {
	    		int car_id = result.getInt("car_id");
	    		String size = result.getString("size");
	    		int seates = result.getInt("seates");
	    		int doors = result.getInt("doors");
	    		String type = result.getString("type");
	    		int price = result.getInt("price");
	    		System.out.println("CAR ID :" +car_id+ " | SIZE :" +size+ " | SEATES :" +seates+ " | DOORS :" +doors+ " | TYPE :" +type+ " | PRICE :" +price+ "\n");
	    	}
	    	
    	}catch(SQLException e){
    		System.out.println("SQL statement is not executed!");
		}
    }
    
	public void getAvailableCars(int store_id, String pick_up_date, String return_date) {
		ResultSet car_result;
		try{
			Statement st = this.conn.createStatement();
			car_result = st.executeQuery("SELECT * FROM cars WHERE store_id = " +store_id);
			
			while (car_result.next()) {
				int car_id = car_result.getInt("car_id");
	    		String size = car_result.getString("size");
	    		int seates = car_result.getInt("seates");
	    		int doors = car_result.getInt("doors");
	    		String type = car_result.getString("type");
	    		int price = car_result.getInt("price");
				
				ResultSet reservation_result;
				try{
					Statement statement = this.conn.createStatement();
					reservation_result = statement.executeQuery("SELECT pick_up_date, return_date FROM reservations WHERE car_id = " +car_id);
					
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					
					try{
						Date your_pick_up_date = formatter.parse(pick_up_date);
						
						if (!reservation_result.next()) {
				    		System.out.println("CAR ID :" +car_id+ " | SIZE :" +size+ " | SEATES :" +seates+ " | DOORS :" +doors+ " | TYPE :" +type+ " | PRICE :" +price+ "\n");	

						} else {
							while (reservation_result.next()) {
								
								Date pickUpDate = reservation_result.getDate("pick_up_date");
								Date returnDate = reservation_result.getDate("return_date");
														
								if (your_pick_up_date.after(returnDate)) {
						    		System.out.println("CAR ID :" +car_id+ " | SIZE :" +size+ " | SEATES :" +seates+ " | DOORS :" +doors+ " | TYPE :" +type+ " | PRICE :" +price+ "\n");	
					    		}
							}
						}
						
					}catch(ParseException e) {
						System.out.println("Wrong date format!");
					}
					
				}catch(SQLException e){
		    		System.out.println("SQL statement is not executed!");
				}
				
			}
			
		}catch(SQLException e){
    		System.out.println("SQL statement is not executed!");
		}
		
	}
    
    public void deleteCar(int car_id)
    {
    	try{
    		Statement st = this.conn.createStatement();
    		st.executeUpdate("DELETE FROM cars WHERE car_id = "+car_id);
    		
    	}catch(SQLException e){
    		System.out.println("SQL statement is not executed!");
    	}
    }

    public void getRentedCars(int store_id)
    {
    	ResultSet reservation_result;
    	
    	try{
    		Statement st = this.conn.createStatement();
			reservation_result = st.executeQuery("SELECT pick_up_date, return_date, car_id FROM reservations WHERE store_id = " +store_id);
			
			if(reservation_result.next()) {
	    		do {
	    			Date reservation_pick_up_date = reservation_result.getDate("pick_up_date");
	    			Date reservation_return_date = reservation_result.getDate("return_date");
		    		int car_id = reservation_result.getInt("car_id");
	    			Date current_date = new Date();
	    			
	    			if(current_date.before(reservation_return_date) && current_date.after(reservation_pick_up_date) ) {
	    			
	    				System.out.println("The rented cars are :");
	    				
	    	    		ResultSet car_result;
	    	    		
	    	    		try {
	    	    			Statement statement = this.conn.createStatement();
	    					car_result = statement.executeQuery("SELECT * FROM cars WHERE car_id = " +car_id);
	    					
	    					if(car_result.next()) {
	    						while (car_result.next()) {
			    		    		String size = car_result.getString("size");
			    		    		int seates = car_result.getInt("seates");
			    		    		int doors = car_result.getInt("doors");
			    		    		String type = car_result.getString("type");
			    		    		int price = car_result.getInt("price");
			    		    		
						    		System.out.println("CAR ID :" +car_id+ " | SIZE :" +size+ " | SEATES :" +seates+ " | DOORS :" +doors+ " | TYPE :" +type+ " | PRICE :" +price+ "\n");
	    						}
	    					}
	    	    			
	    	    		}catch(SQLException e) {
	    	        		System.out.println("SQL Statement is not executed!");
	    	        	}
	    	    		
	    			} else {
	    				System.out.println("-");
	    			}
	    			
	    		}while (reservation_result.next());
	    		
	    		
			} else {
				System.out.println("At this time there are no rented cars from this store!");
			}
				    		
    	}catch(SQLException e) {
    		System.out.println("SQL Statement is not executed!");
    	}
    }
    
    //SQL PREPARED STATEMENTS
    public void preparedInsertCar(String size, int seates, int doors, String type, int price, int store_id)
    {
    	try{
    		PreparedStatement statement = this.conn.prepareStatement("INSERT INTO cars(size, seates, doors, type, price, store_id) VALUES (?,?,?,?,?,?)");
    		statement.setString(1, size);
    		statement.setInt(2, seates);
    		statement.setInt(3, doors);
    		statement.setString(4, type);
    		statement.setInt(5, price);
    		statement.setInt(6, store_id);
    		statement.executeUpdate();
    	}catch(Exception e) {
    		System.out.println("SQL statement is not executed!");
    	}
    }
}
