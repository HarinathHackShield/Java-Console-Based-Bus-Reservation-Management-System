import java.util.*;
public class Main
{
    public static int MainOptions() {
    Scanner sc = new Scanner(System.in);

    System.out.println("\n===========================================");
    System.out.println("    🚌  Welcome to Bus Reservation System     ");
    System.out.println("===========================================");
    System.out.println("  1. Admin");
    System.out.println("  2. User");
    System.out.println("  3. Exit");
    System.out.println("===========================================");
    System.out.print("👉 Enter your choice (1-3): ");

    int choice = sc.nextInt();
    return (choice >= 1 && choice <= 3) ? choice : 0;
}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Bus> busses = new ArrayList<>();
		ArrayList<Reservation> reserves = new ArrayList<>();
		Admin admin = new Admin();
		User user = new User();

        busses.add(new Bus(12345, 45, true, "Chennai", "Hyderabad"));
        busses.add(new Bus(23456, 50, false, "Bangalore", "Pune"));
        busses.add(new Bus(34567, 40, true, "Delhi", "Jaipur"));
        busses.add(new Bus(45678, 60, false, "Mumbai", "Goa"));
        
        reserves.add(new Reservation(1001, "Ravi Kumar", 28, 'M', 2, 12345, "04/08/2025", 1500.00, "Confirmed"));
        reserves.add(new Reservation(1002, "Priya Sharma", 32, 'F', 1, 23456, "05/08/2025", 1200.50, "Confirmed"));
        reserves.add(new Reservation(1003, "Anil Verma", 40, 'M', 3, 34567, "06/08/2025", 2200.00, "Confirmed"));
        reserves.add(new Reservation(1004, "Neha Singh", 26, 'F', 2, 45678, "07/08/2025", 1800.75, "Confirmed"));
        reserves.add(new Reservation(1005, "Vikram Rao", 35, 'M', 1, 12345, "08/08/2025", 800.00, "Confirmed"));
        
		int choice = MainOptions();
		while(choice!=3 && choice < 3 && choice > 0){
		    if(choice == 1){
		        if(admin.isAdmin()){
		            admin.AdminPanel();
		            int adminChoice = sc.nextInt();
		            if(adminChoice == 6){
		                System.out.println("Logging Out...");
		            }
		            while(adminChoice >0 && adminChoice < 6){
		            switch(adminChoice){
		               case 1: 
		                  // Add new Bus logic
		                  boolean addBus = admin.addNewBus(busses);
		                  if(addBus){
		                      System.out.println("\n------------------------------");
		                      System.out.println("Bus added successfully !");
		                      System.out.println("--------------------------------\n");
		                  }else{
		                      System.out.println("Bus is not added successfully, Pls try Again.");
		                  }
		                  break;
		               case 2: 
		                  // View All Bus logic
		                  boolean ViewBus = admin.ViewAllBuses(busses);
		                  if(!ViewBus){
		                      System.out.println("\n-----------------------------");
		                      System.out.println("No Buses Available.");
		                      System.out.println("-------------------------------\n");
		                  }
		                  break;
		               case 3: 
		                  // Edit Bus logic
		                  boolean EditBusRes = admin.editBus(busses);
		                  if(EditBusRes){
		                      System.out.println("\n------------------------------------");
                              System.out.println("       Bus Details Updated!         ");
                              System.out.println("------------------------------------\n");

		                  }else{
		                      System.out.println("\n------------------------------------");
		                      System.out.println("Invalid Bus No, Pls try again..");
		                      System.out.println("------------------------------------\n");
		                  }
		                  break;
		               case 4: 
		                  // Delete Bus logic
		                  boolean delBus = admin.delBus(busses);
		                  if(delBus){
		                      System.out.println("\n-----------------------------");
		                      System.out.println("Bus deleted successfully!");
		                      System.out.println("-------------------------------\n");
		                  }else{
		                      System.out.println("\n------------------------------------");
		                      System.out.println("Invalid Bus No, Pls try again..");
		                      System.out.println("------------------------------------\n");
		                  }
		                  break;
		               case 5:
		                  // View All Reservations 
		                  boolean viewRes = admin.viewReservation(reserves);
		                  if(!viewRes){
		                      System.out.println("\n-------------------------");
		                      System.out.println("No Reservation found.");
		                      System.out.println("----------------------------\n");
		                  }
		                  break;
		           }
		           
                    admin.AdminPanel();
		            adminChoice = sc.nextInt();
		            if(adminChoice == 6){
		                System.out.println("\n------------------");
		                System.out.println("Logging Out...");
		                System.out.println("------------------\n");
		            }
		        }
		    }
		    }
		    else if(choice == 2){
		        int userChoice = user.userPanel();
		        while(userChoice != 6){
		            switch(userChoice){
		                case 1 : 
		                  //  View All Buses 
		                    user.ViewAllBuses(busses);
		                    break;
		                case 2:
		                  //  Make reservation logic
		                  String option = user.makeReservation(reserves, busses);
		                    if(!(option.equals("No"))){
		                        System.out.println("----------------------------");
		                        System.out.println("Reservation successfull");
		                        System.out.println("Your Reservation No is: "+ option);
		                        System.out.println("----------------------------");
		                    }else{
		                        System.out.println("\n----------------------------------");
		                        System.out.println("No Seats Available, Bus capacity is Full!");
		                        System.out.println("Use another date for Reservation");
		                        System.out.println("------------------------------------\n");
		                    }
		                    break;
		                case 3:
		                  //  Cancel reservation logic
		                  boolean result = user.cancelReservation(reserves);
		                  if(result){
		                      System.out.println("\n----------------------------------");
		                      System.out.println("Reservation cancelled successfully!");
		                      System.out.println("------------------------------------\n");
		                  }else{
		                      System.out.println("\n------------------------------------------");
		                       System.out.println("Invalid reservation Number, Pls Try Again");
		                       System.out.println("-----------------------------------------\n");
		                  }
		                    break;
		                case 4:
		                  //  Edit reservation logic
		                    boolean resEdit = user.editReservation(reserves);
		                    if(resEdit){
		                        System.out.println("\n-------------------------");
		                        System.out.println("Reservation updated!");
		                        System.out.println("---------------------------\n");
		                    }else{
		                        System.out.println("\n---------------------------------------");
		                        System.out.println("Invalid reservation Number, Pls Try Again");
		                        System.out.println("-----------------------------------------\n");
		                    }
		                    break;
		                case 5:
		                  //  View reservation logic
		                  boolean resView = user.viewReservation(reserves);
		                  if(!resView){
		                      System.out.println("\n---------------------------------------");
		                      System.out.println("Invalid reservation Number, Pls Try Again");
		                      System.out.println("-----------------------------------------\n");
		                  }
		                    break;
		            }
		            userChoice = user.userPanel();
		        }
		        
		    }
		    choice = MainOptions();
		
		    
		}
		

	}
}