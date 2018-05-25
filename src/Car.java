
public class Car {

    private String size;
    private int seates;
    private int doors;
    private String type;
    private int price;
    private int store_id;
    
    //setters    
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
    
    public void setStoreId(int store_id)
    {
    	this.store_id = store_id;
    }
    
    //getters    
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
    
    public int getStoreId()
    {
    	return this.store_id;
    }
    

	public Car(String size, int seates, int doors, String type, int price, int store_id) {
        setSize(size);
        setSeates(seates);
        setDoors(doors);
        setType(type);
        setPrice(price);
        setStoreId(store_id);
	}

}
