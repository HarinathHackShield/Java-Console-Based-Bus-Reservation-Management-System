import java.util.*;
public class Admin{
    private String UserName = "Admin";
    private String Password = "Pass";
    Scanner sc = new Scanner(System.in);
    
    public void setUserName(String uName){
        this.UserName = uName;
        
    }
    
    public void setUserPass(String uPass){
        this.Password = uPass;
    }
    
    public boolean isAdmin(){
        System.out.print("Enter Your UserName: ");
        String uName = sc.nextLine();
        System.out.print("Enter Your Password: ");
        String uPass = sc.nextLine();
        if(uName.equalsIgnoreCase(this.UserName) && uPass.equalsIgnoreCase(this.Password)){
            return true;
        }else{
            return false;
        }
    }
    
    public void AdminPanel(){
        System.out.println();
        System.out.print("""
        
        ====== Admin Panel ======
        1. Add New Bus
        2. View All Buses
        3. Edit Bus Details
        4. Delete Bus
        5. View All Reservations
        6. Logout
        --------------------------
        Enter your choice: """);

    }
    
    public boolean addNewBus(ArrayList<Bus> bus){
        boolean busAdded = false;
        System.out.print("Enter Bus No: ");
        int busNo = sc.nextInt();sc.nextLine();
        
        System.out.print("Enter Source: ");
        String source = sc.nextLine();
        
        System.out.print("Enter Destination: ");
        String destination = sc.nextLine();
        
        System.out.println("Enter Capacity: ");
        int capacity = sc.nextInt();sc.nextLine();
        
        System.out.print("Is AC? (yes/no): ");
        String isAc = sc.nextLine();
        
        try{
            bus.add(new Bus(busNo, capacity, isAc.equalsIgnoreCase("yes")? true : false, source, destination));
            busAdded = true;
        }catch(Exception e){
            System.out.println(e);
            busAdded = false;
        }
        return busAdded;
        
    }
    
    public boolean ViewAllBuses(ArrayList<Bus> buses){
        boolean isBusAvailable = false;
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-8s | %-10s | %-11s | %-4s | %-8s | %-10s%n" , 
                  "Bus No", "Source", "Destination", "AC", "Capacity", "Remaining Seats");
        System.out.println("-----------------------------------------------------------------------");

        for (Bus bus : buses) {
            isBusAvailable = true;
            System.out.printf("%-8d | %-10s | %-11s | %-4s | %-8d | %-10s%n",
                              bus.getBusNo(),
                              bus.getSource(),
                              bus.getDestination(),
                              bus.isAc() ? "Yes" : "No",
                              bus.getCapacity(),
                              bus.getRemaining());
                              
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");

        return isBusAvailable;

    }
    
    public boolean editBus(ArrayList<Bus> bus){
        boolean isEdited = false;
        
        System.out.print("Enter Bus No to Edit: ");
        int busNo = sc.nextInt();
        
        for(Bus b: bus){
            if(busNo == b.getBusNo()){
                System.out.print("Enter new Capacity: ");
                int cap = sc.nextInt();sc.nextLine();
                System.out.print("Is AC? (yes/no): ");
                String isAc = sc.nextLine();
                
                b.setCapacity(cap);
                b.setRemaining(cap);
                b.setAc(isAc.equalsIgnoreCase("yes")? true: false);
                isEdited = true;
            }
        }
        
        return isEdited;
        
    }
    
    public boolean delBus(ArrayList<Bus> bus){
        boolean isDel = false;
        System.out.print("Enter Bus No to delete: ");
        int bNo = sc.nextInt();
        
        for(int i=0;i<bus.size();i++){
            if(bNo == bus.get(i).getBusNo()){
                bus.remove(i);
                isDel = true;
            }
        }
        return isDel;
    }
    
    public boolean viewReservation(ArrayList<Reservation> res){
        System.out.println();
        boolean isReserve = false;
        
            System.out.printf("%-8s | %-20s | %-6s | %-5s | %-10s%n" , 
                  "Res. No", "Passanger Name", "Bus No", "Seats", "Status");
        System.out.println("-----------------------------------------------------------------------");

        for (Reservation r : res) {
            isReserve = true;
            System.out.printf("%-8s | %-20s | %-6s | %-5s | %-10s%n",
                              r.getReservationNo(),
                              r.getPName(),
                              r.getBusNo(),
                              r.getNoOfSeatsBooked(),
                              r.getStatus());
                              
        }
        
        
        return isReserve;
    }
    
}