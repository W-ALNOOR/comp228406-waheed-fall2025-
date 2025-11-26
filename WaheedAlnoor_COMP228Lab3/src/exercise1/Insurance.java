package exercise1;

public abstract class Insurance {

    protected String typeInsurance;
    protected double monthlyCost;

    public Insurance(String typeInsurance) {
        this.typeInsurance = typeInsurance;
    }

    public String getTypeInsurance() {
        return typeInsurance;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    // abstract methods
    public abstract void setInsuranceCost(double cost);
    public abstract void displayInfo();
}