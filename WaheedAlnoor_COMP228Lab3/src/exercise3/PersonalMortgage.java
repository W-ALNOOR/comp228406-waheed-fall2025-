package exercise3;

public class PersonalMortgage extends Mortgage {

    public PersonalMortgage(String mortgageNumber, String customerName,
                            double amount, double currentPrimeRate, int term) {

        // Personal mortgage: prime + 2%
        super(mortgageNumber, customerName, amount, currentPrimeRate + 2.0, term);
    }
}