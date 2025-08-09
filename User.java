import java.util.*;
import java.text.SimpleDateFormat;

public class User{
    Scanner sc = new Scanner(System.in);
    private static int counter = 1000;
    
    public int userPanel() {
    System.out.println("\n======================================");
    System.out.println("         🚍 User Options          ");
    System.out.println("=======================================");
    System.out.println("  1. View All Buses");
    System.out.println("  2. Make Reservation");
    System.out.println("  3. Cancel Reservation");
    System.out.println("  4. Edit Reservation");
    System.out.println("  5. View My Reservation");
    System.out.println("  6. Exit");
    System.out.println("=======================================");
    System.out.print("👉 Enter your choice (1-6): ");

    int choice = sc.nextInt();
    return (choice >= 1 && choice <= 6) ? choice : 0;
}

    
    public void ViewAllBuses(ArrayList<Bus> buses){
        System.out.printf("%-8s | %-10s | %-11s | %-4s | %-8s | %-10s%n" , 
                  "Bus No", "Source", "Destination", "AC", "Capacity", "Remaining Seats");
        System.out.println("-----------------------------------------------------------------------");

        for (Bus bus : buses) {
            System.out.printf("%-8d | %-10s | %-11s | %-4s | %-8d | %-10s%n",
                              bus.getBusNo(),
                              bus.getSource(),
                              bus.getDestination(),
                              bus.isAc() ? "Yes" : "No",
                              bus.getCapacity(),
                              bus.getRemaining());
                              
        }

    }
    
    public ArrayList<Reservation> getUserInfo(){
        
        ArrayList<Reservation> userList = new ArrayList<>();
        sc.nextLine();
        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();
        
        System.out.print("Enter Bus No: ");
        int BusNo = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter the Date(dd/mm/yyyy): ");
        String date = sc.nextLine(); 

        System.out.print("Enter No. of Seats: ");
        int seats = sc.nextInt();
        sc.nextLine();
        
        userList.add(new Reservation(++counter, name, age, gender.charAt(0), seats, BusNo, date, 0.0, "Waiting"));
        
        return userList;
    }
    
    public int checkAvailabilty(ArrayList<Reservation> list, ArrayList<Bus> busses, ArrayList<Reservation> userInfo){
        
        int userSeats = 0;
        int busNo = 0;
        int remainingSeats = 0;
        int ReservationNo = 0;
        
        for(Reservation r : userInfo){
            userSeats = r.getNoOfSeatsBooked();
            busNo = r.getBusNo();
        }

        for(Bus r : busses){
            if(busNo == r.getBusNo()){
                remainingSeats = r.getRemaining();
                }
            }
            
            if(remainingSeats >= userSeats){
                    System.out.println();
                    System.out.println("Fare: Rs. 300 x "+ userSeats +" = Rs. " + 300 * userSeats);
                    System.out.println();
                    System.out.print("confirm booking? (yes/no): ");
                    String option = sc.nextLine();
                    System.out.println();
                    if(option.equalsIgnoreCase("yes")){
                        for(Bus r : busses){
                            if(busNo == r.getBusNo()){
                                r.setRemaining(remainingSeats - userSeats);
                                }
                            }
                            
                        for(Reservation r : userInfo){
                            ReservationNo = r.getReservationNo();
                            Date date = new Date();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            String datestr = sdf.format(date);
                            list.add(new Reservation(
                                r.getReservationNo(),
                                r.getPName(),
                                r.getAge(),
                                r.getGender(),
                                r.getNoOfSeatsBooked(),
                                r.getBusNo(),
                                datestr,
                                userSeats * 300,
                               "Confirmed"
                                ));
                        }
                    }

                }
        
        return ReservationNo;
    
    }
    
    public String makeReservation(ArrayList<Reservation> list, ArrayList<Bus> buses){
        ArrayList<Reservation> userInfo = getUserInfo();
        
        
        int bookAvailabilty = checkAvailabilty(list, buses, userInfo);
        
        
        return (bookAvailabilty == 0) ? "No": Integer.toString(bookAvailabilty);
        
    }
    
    public boolean cancelReservation(ArrayList<Reservation> reservations){
        System.out.print("Enter Reservation No: ");
        int RNo = sc.nextInt();
        for(int i=0; i<reservations.size();i++){
            if(RNo == reservations.get(i).getReservationNo()) return true;
        }
        return false;
        
    }
    
    public boolean editReservation(ArrayList<Reservation> res){
        System.out.print("Enter Reservation No: ");
        int RNo = sc.nextInt();
        
        for(int i=0;i<res.size();i++){
            if(RNo == res.get(i).getReservationNo()){
                int oldSeats = res.get(i).getNoOfSeatsBooked();
                System.out.printf("Update number of seats (old: "+ oldSeats +"): ");
                int newSeats = sc.nextInt();
                res.get(i).setFare(newSeats * 300);
                System.out.println();
                System.out.println("Fare updated to Rs. "+res.get(i).getFare());
                return true;
            }
            return false;
        }
        return false;
    }
    
    public boolean viewReservation(ArrayList<Reservation> res){
        System.out.print("Enter Reservation No: ");
        int RNo = sc.nextInt();
        System.out.println();
        for(int i=0;i<res.size();i++){
            if(RNo == res.get(i).getReservationNo()){
                System.out.println("------------------------------");
                System.out.println("Reservation No: "+ res.get(i).getReservationNo());
                System.out.println("Name: "+ res.get(i).getPName());
                System.out.println("Age: "+ res.get(i).getAge());
                System.out.println("Bus No: "+ res.get(i).getBusNo());
                System.out.println("Seats: "+ res.get(i).getNoOfSeatsBooked());
                System.out.println("Fare: "+ res.get(i).getFare());
                System.out.println("Status: "+ res.get(i).getStatus());
                System.out.println("------------------------------");
                System.out.println();
                return true;
            }
        }
        return false;
    }
}