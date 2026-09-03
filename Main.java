package com.billing;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String continueProcess = "yes";

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
                System.out.println("Total Bill    : $" + grandTotal);

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("\nDo you want to process another customer? (yes/no): ");
            continueProcess = scanner.nextLine();

        } while (continueProcess.equalsIgnoreCase("yes"));

        System.out.println("\nThank you for using the Internet Data Usage Billing System.");

        scanner.close();
    }
}
