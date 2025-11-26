package exercise3;

public class BusinessMortgage extends Mortgage {

    public BusinessMortgage(String mortgageNumber, String customerName,
                            double amount, double currentPrimeRate, int term) {

        // Business mortgage: prime + 1%
        super(mortgageNumber, customerName, amount, currentPrimeRate + 1.0, term);
    }
}