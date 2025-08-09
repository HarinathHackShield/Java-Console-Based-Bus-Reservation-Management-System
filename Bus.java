import java.util.*;
public class Bus{
    private int busNo;
    private int capacity;
    private int remaining;
    private boolean isAc;
    private String source;
    private String destination;

    public Bus(int busNo, int capacity, boolean isAc, String source, String destination){
        this.busNo = busNo;
        this.capacity = capacity;
        this.remaining = capacity;
        this.isAc = isAc;
        this.source = source;
        this.destination = destination;
    }
    
        public int getBusNo() {
            return this.busNo;
        }
        
        public int getCapacity() {
            return this.capacity;
        }
        
        public void setCapacity(int capacity){
            this.capacity = capacity;
        }
        
        public boolean isAc() {
            return this.isAc;
        }
        
        public void setAc(boolean isAc){
            this.isAc = isAc;
        }
        
        public String getSource() {
            return this.source;
        }
        
        public String getDestination() {
            return this.destination;
        }
        
        public int getRemaining() {
            return this.remaining;
        }
        
        public void setRemaining(int remaining) {
            this.remaining = remaining;
        }

    
}