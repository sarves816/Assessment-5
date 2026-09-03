package com.booking;

public class EventTicketBooking {

    private String customerName;
    private String email;
    private int numberOfTickets;
    private String category;
    private double pricePerTicket;
    private double totalAmount;
    private double discount;

    public EventTicketBooking(String customerName, String email, int numberOfTickets, String category) {
        this.customerName = customerName;
        this.email = email;
        this.numberOfTickets = numberOfTickets;
        this.category = category;
    }

    public void calculateAmount() {

        if (category.equalsIgnoreCase("Regular")) {
            pricePerTicket = 500;
        } else if (category.equalsIgnoreCase("Premium")) {
            pricePerTicket = 1000;
        } else if (category.equalsIgnoreCase("VIP")) {
            pricePerTicket = 2000;
        } else {
            pricePerTicket = 0;
        }

        totalAmount = numberOfTickets * pricePerTicket;

        if (numberOfTickets >= 5) {
            discount = totalAmount * 0.10;
        } else {
            discount = 0;
        }

        totalAmount = totalAmount - discount;
    }

    public void displayBooking() {

        System.out.println("\n===== EVENT TICKET BOOKING DETAILS =====");
        System.out.println("Customer Name   : " + customerName);
        System.out.println("Email           : " + email);
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.println("Category        : " + category);
        System.out.println("Price Per Ticket: Rs." + pricePerTicket);
        System.out.println("Discount        : Rs." + discount);
        System.out.println("Total Amount    : Rs." + totalAmount);
        System.out.println("========================================");
    }
}
