package com.billing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueProcess;

        System.out.println("=== Internet Data Usage Billing System ===");

        do {
            System.out.print("\nEnter Customer Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Plan Type (Basic, Standard, Premium): ");
            String plan = scanner.nextLine();

            System.out.print("Enter Data Consumed (in GB): ");
            double data = 0;
            try {
                data = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid numeric input for data usage. Skipping entry.");
                continue;
            }

            try {
                double grandTotal = BillingSystem.calculateBill(plan, data);
                System.out.println("\n--- Invoice Summary ---");
                System.out.println("Customer Name : " + name);
                System.out.println("Plan Picked   : " + plan.toUpperCase());
                System.out.println("Data Consumed : " + data + " GB");
                System.out.printf("Total Monthly Bill: $%.2f\n", grandTotal);
            } catch (IllegalArgumentException ex) {
                System.out.println("Error processing transaction: " + ex.getMessage());
            }

            System.out.print("\nWould you like to process another customer? (yes/no): ");
            continueProcess = scanner.nextLine().trim().toLowerCase();

        } while (continueProcess.equals("yes") || continueProcess.equals("y"));

        System.out.println("\nSystem shutting down. Thank you!");
        scanner.close();
    }
}
