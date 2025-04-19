import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bus {
    private int busNumber;
    private int totalSeats;
    private int availableSeats;
    private double pricePerSeat;
    private double totalRevenue;
    private String destination;
    private String departureTime;
    private List<Integer> bookedSeats;

    public Bus(int num, int total, double price, String destination, String time) {
        this.busNumber = num;
        this.totalSeats = total;
        this.availableSeats = total;
        this.pricePerSeat = price;
        this.totalRevenue = 0.0;
        this.destination = destination;
        this.departureTime = time;
        this.bookedSeats = new ArrayList<>();
    }

    public int getBusNumber() {
        return busNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeat(int seats) {
        if (availableSeats >= seats) {
            availableSeats -= seats;
            double totalPrice = seats * this.pricePerSeat;
            totalRevenue += totalPrice;

            List<Integer> allocatedSeats = new ArrayList<>();
            for (int i = 1; i <= totalSeats; i++) {
                if (!bookedSeats.contains(i)) {
                    allocatedSeats.add(i);
                    bookedSeats.add(i);
                    if (allocatedSeats.size() == seats) break;
                }
            }

            System.out.printf("Total Price: ₹%.2f%n", totalPrice);
            System.out.println("Seats booked successfully for " + destination + " at " + departureTime + "!");
            System.out.println("Allocated Seat Numbers: " + allocatedSeats);
            System.out.println("Remaining Available Seats: " + availableSeats);
        } else {
            System.out.println("Sorry, not enough seats available.");
        }
    }

    public void cancelReservation(int seats) {
        if (seats > bookedSeats.size()) {
            System.out.println("Error: You cannot cancel more seats than booked!");
            return;
        }

        availableSeats += seats;
        double refundAmount = seats * pricePerSeat;
        totalRevenue -= refundAmount;

        List<Integer> removedSeats = new ArrayList<>();
        for (int i = 0; i < seats; i++) {
            removedSeats.add(bookedSeats.remove(0));
        }

        System.out.println("Reservation canceled successfully for " + destination + " at " + departureTime + "!");
        System.out.printf("Refund Amount: ₹%.2f%n", refundAmount);
        System.out.println("Canceled Seat Numbers: " + removedSeats);
        System.out.println("Remaining Available Seats: " + availableSeats);
    }

    public void display() {
        System.out.println("==================================================");
        System.out.println("Bus Number: " + busNumber);
        System.out.println("Destination: " + destination);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Booked Seats: " + bookedSeats);
        System.out.printf("Price Per Seat: ₹%.2f%n", pricePerSeat);
        System.out.printf("Total Revenue: ₹%.2f%n", totalRevenue);
    }
}

class Reservation {
    private List<Bus> buses;

    public Reservation(List<Bus> buses) {
        this.buses = buses;
    }

    public void bookSeat(Scanner scanner) {
        System.out.print("Enter Destination: ");
        scanner.nextLine(); // Consume newline
        String destination = scanner.nextLine();

        List<Bus> filteredBuses = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getDestination().equalsIgnoreCase(destination)) {
                filteredBuses.add(bus);
            }
        }

        if (filteredBuses.isEmpty()) {
            System.out.println("No buses available for this destination.");
            return;
        }

        System.out.println("Available buses for " + destination + ":");
        for (Bus bus : filteredBuses) {
            System.out.println("Bus Number: " + bus.getBusNumber() + " | Time: " + bus.getDepartureTime());
        }

        System.out.print("Enter Departure Time: ");
        String selectedTime = scanner.nextLine();

        Bus selectedBus = null;
        for (Bus bus : filteredBuses) {
            if (bus.getDepartureTime().equalsIgnoreCase(selectedTime)) {
                selectedBus = bus;
                break;
            }
        }

        if (selectedBus == null) {
            System.out.println("Invalid time selected. Please try again.");
            return;
        }

        System.out.print("Enter Number of Seats: ");
        int seats = scanner.nextInt();
        selectedBus.bookSeat(seats);
    }

    public void cancelReservation(Scanner scanner) {
        System.out.print("Enter Destination: ");
        scanner.nextLine(); // Consume newline
        String destination = scanner.nextLine();

        List<Bus> filteredBuses = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getDestination().equalsIgnoreCase(destination)) {
                filteredBuses.add(bus);
            }
        }

        if (filteredBuses.isEmpty()) {
            System.out.println("No buses available for this destination.");
            return;
        }

        System.out.println("Available buses for " + destination + ":");
        for (Bus bus : filteredBuses) {
            System.out.println("Bus Number: " + bus.getBusNumber() + " | Time: " + bus.getDepartureTime());
        }

        System.out.print("Enter Departure Time: ");
        String selectedTime = scanner.nextLine();

        Bus selectedBus = null;
        for (Bus bus : filteredBuses) {
            if (bus.getDepartureTime().equalsIgnoreCase(selectedTime)) {
                selectedBus = bus;
                break;
            }
        }

        if (selectedBus == null) {
            System.out.println("Invalid time selected. Please try again.");
            return;
        }

        System.out.print("Enter Number of Seats to cancel: ");
        int seats = scanner.nextInt();
        selectedBus.cancelReservation(seats);
    }
}

public class BusReservationSystem {
    public static void main(String[] args) {
        List<Bus> buses = new ArrayList<>();

        // Multiple buses for the same destination at different times
        buses.add(new Bus(101, 30, 25.0, "Surendranagar To Ahmedabad", "08:00 AM"));
        buses.add(new Bus(102, 30, 25.0, "Surendranagar To Ahmedabad", "12:00 PM"));
        buses.add(new Bus(103, 30, 25.0, "Surendranagar To Ahmedabad", "06:00 PM"));

        // Other destinations
        buses.add(new Bus(104, 40, 20.0, "Surendranagar To Rajkot", "09:00 AM"));
        buses.add(new Bus(105, 25, 30.0, "Surendranagar To Junagadh", "03:00 PM"));

        Reservation reservation = new Reservation(buses);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("============================================================");
            System.out.println("                 Bus Reservation System                     ");
            System.out.println("============================================================");
            System.out.println("1. Show Available Buses");
            System.out.println("2. Book Seats");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (Bus bus : buses) {
                        bus.display();
                        System.out.println();
                    }
                    break;
                case 2:
                    reservation.bookSeat(scanner);
                    break;
                case 3:
                    reservation.cancelReservation(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 4);

        scanner.close();
    }
}
