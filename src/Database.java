import java.sql.*;

public class Database {

    protected Connection conn = null;
    protected String url = "jdbc:mysql://localhost:3306/";
    protected String db = "rent_car_db";
    protected String driver = "com.mysql.jdbc.Driver";
    protected String userName = "admin1";
    protected String pass = "1234";
        
    Database()
    {
		try{
			Class.forName(driver).newInstance();
			this.conn = DriverManager.getConnection(url+db,userName,pass);
			System.out.println("Connected to database");
		}catch(Exception e) {
			e.printStackTrace();		
		}      	
    }
    
}
