package exercise2;

import java.util.Scanner;

public class GameTesterDemo {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter Game Tester Name: ");
        String name = input.nextLine();

        System.out.println("Choose Tester Type (1 = Full-Time, 2 = Part-Time): ");
        int choice = input.nextInt();

        GameTester tester;

        if (choice == 1) {
            tester = new FullTimeGameTester(name);
        } else {
            System.out.println("Enter hours worked: ");
            int hours = input.nextInt();
            tester = new PartTimeGameTester(name, hours);
        }

        System.out.println("\n=== Game Tester Information ===");
        System.out.println("Name: " + tester.getName());
        System.out.println("Full-Time: " + tester.isFullTime());
        System.out.println("Salary: $" + tester.determineSalary());
    }
}