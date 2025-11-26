package exercise1;


public class Health extends Insurance {

    public Health() {
        super("Health Insurance");
    }

    @Override
    public void setInsuranceCost(double cost) {
        this.monthlyCost = cost;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Health Insurance ===");
        System.out.println("Type: " + typeInsurance);
        System.out.println("The Monthly Cost is: $" + monthlyCost);
        System.out.println("------------------------");
    }
}