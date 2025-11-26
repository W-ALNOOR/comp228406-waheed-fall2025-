package exercise3;

import java.util.Scanner;

public class ProcessMortgage {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the current prime interest rate (e.g., 5.5): ");
        double primeRate = input.nextDouble();
        input.nextLine(); // clear buffer

        Mortgage[] mortgages = new Mortgage[3];

        for (int i = 0; i < mortgages.length; i++) {
            System.out.println("\n--- Enter details for Mortgage #" + (i + 1) + " ---");

            System.out.print("Enter mortgage number: ");
            String number = input.nextLine();

            System.out.print("Enter customer name: ");
            String name = input.nextLine();

            System.out.print("Enter mortgage amount: ");
            double amount = input.nextDouble();

            System.out.print("Enter term in years (1, 3, or 5): ");
            int term = input.nextInt();
            input.nextLine(); // clear buffer

            System.out.print("Enter mortgage type (B = Business, P = Personal): ");
            String type = input.nextLine().trim().toUpperCase();

            Mortgage mortgage;

            if (type.equals("B")) {
                mortgage = new BusinessMortgage(number, name, amount, primeRate, term);
            } else {
                // Default to Personal if not 'B'
                mortgage = new PersonalMortgage(number, name, amount, primeRate, term);
            }

            mortgages[i] = mortgage;
        }

        System.out.println("\n===== ALL MORTGAGES INFORMATION =====");
        for (Mortgage m : mortgages) {
            System.out.println("-------------------------------------");
            System.out.println(m.getMortgageInfo());
        }

        input.close();
    }
}