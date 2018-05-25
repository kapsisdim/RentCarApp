
public class Customer {
    private String first_name;
    private String last_name;
    private String email;
    private int license;
    private int phone_number;
    
    
    //setters    
    public void setFirstName(String name)
    {
        this.first_name = name;
    }
    
    public void setLastName(String sir_name)
    {
        this.last_name = sir_name;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void setLicense(int license)
    {
        this.license = license;
    }
    
    public void setPhoneNumber(int phone_number)
    {
        this.phone_number = phone_number;
    }
    
    //getters    
    public String getFirstName()
    {
        return this.first_name;
    }
    
    public String getLastName()
    {
        return this.last_name;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public int getLicense()
    {
        return this.license;
    }
    
    public int getPhoneNumber()
    {
        return this.phone_number;
    }
    
	Customer(String first_name, String last_name, String email, int phone_number, int license) {
		setFirstName(first_name);
		setLastName(last_name);
		setEmail(email);
		setPhoneNumber(phone_number);
		setLicense(license);

	}	
}
