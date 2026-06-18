import java.util.Scanner;

class Flight {
    String flightName;
    String source;
    String destination;
    int availableSeats;
    double ticketPrice;

    Flight(String flightName, String source, String destination, int availableSeats, double ticketPrice) {
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
    }

    void displayFlight() {
        System.out.println("\nFlight Name: " + flightName);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Ticket Price: ₹" + ticketPrice);
    }

    boolean bookSeats(int seats) {
        if (seats <= availableSeats) {
            availableSeats -= seats;
            return true;
        }
        return false;
    }
}

public class FlightBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Flight f1 = new Flight("IndiGo 6E101", "Bhubaneswar", "Delhi", 50, 5000);
        Flight f2 = new Flight("Air India AI202", "Bhubaneswar", "Mumbai", 40, 6000);
        Flight f3 = new Flight("Vistara UK303", "Bhubaneswar", "Bangalore", 30, 5500);

        while (true) {
            System.out.println("\n===== FLIGHT BOOKING SYSTEM =====");
            System.out.println("1. View Flights");
            System.out.println("2. Book Ticket");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Flights:");
                    System.out.println("1. IndiGo 6E101");
                    System.out.println("2. Air India AI202");
                    System.out.println("3. Vistara UK303");

                    f1.displayFlight();
                    f2.displayFlight();
                    f3.displayFlight();
                    break;

                case 2:
                    System.out.print("\nEnter Passenger Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    System.out.println("\nSelect Flight:");
                    System.out.println("1. IndiGo 6E101");
                    System.out.println("2. Air India AI202");
                    System.out.println("3. Vistara UK303");
                    System.out.print("Choice: ");
                    int flightChoice = sc.nextInt();

                    System.out.print("Number of Seats: ");
                    int seats = sc.nextInt();

                    Flight selectedFlight = null;

                    if (flightChoice == 1)
                        selectedFlight = f1;
                    else if (flightChoice == 2)
                        selectedFlight = f2;
                    else if (flightChoice == 3)
                        selectedFlight = f3;

                    if (selectedFlight != null && selectedFlight.bookSeats(seats)) {
                        double totalAmount = seats * selectedFlight.ticketPrice;

                        System.out.println("\n===== BOOKING CONFIRMED =====");
                        System.out.println("Passenger Name: " + name);
                        System.out.println("Flight: " + selectedFlight.flightName);
                        System.out.println("Route: " + selectedFlight.source + " -> " + selectedFlight.destination);
                        System.out.println("Seats Booked: " + seats);
                        System.out.println("Total Fare: ₹" + totalAmount);
                    } else {
                        System.out.println("\nSorry! Not enough seats available.");
                    }
                    break;

                case 3:
                    System.out.println("\nThank You for Using Flight Booking System!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("\nInvalid Choice!");
            }
        }
    }
}