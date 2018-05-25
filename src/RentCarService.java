import java.util.Scanner;

public class RentCarService {

	public void createCars()
	{
		int input = 0;
		String choice = " ";
		String size= "";
		String type = "";
		int seates = 0;
		int doors = 0;
		int price = 0;
		int store_id= 0;
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
			
			System.out.println("Enter the store's id that has this car :");
			try{
				store_id = Integer.parseInt(r.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Wrong input! Try again! \n");
			}
			
			CarRepo car_repo = new CarRepo();
			//car_repo.insertCar(0, size, seates, doors, type, price, store_id);
			car_repo.preparedInsertCar(size, seates, doors, type, price, store_id);
			Car car = new Car(size, seates, doors, type, price, store_id);
			
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
        	
        	CustomerRepo customer_repo = new CustomerRepo();
        	
			//tcustomer_repo.insertCustomer(0, first_name, last_name, email, phone_number, license);
        	customer_repo.preparedInsertCustomer(first_name, last_name, email, phone_number, license);
			
			Customer customer = new Customer(first_name, last_name, email, phone_number, license);
			
			System.out.println("To enter new customer press [1]. To exit press [0]");
			try{
				input = Integer.parseInt(r.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Wrong input! Try again! \n");
			}
			
        }while(input != 0);		
	}

	public void rentCar()
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
        		System.out.println("Wrong input!\n");
        	}
        	
        	System.out.println("Enter store's id :");
        	try{
        		store_id = Integer.parseInt(r.nextLine());
        	}catch(NumberFormatException e) {
        		System.out.println("Wrong input!\n");
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
        	
        	CarRepo car_repo = new CarRepo();
        	
        	car_repo.getAvailableCars(store_id, pick_up_date, return_date);
        	
			System.out.println("Enter the car's id you would like to rent :");
        	try{
        		car_id = Integer.parseInt(r.nextLine());
        	}catch(NumberFormatException e) {
        		System.out.println("Wrong input!\n");
        	}	
        	
        	Reservation reservation = new Reservation(customer_id, store_id, car_id, pick_up_date, pick_up_time, drop_out_location, return_date, return_time);
        	
        	int total_cost = reservation.getTotalCost();
        	
        	System.out.println("The total cost of your reservations is "+total_cost+ " €\nDo you want to to proceed? (y/n)");
        	
        	choice = r.nextLine();
        	
        	if(choice.equals("y")) {
	        	ReservationRepo reservation_repo = new ReservationRepo();
	        	reservation_repo.insertReservation(0, customer_id, store_id, pick_up_date, pick_up_time, drop_out_location, return_date, return_time, car_id, reservation.getTotalCost());
				//reservation_repo.preparedInsertReservation(customer_id, store_id, pick_up_date, pick_up_time, drop_out_location, return_date, return_time, car_id, reservation.getTotalCost());
        	}      	
			System.out.println("To enter new reservation press [1]. To exit press [0]");
			try{
				input = Integer.parseInt(r.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Wrong input!\n");
			}
        	
        }while(input != 0);		
	}

	public void printEveryCar()
	{
		System.out.println("\n ----Print all cars---- \n");
		
		Scanner r = new Scanner(System.in);
		
		CarRepo car_repo = new CarRepo();
		car_repo.selectAllCars();
		
		r.nextLine();		 
	}

	public void printRentedCars()
	{
		System.out.println("\n ----Print all rented cars---- \n");
		
		Scanner r = new Scanner(System.in);
		
		int input = 0;
		int store_id = 0;
		
		do{
			System.out.println("Enter the id of the store you want to see the rented cars :");
			
			try{
				store_id= Integer.parseInt(r.nextLine());
			}catch(NumberFormatException e){
				System.out.println("Wrong input!\n");
			}
			
			CarRepo car_repo = new CarRepo();
			
			car_repo.getRentedCars(store_id);
			
			System.out.println("To see the rented cars from another store press [1]. To exit press [0]");
			try{
				input = Integer.parseInt(r.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Wrong input!\n");
			}		
			
		}while(input != 0);
		
	}
	
	public void deleteCars()
	{
		System.out.println("\n ----Delete a car---- \n");
		
		Scanner r = new Scanner(System.in);
		
		int input = 0;
		int car_id = 0;
		
		do{
			CarRepo car_repo = new CarRepo();
			
			System.out.println("Enter the id of the car you want to delete :");
			
			try{
				car_id = Integer.parseInt(r.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Wrong input!\n");
			}			
			
			car_repo.deleteCar(car_id);			
			
			System.out.println("To delete another car press [1]. To exit press [0]");
			try{
				input = Integer.parseInt(r.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Wrong input!\n");
			}	
			
		}while(input != 0);
	}
	
	RentCarService()
	{
	}

}
