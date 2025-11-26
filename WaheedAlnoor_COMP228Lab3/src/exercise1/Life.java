package exercise1;

public class Life extends Insurance {

    public Life() {
        super("Life Insurance");
    }

    @Override
    public void setInsuranceCost(double cost) {
        this.monthlyCost = cost;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Life Insurance ===");
        System.out.println("Type: " + typeInsurance);
        System.out.println("Monthly Cost: $" + monthlyCost);
        System.out.println("----------------------");
    }
}