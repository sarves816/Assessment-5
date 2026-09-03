package com.booking;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== EVENT TICKET BOOKING SYSTEM =====");

        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Number of Tickets: ");
        int numberOfTickets = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Ticket Category (Regular/Premium/VIP): ");
        String category = sc.nextLine();

        EventTicketBooking booking =
                new EventTicketBooking(customerName, email, numberOfTickets, category);

        booking.calculateAmount();
        booking.displayBooking();

        sc.close();
    }
}
