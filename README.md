# oibsip_taskno.1
The provided Java code showcases a basic implementation of an Online Reservation System. The code consists of two main classes: Passenger and ReservationSystem. 
The Passenger class represents a passenger with attributes like name, train number, class type, date of journey, source, destination, PNR number, and food choice. 
The toString() method in the Passenger class provides a formatted string representation of passenger details.
The ReservationSystem class serves as the entry point of the program. It utilizes a HashMap called database to store passenger details, where each passenger's PNR 
number serves as the key, and their corresponding Passenger object is the value. The main method displays a menu for the user, allowing them to choose between login, 
reservation, cancellation, or exit. The login() method simulates the login process by requesting login credentials from the user and checking their validity. 
In a real-world scenario, this authentication process would involve more secure mechanisms. Upon successful login, the showReservationOptions() method displays the reservation 
options to the user. The user can then choose to reserve a ticket, cancel a ticket, or log out of the system. The reserveTicket() method handles the ticket reservation process. 
It collects various details from the user, such as name, train number, class type, date of journey, source, destination, and PNR number. Additionally, it prompts the user to specify 
their food preference: vegetarian, non-vegetarian, or no food. The passenger's details, along with the food choice, are stored in the database. The cancelTicket() method manages the 
ticket cancellation process. The user is required to input their PNR number to retrieve their reservation details from the database. If the PNR number matches an existing reservation, 
the passenger details are displayed, and the user is asked to confirm the cancellation. If confirmed, the corresponding ticket is removed from the database. It's important to note that 
this code is a simplified representation intended for educational purposes. In real-world applications, further considerations, such as data persistence, user authentication, 
input validation, error handling, and graphical user interfaces (GUI), would be essential for a fully functional and secure Online Reservation System.
