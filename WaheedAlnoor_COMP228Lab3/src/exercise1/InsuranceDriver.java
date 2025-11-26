package exercise1;

import java.util.Scanner;

public class InsuranceDriver {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // store Insurance objects
        Insurance[] insuranceList = new Insurance[2];

        for (int i = 0; i < insuranceList.length; i++) {

            System.out.print("Please Enter insurance type (life/health): ");
            String type = input.nextLine().toLowerCase();

            System.out.print("Please Enter monthly cost: ");
            double cost = input.nextDouble();
            input.nextLine();

            Insurance obj;

            if (type.equals("life")) {
                obj = new Life();
            } else if (type.equals("health")) {
                obj = new Health();
            } else {
                System.out.println("Invalid type. Defaulting to Health Insurance.");
                obj = new Health();
            }

            obj.setInsuranceCost(cost);
            insuranceList[i] = obj;
        }

        System.out.println("\n=== DISPLAYING ALL INSURANCE INFORMATION (Polymorphism) ===");

        for (Insurance ins : insuranceList) {
            ins.displayInfo();
        }
    }
}