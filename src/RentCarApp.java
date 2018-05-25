import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class RentCarApp {
	
	public static void main(String[] args) {
        int input = 0;
        boolean loop = true;
        
        RentCarService service = new RentCarService();        
        
        Scanner r = new Scanner(System.in);

        do {
        	System.out.println("[1] Enter new cars");
        	System.out.println("[2] Enter new customers");
        	System.out.println("[3] See all cars from every store");
        	System.out.println("[4] Search for rented cars");
        	System.out.println("[5] Rent a car");
        	System.out.println("[6] Delete a car");
        	System.out.println("[0] Exit");
        	
        	try{
        		input = Integer.parseInt(r.nextLine());
        	}catch(NumberFormatException e) {
				System.out.println("Wrong input! Try again! \n");
        	}
        	
        	switch(input) {
	        	case 1:
	        		service.createCars();
	        		break;
	        	case 2:
	        		service.createCustomers();
	        		break;
	        	case 3:
	        		service.printEveryCar();
	        		break;
	        	case 4:
	        		service.printRentedCars();
	        		break;
	        	case 5:
	        		service.rentCar();
	        		break;
	        	case 6:
	        		service.deleteCars();
	        		break;
	        	case 0:
	        		loop = false;
	        		break;
        	}
        	
        }while(loop);		
	}
}
