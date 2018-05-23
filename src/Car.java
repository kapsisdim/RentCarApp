
public class Car {
	
	private int car_id;
    private String size;
    private int seates;
    private int doors;
    private String type;
    private int price;
    
    //setters
    public void setCarId(int car_id)
    {
        this.car_id = car_id;
    }
    
    public void setSize(String size)
    {
        this.size = size;
    }
    
    public void setSeates(int seates)
    {
        this.seates = seates;
    }
    
    public void setDoors(int doors)
    {
        this.doors = doors;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public void setPrice(int price)
    {
        this.price = price;
    }
    
    //getters
    public int getCarId()
    {
        return this.car_id;
    }
    
    public String getSize()
    {
        return this.size;
    }
    
    public int getSeates()
    {
        return this.seates;
    }
    
    public int getDoors()
    {
        return this.doors;
    }
    
    public String getType()
    {
        return this.type;
    }
    
    public int getPrice()
    {
        return this.price;
    }    
    

	public Car(int id, String size, int seates, int doors, String type,int price) {
        setCarId(id);
        setSize(size);
        setSeates(seates);
        setDoors(doors);
        setType(type);
        setPrice(price);
	}

}
