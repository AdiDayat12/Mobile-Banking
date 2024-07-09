import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class M_Transfer {
    List<Bank> bankList;

    public M_Transfer (){
        bankList = new ArrayList<>();
    }

    //adding local bank account
    public void addAccount (LocalBank localBank){
        bankList.add(localBank);
        System.out.println("Account successfully added");
    }

    //adding other bank account
    public void addAccount (OtherBank otherBank){
        bankList.add(otherBank);
        System.out.println("Account successfully added");
    }

    // Transfer among local bank
    public void transfer(MyAccount myAccount, LocalBank localBank) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Account List : ");
            int i = 1;
            for (Bank localBankList : bankList) {
                if (localBankList instanceof LocalBank) {
                    System.out.println(i + " " + localBankList.getAccountNumber() + " - " + localBankList.getUsername());
                    i++; // Increment i here
                }
            }
            try {
                System.out.println("Enter account number you want to transfer : ");
                int accountToTransfer = scanner.nextInt();
                boolean accountFound = false;
                for (Bank localBankList : bankList) {
                    if (localBankList.getAccountNumber() == accountToTransfer) {
                        accountFound = true;

                        while (true) {
                            try {
                                System.out.println("Enter the amount of money that you want to transfer:");
                                int money = scanner.nextInt();

                                if (money <= 0) {
                                    System.out.println("Invalid amount. Please enter a positive number.");
                                    continue;
                                }
                                if (money > myAccount.getBalance()) {
                                    System.out.println("Your balance is not enough. Please enter a valid amount.");
                                    continue;
                                }
                                // If money is valid, do transfer
                                myAccount.withdraw(money);
                                localBank.deposit(money);

                                System.out.println("Transfer from: " + myAccount.getUsername() + " with account number: " +
                                        myAccount.getAccountNumber() + " to: " + localBank.getUsername() + " (" +
                                        localBank.getAccountNumber() + ") success");

                                break; // Break out of the inner while loop
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid number of money:");
                                scanner.nextLine(); // Clear the input buffer
                            }
                        }
                        break; // Break out of the outer for loop if account is found
                    }
                }
                if (!accountFound) {
                    System.out.println("Account not found. Please enter a valid account number.");
                } else {
                    break; // Break out of the outer while loop if transfer is successful
                }
            } catch (InputMismatchException | NullPointerException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
        scanner.close();
    }


    public void transfer (int accountNumber, String username, String bankName){
        int i = 1;
        for (Bank otherBank : bankList){
            if (otherBank instanceof OtherBank){
                System.out.println(i + " " + otherBank.getAccountNumber() + " " + otherBank.getUsername());
                i++;
            }
        }
    }

}
