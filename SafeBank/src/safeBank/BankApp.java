package safeBank;

import safeBank.exceptions.InsufficientFundsException;
import safeBank.exceptions.InvalidAmountException;

import java.math.BigDecimal;
import java.util.Scanner;

public class BankApp {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        BankAccount account = new BankAccount("daniel", new BigDecimal("1000"));
        int choice;

        do{

            System.out.println("\n===== SAFE BANK =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");


            choice=Integer.parseInt(input.nextLine());

            switch(choice){

                case 1:
                    System.out.print("Your current Balance is " + account.getBalance());
                    break;

                case 2:
                    try {
                        System.out.print("Enter the amount you want to deposit: ");
                        BigDecimal depositAmount = new BigDecimal(input.nextLine());
                        account.deposit(depositAmount);
                        System.out.print("Deposit Sucessful ");
                    }catch (InvalidAmountException  | NumberFormatException e){
                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:
                    try {
                        System.out.print("Enter the amount you want to Withdraw: ");
                        BigDecimal withdrawAmount = new BigDecimal(input.nextLine());
                        account.withdraw(withdrawAmount);
                        System.out.print("Deposit Sucessful ");
                    }catch (InvalidAmountException | NumberFormatException | InsufficientFundsException e){
                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:
                    System.out.print(account.getTransactions());
                    break;

                case 5:
                    System.out.println("Thank you for banking with us!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }while (choice != 5);

        input.close();
    }
}
