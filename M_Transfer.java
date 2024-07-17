import java.util.InputMismatchException;
import java.util.Scanner;

public class M_Transfer {

    private final BankList bankList;
    MyAccount myAccount = new MyAccount();

    public M_Transfer(BankList bankList){
        this.bankList = bankList;
    }

    // Transfer among local accounts
    public void transferLocal (){
        Scanner scanner = new Scanner(System.in);
        while (true){
            int getNumber = getAccountNumberFromUser(scanner);
            if (getNumber == -1){
                continue;
            }
            LocalBank targetAccount = findAccountLocal(getNumber);
            if (targetAccount == null){
                System.out.println("Account not found. Please enter valid number account : ");
                continue;
            }
            int moneyInput = moneyToTransfer(scanner);

            while (moneyInput == -1) {
                System.out.println("Your balance is not enough.\n1. Check Balance\n2. Continue Transfer : ");
                int choice = scanner.nextInt();
                if (choice == 1){
                    System.out.println("Your balance : " + myAccount.getBalance());
                }else if (choice == 2){
                    moneyInput = moneyToTransfer(scanner);
                }else {
                    System.out.println("Invalid input. Please choice 1 or 2");
                }
            }

            doTransfer(targetAccount, moneyInput);
            System.out.println("Your current balance : " + myAccount.getBalance());
            break;
        }

    }

    // Transfer to general account
    public void transferGeneral (){
        Scanner scanner = new Scanner(System.in);
        while (true){
            int getNumber = getAccountNumberFromUser(scanner);
            if (getNumber == -1){
                continue;
            }
            GeneralBank targetAccount = findAccountGeneral(getNumber);
            if (targetAccount == null){
                System.out.println("Account not found. Please enter valid number account : ");
                continue;
            }
            int moneyInput = moneyToTransfer(scanner);

            while (moneyInput == -1) {
                System.out.println("Your balance is not enough.\n1. Check Balance\n2. Continue Transfer : ");
                int choice = scanner.nextInt();
                if (choice == 1){
                    System.out.println("Your balance : " + myAccount.getBalance());
                }else if (choice == 2){
                    moneyInput = moneyToTransfer(scanner);
                }else {
                    System.out.println("Invalid input. Please choice 1 or 2");
                }
            }

            doTransfer(targetAccount, moneyInput);
            System.out.println("Your current balance : " + myAccount.getBalance());
            break;
        }

    }

    private int getAccountNumberFromUser (Scanner scanner){
        try{
            System.out.println("Enter an account number that you want to transfer : ");
            return scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter correct number : ");
            scanner.nextLine();
            return -1;
        }
    }

    private LocalBank findAccountLocal (int accountNumber){
        for (Bank localbank : bankList.bankList){
            if (localbank.getAccountNumber() == accountNumber && localbank instanceof LocalBank){
                return (LocalBank) localbank;
            }
        }
        return null;
    }

    private GeneralBank findAccountGeneral (int accountNumber){
        for (Bank generalBank : bankList.bankList){
            if (generalBank.getAccountNumber() == accountNumber && generalBank  instanceof  GeneralBank){
                return (GeneralBank) generalBank;
            }
        }
        return null;
    }

    private int moneyToTransfer (Scanner scanner){

        try {
            System.out.println("Enter amount of money you want to transfer : ");
            int amountMoney = scanner.nextInt();
            if (amountMoney > 0 && amountMoney < myAccount.getBalance()){
                return amountMoney;
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid amount. Please enter a valid amount.");
            scanner.nextLine();
        }
        return -1;
    }
    private void doTransfer (LocalBank localBank,  int money){
        myAccount.setBalance(myAccount.getBalance() - money);
        System.out.println("Transfer from " + myAccount.getUsername() + " to " +
                localBank.getUsername() + " - " + localBank.getAccountNumber() +
                " with nominal : " + money + " success");
    }

    private void doTransfer (GeneralBank generalBank,  int money){
        myAccount.setBalance(myAccount.getBalance() - money);
        System.out.println("Transfer from " + myAccount.getUsername() + " to " +
                generalBank.getUsername() + " - " + generalBank.getBankName() + " " + generalBank.getAccountNumber() +
                " with nominal : " + money + " success");
    }
}