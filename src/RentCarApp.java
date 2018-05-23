import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class RentCarApp {
	
	public static void main(String[] args) {
        int input = 0;
        boolean loop = true;
        
        RentCarService app = new RentCarService();
               
        
        Scanner r = new Scanner(System.in);

        do {
        	System.out.println("[1] Enter new cars");
        	System.out.println("[2] Enter new customers");
        	System.out.println("[3] Enter new reservations");
        	System.out.println("[4] See all cars that from every store");
        	System.out.println("[5] Search for available cars");
        	System.out.println("[6] Rent a car");
        	System.out.println("[7] Delete a car that is now available for rent");
        	System.out.println("[0] Exit");
        	
        	try{
        		input = Integer.parseInt(r.nextLine());
        	}catch(NumberFormatException e) {
				System.out.println("Wrong input! Try again! \n");
        	}
        	
        	switch(input) {
        	case 1:
        		app.createCars();
        		break;
        	case 2:
        		app.createCustomers();
        		break;
        	case 3:
        		app.createReservations();
        		break;
        	case 4:
        		app.createReservations();
        		break;
        	case 5:
        		break;
        	case 6:
        		break;
        	case 0:
        		loop = false;
        		break;
        	}
        	
        }while(loop);
		
	}

}
