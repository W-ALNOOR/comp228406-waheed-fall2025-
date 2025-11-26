package exercise2;

public class PartTimeGameTester extends GameTester {

    private int hoursWorked;

    public PartTimeGameTester(String name, int hoursWorked) {
        super(name, false);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double determineSalary() {
        // $20 per hour
        return hoursWorked * 20;
    }
}