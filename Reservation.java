import java.text.SimpleDateFormat;
import java.util.*;

public class Reservation{
    Scanner sc = new Scanner(System.in);
    int ReservationNo;
    String PName;
    int Age;
    char Gender;
    int NoOfSeatsBooked;
    int BusNo;
    Date BookingDate;
    double Fare;
    String status;
    
    public Reservation(int ReservationNo, String PName, int Age, char Gender, int NoOfSeatsBooked, int BusNo,String BookingDate ,double Fare, String status){
    this.ReservationNo = ReservationNo;
    this.PName = PName;
    this.Age = Age;
    this.Gender = Gender;
    this.NoOfSeatsBooked = NoOfSeatsBooked;
    this.BusNo = BusNo;
    Date dateFormat = null;
    try{
         dateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(BookingDate); 
    }catch(Exception e){
        System.out.println("Invalid Date format: "+e.getMessage());
    }
    
    this.BookingDate = dateFormat;
    this.Fare = Fare;
    this.status = status;
    }
    
    public int getReservationNo() {
        return ReservationNo;
    }

    public void setReservationNo(int reservationNo) {
        ReservationNo = reservationNo;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char gender) {
        Gender = gender;
    }

    public int getNoOfSeatsBooked() {
        return NoOfSeatsBooked;
    }

    public void setNoOfSeatsBooked(int noOfSeatsBooked) {
        NoOfSeatsBooked = noOfSeatsBooked;
    }

    public int getBusNo() {
        return BusNo;
    }

    public void setBusNo(int busNo) {
        BusNo = busNo;
    }

    public Date getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(String bookingDate) {
        try {
            this.BookingDate = new SimpleDateFormat("dd/MM/yyyy").parse(bookingDate);
        } catch (Exception e) {
            System.out.println("Invalid Date format: " + e.getMessage());
        }
    }

    public double getFare() {
        return Fare;
    }

    public void setFare(double fare) {
        Fare = fare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}