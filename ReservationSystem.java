import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Passenger {
    String name;
    String trainNumber;
    String classType;
    String dateOfJourney;
    String source;
    String destination;
    String pnr;
    String foodChoice;

    public Passenger(String name, String trainNumber, String classType, String dateOfJourney,
                     String source, String destination, String pnr) {
        this.name = name;
        this.trainNumber = trainNumber;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.source = source;
        this.destination = destination;
        this.pnr = pnr;
    }

    public void setFoodChoice(String foodChoice) {
        this.foodChoice = foodChoice;
    }

    @Override
    public String toString() {
        return "Passenger Details:\n" +
                "Name: " + name + '\n' +
                "Train Number: " + trainNumber + '\n' +
                "Class Type: " + classType + '\n' +
                "Date of Journey: " + dateOfJourney + '\n' +
                "Source: " + source + '\n' +
                "Destination: " + destination + '\n' +
                "PNR: " + pnr + '\n' +
                "Food Choice: " + foodChoice;
    }
}

class ReservationSystem {
    private static Map<String, Passenger> database = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Online Reservation System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Login");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    login();
                    break;
                case 0:
                    System.out.println("Thank you for using Online Reservation System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your login id: ");
        String loginId = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Simulating a basic authentication check
        if (isValidUser(loginId, password)) {
            showReservationOptions();
        } else {
            System.out.println("Invalid login id or password. Please try again.");
        }
    }

    private static boolean isValidUser(String loginId, String password) {
        // Implement your user authentication logic here
        // For this example, we'll use a simple hardcoded login id and password
        return loginId.equals("user123") && password.equals("password");
    }

    private static void showReservationOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nReservation System:");
        System.out.println("1. Reserve a Ticket");
        System.out.println("2. Cancel a Ticket");
        System.out.println("0. Logout");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                reserveTicket();
                break;
            case 2:
                cancelTicket();
                break;
            case 0:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void reserveTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nReserve a Ticket:");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the train number: ");
        String trainNumber = scanner.nextLine();
        System.out.print("Enter the class type: ");
        String classType = scanner.nextLine();
        System.out.print("Enter the date of journey: ");
        String dateOfJourney = scanner.nextLine();
        System.out.print("Enter the source: ");
        String source = scanner.nextLine();
        System.out.print("Enter the destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter your PNR number: ");
        String pnr = scanner.nextLine();

        Passenger passenger = new Passenger(name, trainNumber, classType, dateOfJourney, source, destination, pnr);

        // Food Choice
        System.out.println("\nFood Choices:");
        System.out.println("1. Vegetarian");
        System.out.println("2. Non-Vegetarian");
        System.out.println("3. No Food");
        System.out.print("Enter your food choice (1/2/3): ");
        int foodChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (foodChoice) {
            case 1:
                passenger.setFoodChoice("Vegetarian");
                break;
            case 2:
                passenger.setFoodChoice("Non-Vegetarian");
                break;
            case 3:
                passenger.setFoodChoice("No Food");
                break;
            default:
                System.out.println("Invalid choice. No food preference set.");
        }

        database.put(pnr, passenger);

        System.out.println("\nTicket reserved successfully!");
    }

    private static void cancelTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCancel a Ticket:");
        System.out.print("Enter your PNR number: ");
        String pnr = scanner.nextLine();

        if (database.containsKey(pnr)) {
            Passenger passenger = database.get(pnr);
            System.out.println("\nPassenger Details:");
            System.out.println(passenger);

            System.out.print("Are you sure you want to cancel this ticket? (Y/N): ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("Y")) {
                database.remove(pnr);
                System.out.println("Ticket with PNR " + pnr + " has been canceled.");
            } else {
                System.out.println("Ticket not canceled. Returning to main menu...");
            }
        } else {
            System.out.println("Ticket with PNR " + pnr + " not found.");
        }
    }
}
