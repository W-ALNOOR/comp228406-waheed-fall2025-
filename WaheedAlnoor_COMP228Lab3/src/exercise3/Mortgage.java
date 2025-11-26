package exercise3;

public abstract class Mortgage implements MortgageConstants {

    protected String mortgageNumber;
    protected String customerName;
    protected double amount;
    protected double interestRate;
    protected int term;

    public Mortgage(String mortgageNumber, String customerName,
                    double amount, double interestRate, int term) {

        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;

        // Enforce maximum amount
        if (amount > MAX_MORTGAGE_AMOUNT) {
            System.out.println("The Amount exceeds maximum. Setting to " + MAX_MORTGAGE_AMOUNT);
            this.amount = MAX_MORTGAGE_AMOUNT;
        } else {
            this.amount = amount;
        }

        this.interestRate = interestRate;

        // Enforce allowed terms
        if (term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM) {
            this.term = term;
        } else {
            System.out.println("The Invalid term. Setting to short-term (" + SHORT_TERM + " year).");
            this.term = SHORT_TERM;
        }
    }

    public String getMortgageNumber() {
        return mortgageNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTerm() {
        return term;
    }

    public String getMortgageInfo() {
        double totalOwed = amount + (amount * (interestRate / 100.0) * term);

        return "Bank: " + BANK_NAME +
                "\nMortgage Number: " + mortgageNumber +
                "\nCustomer Name: " + customerName +
                "\nMortgage Amount: $" + String.format("%.2f", amount) +
                "\nInterest Rate: " + String.format("%.2f", interestRate) + "%" +
                "\nTerm: " + term + " year(s)" +
                "\nTotal Amount Owed (principal + interest): $" + String.format("%.2f", totalOwed);
    }
}