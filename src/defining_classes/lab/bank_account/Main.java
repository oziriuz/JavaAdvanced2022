package defining_classes.lab.bank_account;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!input.equals("End")) {
            String[] command = input.split("\\s");

            if (command[0].equals("Create")) {
                BankAccount account = new BankAccount();
                bankAccounts.put(account.getId(), account);
                System.out.printf("Account ID%d created%n", account.getId());
            } else if (command[0].equals("Deposit")) {
                int id = Integer.parseInt(command[1]);
                double amount = Double.parseDouble(command[2]);

                if (bankAccounts.containsKey(id)) {
                    bankAccounts.get(id).deposit(amount);
                    System.out.printf("Deposited %.0f to ID%d%n", amount, bankAccounts.get(id).getId());
                } else {
                    printNoAccount();
                }
            } else if (command[0].equals("GetInterest")) {
                int id = Integer.parseInt(command[1]);
                int years = Integer.parseInt(command[2]);

                if (bankAccounts.containsKey(id)) {
                    System.out.printf("%.2f%n", bankAccounts.get(id).getInterest(years));
                } else {
                    printNoAccount();
                }
            } else if (command[0].equals("SetInterest")) {
                double interestRate = Double.parseDouble(command[1]);
                BankAccount.setInterestRate(interestRate);
            }

            input = scanner.nextLine();
        }
    }

    private static void printNoAccount() {
        System.out.println("Account does not exist");
    }
}
