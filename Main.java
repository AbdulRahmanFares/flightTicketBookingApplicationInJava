import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        bookFlight();
    }

    static int ticketsCountForFlight1 = 50;
    static int ticketsCostForFlight1 = 5000;
    static int ticketsCountForFlight2 = 50;
    static int ticketsCostForFlight2 = 5000;
    static Integer passengerId = 0;
    static HashMap<Integer, int[]> passengersTicketsDetailsForFlight1 = new HashMap<>();
    static HashMap<Integer, int[]> passengersTicketsDetailsForFlight2 = new HashMap<>();

    static void bookFlight() {
        Scanner obj = new Scanner(System.in);

        System.out.println("1. Book 2. Cancel 3. Print 4. Exit");
        int option = obj.nextInt();

        // Booking tickets
        if (option == 1) {
            System.out.println("Enter the flight number: ");
            int flightNumber = obj.nextInt();

            if (flightNumber == 1) {
                // Booking tickets on flight 1
                System.out.println("Flight 1: Ticket count - " + ticketsCountForFlight1 + ", Cost of each ticket - " + ticketsCostForFlight1);
                System.out.println("Enter the number of tickets you want: ");
                int numberOfTickets = obj.nextInt();

                if (ticketsCountForFlight1 - numberOfTickets >= 0) {
                    passengerId++;
                    int totalCostOfBookedTickets = numberOfTickets * ticketsCostForFlight1;
                    System.out.println("Pasenger id " + passengerId + ": Number of tickets - " + numberOfTickets + ", Total cost - " + totalCostOfBookedTickets);
                    int[] passengerTicketDetails = {numberOfTickets, totalCostOfBookedTickets};
                    passengersTicketsDetailsForFlight1.put(passengerId, passengerTicketDetails);
                    ticketsCountForFlight1 -= numberOfTickets;
                    ticketsCostForFlight1 += numberOfTickets * 200;
                    bookFlight();
                }
            } else if (flightNumber == 2) {
                // Booking tickets on flight 2
                System.out.println("Flight 2: Ticket count - " + ticketsCountForFlight2 + ", Cost of each ticket - " + ticketsCostForFlight2);
                System.out.println("Enter the number of tickets you want: ");
                int numberOfTickets = obj.nextInt();

                if (ticketsCountForFlight2 - numberOfTickets >= 0) {
                    passengerId++;
                    int totalCostOfBookedTickets = numberOfTickets * ticketsCostForFlight2;
                    System.out.println("Pasenger id " + passengerId + ": Number of tickets - " + numberOfTickets + ", Total cost - " + totalCostOfBookedTickets);
                    int[] passengerTicketDetails = {numberOfTickets, totalCostOfBookedTickets};
                    passengersTicketsDetailsForFlight2.put(passengerId, passengerTicketDetails);
                    ticketsCountForFlight2 -= numberOfTickets;
                    ticketsCostForFlight2 += numberOfTickets * 200;
                    bookFlight();
                }
            } else {
                System.out.println("Invalid flight number!");
                bookFlight();
            }
        }

        // Cancel tickets
        if (option == 2) {
            System.out.println("Enter the flight number and passenger id: ");
            int flightIdEntered = obj.nextInt();
            int passengerIdEntered = obj.nextInt();
            if (flightIdEntered == 1 || flightIdEntered == 2) {
                if (flightIdEntered == 1) {
                    if (passengersTicketsDetailsForFlight1.containsKey(passengerIdEntered)) {
                        int[] value = passengersTicketsDetailsForFlight1.get(passengerIdEntered);
                        System.out.println("Refund amount for " + value[0] + " tickets - " + value[1]);
                        ticketsCountForFlight1 += value[0];
                        ticketsCostForFlight1 -= value[0] * 200;
                        passengersTicketsDetailsForFlight1.remove(passengerIdEntered);
                    } else {
                        System.out.println("Invalid passenger id!");
                        bookFlight();
                    }
                } else if (flightIdEntered == 2) {
                    if (passengersTicketsDetailsForFlight2.containsKey(passengerIdEntered)) {
                        int[] values = passengersTicketsDetailsForFlight2.get(passengerIdEntered);
                        System.out.println("Refund amount for " + values[0] + " tickets - " + values[1]);
                        ticketsCountForFlight2 += values[0];
                        ticketsCostForFlight2 -= values[0] * 200;
                        passengersTicketsDetailsForFlight2.remove(passengerIdEntered);
                    } else {
                        System.out.println("Invalid passenger id!");
                        bookFlight();
                    }
                }

                System.out.println("Flight 1:");
                for (HashMap.Entry<Integer, int[]> i : passengersTicketsDetailsForFlight1.entrySet()) {
                    Integer key = i.getKey();
                    int[] value = i.getValue();
                    System.out.println("Passenger id " + key + ": Number of tickets - " + value[0] + ", Total cost - " + value[1]);
                }
                System.out.println("Flight 2:");
                for (HashMap.Entry<Integer, int[]> i : passengersTicketsDetailsForFlight2.entrySet()) {
                    Integer key = i.getKey();
                    int[] value = i.getValue();
                    System.out.println("Passenger id " + key + ": Number of tickets - " + value[0] + ", Total cost - " + value[1]);
                }

                bookFlight();
            } else {
                System.out.println("Invalid flight number!");
                bookFlight();
            }
        }

        // Print
        if (option == 3) {
            System.out.println("Flight 1:");
            for (HashMap.Entry<Integer, int[]> i : passengersTicketsDetailsForFlight1.entrySet()) {
                Integer key = i.getKey();
                int[] value = i.getValue();
                System.out.println("Passenger id " + key + ": Number of tickets - " + value[0] + ", Total cost - " + value[1]);
            }

            System.out.println("Flight 2:");
            for (HashMap.Entry<Integer, int[]> i : passengersTicketsDetailsForFlight2.entrySet()) {
                Integer key = i.getKey();
                int[] value = i.getValue();
                System.out.println("Passenger id " + key + ": Number of tickets - " + value[0] + ", Total cost - " + value[1]);
            }
            bookFlight();
        }

        // Exit
        if (option == 4) {
            System.out.println("Thank you!");
        }

        obj.close();
    }
}

