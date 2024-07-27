import java.util.InputMismatchException;
import java.util.Scanner;

public class M_Transfer {

    // Transfer among local accounts
    public void transferLocal (BankList bankList, MyAccount myAccount){
        Scanner scanner = new Scanner(System.in);
        while (true){
            int getNumber = getAccountNumberFromUser(scanner);
            if (getNumber == -1){
                continue;
            } else if (getNumber == 0) {
                break;
            }
            LocalBank targetAccount = findAccountLocal(getNumber, bankList);
            if (targetAccount == null){
                System.out.println("Account not found. Please enter valid number account : ");
                continue;
            }
            int moneyInput = moneyToTransfer(scanner, myAccount);

            if (moneyInput == 0){
                System.out.println("Cannot transfer 0");
                continue;
            }
            while (moneyInput == -1) {
                System.out.println("Your balance is not enough.\n1. Check Balance\n2. Continue Transfer : ");
                int choice = scanner.nextInt();
                if (choice == 1){
                    System.out.println("Your balance : " + myAccount.getBalance());
                }else if (choice == 2){
                    moneyInput = moneyToTransfer(scanner, myAccount);
                }else {
                    System.out.println("Invalid input. Please choice 1 or 2");
                }
            }

            System.out.println("Are you sure want to do this tranfer ? y / n");
            String validate = scanner.next();
            if (validate.equalsIgnoreCase("n")){
                break;
            }
            doTransfer(targetAccount, moneyInput, myAccount);
            System.out.println("Your current balance : " + myAccount.getBalance());
            break;
        }

    }

    // Transfer to general account
    public void transferGeneral (BankList bankList, MyAccount myAccount){
        Scanner scanner = new Scanner(System.in);
        while (true){
            int getNumber = getAccountNumberFromUser(scanner);
            if (getNumber == -1){
                continue;
            } else if (getNumber == 0) {
                break;
            }
            GeneralBank targetAccount = findAccountGeneral(getNumber, bankList);
            if (targetAccount == null){
                System.out.println("Account not found. Please enter valid number account : ");
                continue;
            }
            int moneyInput = moneyToTransfer(scanner, myAccount);

            if (moneyInput == 0){
                System.out.println("Cannot transfer 0");
                continue;
            }

            while (moneyInput == -1) {
                System.out.println("Your balance is not enough.\n1. Check Balance\n2. Continue Transfer : ");
                int choice = scanner.nextInt();
                if (choice == 1){
                    System.out.println("Your balance : " + myAccount.getBalance());
                }else if (choice == 2){
                    moneyInput = moneyToTransfer(scanner, myAccount);
                }else {
                    System.out.println("Invalid input. Please choice 1 or 2");
                }
            }

            doTransfer(targetAccount, moneyInput, myAccount);
            System.out.println("Your current balance : " + myAccount.getBalance());
            break;
        }

    }

    private int getAccountNumberFromUser (Scanner scanner){
        try{
            System.out.println("Enter an account number that you want to transfer : (press 0 to cancel) ");
            return scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter correct number : ");
            scanner.nextLine();
            return -1;
        }
    }

    private LocalBank findAccountLocal (int accountNumber, BankList bankList){
        for (Bank localbank : bankList.bankList){
            if (localbank.getAccountNumber() == accountNumber && localbank instanceof LocalBank){
                return (LocalBank) localbank;
            }
        }
        return null;
    }

    private GeneralBank findAccountGeneral (int accountNumber, BankList bankList){
        for (Bank generalBank : bankList.bankList){
            if (generalBank.getAccountNumber() == accountNumber && generalBank  instanceof  GeneralBank){
                return (GeneralBank) generalBank;
            }
        }
        return null;
    }

    private int moneyToTransfer (Scanner scanner, MyAccount myAccount){

        try {
            System.out.println("Enter amount of money you want to transfer :  ");
            int amountMoney = scanner.nextInt();
            if (amountMoney < myAccount.getBalance()){
                return amountMoney;
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid amount. Please enter a valid amount.");
            scanner.nextLine();
        }
        return -1;
    }
    private void doTransfer (LocalBank localBank,  int money, MyAccount myAccount){
        myAccount.setBalance(myAccount.getBalance() - money);
        System.out.println("Transfer from " + myAccount.getUsername() + " to " +
                localBank.getUsername() + " - " + localBank.getAccountNumber() +
                " with nominal : " + money + " success");
    }

    private void doTransfer (GeneralBank generalBank,  int money, MyAccount myAccount){
        myAccount.setBalance(myAccount.getBalance() - money);
        System.out.println("Transfer from " + myAccount.getUsername() + " to " +
                generalBank.getUsername() + " - " + generalBank.getBankName() + " " + generalBank.getAccountNumber() +
                " with nominal : " + money + " success");
    }
}