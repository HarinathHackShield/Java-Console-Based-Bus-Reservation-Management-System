# Java-Console-Based-Bus-Reservation-Management-System

A Java console-based Bus Reservation &amp; Management System that allows administrators to manage buses and reservations, while users can view available buses, book tickets, edit or cancel reservations. Features include admin authentication, CRUD operations for buses, and full reservation management — all through an interactive command-line interface.

Output of the Project:

=========================================
       BUS RESERVATION SYSTEM
=========================================

MAIN MENU:
1. Admin
2. User
3. Exit
Enter your choice: 1

-----------------------------------------
ADMIN LOGIN
-----------------------------------------
Enter username: admin
Enter password: admin123
Login successful!

-----------------------------------------
ADMIN MENU:
1. Add New Bus
2. View All Buses
3. Edit Bus
4. Delete Bus
5. View All Reservations
6. Logout
Enter your choice: 1

[ADDING NEW BUS]
Enter Bus Number: 56789
Enter Capacity: 42
Is AC Bus? (true/false): true
Enter Source: Kolkata
Enter Destination: Patna
Bus added successfully!

-----------------------------------------
Enter your choice: 2

[VIEWING ALL BUSES]
Bus No   | Source      | Destination | AC     | Capacity
---------------------------------------------------------
12345    | Chennai     | Hyderabad   | Yes    | 45
23456    | Bangalore   | Pune        | No     | 50
34567    | Delhi       | Jaipur      | Yes    | 40
45678    | Mumbai      | Goa         | No     | 60
56789    | Kolkata     | Patna       | Yes    | 42

-----------------------------------------
Enter your choice: 3

[EDITING BUS]
Enter Bus Number to edit: 23456
Enter New Capacity: 55
Is AC Bus? (true/false): true
Enter New Source: Bangalore
Enter New Destination: Pune
Bus details updated!

-----------------------------------------
Enter your choice: 4

[DELETING BUS]
Enter Bus Number to delete: 34567
Bus deleted successfully!

-----------------------------------------
Enter your choice: 5

[VIEWING ALL RESERVATIONS]
ResNo | Passenger Name | Age | Gender | Seats | BusNo | Date       | Fare     | Status
---------------------------------------------------------------------------------------
1001  | Ravi Kumar     | 28  | M      | 2     | 12345 | 04/08/2025 | 1500.00  | Confirmed
1002  | Priya Sharma   | 32  | F      | 1     | 23456 | 05/08/2025 | 1200.50  | Confirmed
1003  | Anil Verma     | 40  | M      | 3     | 34567 | 06/08/2025 | 2200.00  | Confirmed
1004  | Neha Singh     | 26  | F      | 2     | 45678 | 07/08/2025 | 1800.75  | Confirmed
1005  | Vikram Rao     | 35  | M      | 1     | 12345 | 08/08/2025 | 800.00   | Confirmed

-----------------------------------------
Enter your choice: 6
Logging Out...

MAIN MENU:
1. Admin
2. User
3. Exit
Enter your choice: 2

-----------------------------------------
USER MENU:
1. View All Buses
2. Make Reservation
3. Cancel Reservation
4. Edit Reservation
5. View Reservation
6. Exit
Enter your choice: 1

[VIEWING ALL BUSES]
Bus No   | Source      | Destination | AC     | Capacity
---------------------------------------------------------
12345    | Chennai     | Hyderabad   | Yes    | 45
23456    | Bangalore   | Pune        | Yes    | 55
45678    | Mumbai      | Goa         | No     | 60
56789    | Kolkata     | Patna       | Yes    | 42

-----------------------------------------
Enter your choice: 2

[MAKING RESERVATION]
Enter Passenger Name: Sunil Kumar
Enter Age: 30
Enter Gender (M/F): M
Enter No. of Seats: 2
Enter Bus Number: 12345
Enter Date (dd/mm/yyyy): 09/08/2025
Reservation successful!
Your Reservation No is: 1006

-----------------------------------------
Enter your choice: 3

[CANCELLING RESERVATION]
Enter Reservation Number: 1004
Reservation cancelled successfully!

-----------------------------------------
Enter your choice: 4

[EDITING RESERVATION]
Enter Reservation Number: 1002
Enter New Passenger Name: Priya Sharma
Enter New Age: 33
Enter New Gender (M/F): F
Enter New No. of Seats: 1
Reservation updated!

-----------------------------------------
Enter your choice: 5

[VIEWING RESERVATION]
Enter Reservation Number: 1002
ResNo | Passenger Name | Age | Gender | Seats | BusNo | Date       | Fare     | Status
---------------------------------------------------------------------------------------
1002  | Priya Sharma   | 33  | F      | 1     | 23456 | 05/08/2025 | 1200.50  | Confirmed

-----------------------------------------
Enter your choice: 6
Exiting User Menu...

MAIN MENU:
1. Admin
2. User
3. Exit
Enter your choice: 3

Thank you for using the Bus Reservation System!
