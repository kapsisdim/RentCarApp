import java.text.SimpleDateFormat;
import java.util.Date;


public class Reservation {

    private int reservation_id;
    private int customer_id;
    private int car_id;
    private int store_id;
    private String pick_up_date;
    private String pick_up_time;
    private String drop_out_location;
    private String return_date;
    private String return_time;
    private int total_cost;
    
    public int calculateTotalCost(String pick_up_date, String return_date, int car_id)
    {        
    	int total_cost = 0;
    	CarRepo car = new CarRepo();
    	long diffDays = 0;
    	
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
        	Date date1 = format.parse(pick_up_date);
        	Date date2 = format.parse(return_date);
        	
        	long diff = date2.getTime() - date1.getTime();
        	
        	diffDays = diff / (24 * 60 * 60 * 1000);
        	
        }catch(Exception e){
        	System.out.println("Wrong input!");
        }
        
        int price = car.selectCarPrice(car_id);
        
        total_cost = (int) (diffDays * price);
        
		return total_cost;
    }
    
    //setters    
    public void setReservationId(int reservation_id)
    {
        this.reservation_id = reservation_id;
    }
    
    public void setCustomerId(int customer_id)
    {
        this.customer_id = customer_id;
    }
        
    public void setCarId(int car_id)
    {
        this.car_id = car_id;
    }
            
    public void setStoreId(int store_id)
    {
        this.store_id = store_id;
    }
    
    public void setPickUpDate(String pick_up_date)
    {
        this.pick_up_date = pick_up_date;
    }    

    public void setPickUpTime(String pick_up_time)
    {
        this.pick_up_time = pick_up_time;
    }    

    public void setDropOutLocation(String drop_out_location)
    {
        this.drop_out_location = drop_out_location;
    }

    public void setReturnDate(String return_date)
    {
        this.return_date = return_date;
    }

    public void setReturnTime(String return_time)
    {
        this.return_time = return_time;
    }
    
    public void setTotalCost(String pick_up_date, String return_date, int car_id)
    {
    	this.total_cost = calculateTotalCost(pick_up_date, return_date, car_id);
    }
        
    //getters
    public int getReservationId()
    {
        return this.reservation_id;
    }
    
    public int getCustomerId()
    {
        return this.customer_id;
    }
        
    public int getCarId()
    {
        return this.car_id;
    }
            
    public int getStoreId()
    {
        return this.store_id;
    }
                
    public int getTotalCost()
    {
        return this.total_cost;
    }
    
    public String getPickUpDate()
    {
        return this.pick_up_date;
    }    

    public String getPickUpTime()
    {
        return this.pick_up_time;
    }    

    public String getDropOutLocation()
    {
        return this.drop_out_location;
    }

    public String getReturnDate()
    {
        return this.return_date;
    }

    public String getReturnTime()
    {
        return this.return_time;
    }
    
    Reservation(int customer_id, int store_id, int car_id, String pick_up_date, String pick_up_time, String drop_out_location, String return_date, String return_time)
    {
        setCustomerId(customer_id);
        setStoreId(store_id);
        setCarId(car_id);
        setPickUpDate(pick_up_date);
        setPickUpTime(pick_up_time);
        setDropOutLocation(drop_out_location);
        setTotalCost(pick_up_date, return_date, car_id);
    }	
}
