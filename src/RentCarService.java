import java.util.ArrayList;
import java.util.Scanner;


public class RentCarService {

	private DatabaseRepository db;
	ArrayList<Car> carList = new ArrayList<Car>();
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	

	public void createCars()
	{
		int input = 0;
		String choice = " ";
		String size= "";
		String type = "";
		int seates = 0;
		int doors = 0;
		int price = 0;
        Scanner r = new Scanner(System.in);
		
		do {
			System.out.println("\n ----Creating new car---- \n");
			System.out.println("Enter the size of the car (small, medium, large) :");
			size = r.nextLine();
			
			System.out.println("Enter the number of seates in the car :");
			try{
				seates = Integer.parseInt(r.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Wrong input! Try again! \n");
			}
			
			System.out.println("Ener the number of doors the car has :");
			try{
				doors = Integer.parseInt(r.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Wrong input! Try again! \n");
			}
			
			System.out.println("Is the type of car basic? (y/n)");
			choice = r.nextLine();
			if (choice.equals("y")) {
				type = "basic";
				
			} else {
				System.out.println("Does it use gas or diesel?");
				type = r.nextLine();
			}
			
			System.out.println("Enter the rent price per day :");
			try{
				price = Integer.parseInt(r.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Wrong input! Try again! \n");
			}
			
			Car car = new Car(0, size, seates, doors, type, price);
			
			this.db.insertCar(0, size, seates, doors, type, price);
			//db.preparedInsertCar(size, seates, doors, type, price);
			
			
			System.out.println("To enter new car press [1]. To exit press [0]");
			try{
				input = Integer.parseInt(r.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Wrong input! Try again! \n");
			}
			
			
		}while(input != 0);
	}
	
	public void createCustomers()
	{
		int input = 0;
		String first_name = "";
		String last_name= "";
		String email = "";
		int phone_number = 0;
		int license = 0;
        Scanner r = new Scanner(System.in);        
        
        do {
			System.out.println("\n ----Creating new customer---- \n");
			
        	System.out.println("Enter customer's first name :");
        	first_name  = r.nextLine();
        	
        	System.out.println("Enter customer's last name :");
        	last_name = r.nextLine();
        	
        	System.out.println("Enter customer's email :");
        	email = r.nextLine();
        	
        	System.out.println("Enter customer's phone number :");
        	try{
        		phone_number = Integer.parseInt(r.nextLine());
        	}catch(NumberFormatException e) {
        		System.out.println("Wrong input! Try again! \n");
        	}
        	
        	System.out.println("Enter customer's license :");
        	try{
        		license = Integer.parseInt(r.nextLine());
        	}catch(NumberFormatException e) {
        		System.out.println("Wrong input! Try again! \n");
        	}
        	
        	Customer customer = new Customer(0, first_name, last_name, email, phone_number, license);
        	
			this.db.insertCustomer(0, first_name, last_name, email, phone_number, license);
			//db.preparedInsertCustomer(first_name, last_name, email, phone_number, license);
			
			
			System.out.println("To enter new customer press [1]. To exit press [0]");
			try{
				input = Integer.parseInt(r.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Wrong input! Try again! \n");
			}
			
        }while(input != 0);
		
	}

	public void createReservations()
	{
		int input = 0;
		int customer_id = 0;
		int store_id = 0;
		int car_id = 0;
		String pick_up_date = "";
		String pick_up_time = "";
		String drop_out_location = "";
		String choice = "";
		String return_date = "";
		String return_time = "";
        Scanner r = new Scanner(System.in); 
        
        do{
			System.out.println("\n ----Creating new reservation---- \n");
			
			System.out.println("Enter customer's id :");
        	try{
        		customer_id = Integer.parseInt(r.nextLine());
        	}catch(NumberFormatException e) {
        		System.out.println("Wrong input! Try again! \n");
        	}
        	
        	System.out.println("Enter store's id :");
        	try{
        		store_id = Integer.parseInt(r.nextLine());
        	}catch(NumberFormatException e) {
        		System.out.println("Wrong input! Try again! \n");
        	}
        	
			System.out.println("Enter the car's id you would like to rent :");
        	try{
        		car_id = Integer.parseInt(r.nextLine());
        	}catch(NumberFormatException e) {
        		System.out.println("Wrong input! Try again! \n");
        	}	
			
			System.out.println("Enter your pick up date (YYYY-MM-DD) :");
			pick_up_date = r.nextLine();
		
			System.out.println("Enter your pick up time (hh:mm:ss)");
        	pick_up_time = r.nextLine();
        	
        	System.out.println("Do you want to choose a different location to drop your car? (y/n)");
        	choice = r.nextLine();
        	if( choice.equals("y")) {
        		System.out.println("Enter your drop out location");
        		drop_out_location = r.nextLine();
        	} else {
        		drop_out_location = "store";
        	}

			System.out.println("Enter your return date (YYYY-MM-DD) :");
			return_date = r.nextLine();
		
			System.out.println("Enter your return time (hh:mm:ss)");
        	return_time = r.nextLine();
        	
        	Reservation reservation = new Reservation(customer_id, store_id, car_id, pick_up_date, pick_up_time, drop_out_location, return_date, return_time);
        	
        	
			System.out.println("To enter new reserrvation press [1]. To exit press [0]");
			try{
				input = Integer.parseInt(r.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Wrong input! Try again! \n");
			}
        	
        }while(input != 0);		
	}
	
	public int chargeCustomer()
	{
		return fee;
	}
	
	RentCarService()
	{
		this.db = new DatabaseRepository();
	}

}
