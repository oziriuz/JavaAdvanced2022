package defining_classes.lab.bank_account;

public class BankAccount {
    private static int count = 1;
    private final int id;
    private double balance;
    private static double interestRate = 0.02;

    public BankAccount() {
        this.id = count++;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getInterest (int years) {
        return BankAccount.interestRate * years * this.balance;
    }

}
