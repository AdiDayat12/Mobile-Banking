import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;



public class Main {
    static MyAccount myAccount = new MyAccount();
    static LocalBank localBank;
    GeneralBank generalBank;
    M_Transfer mTransfer = new M_Transfer();
    static BankList bankList = new BankList();
    Login login = new Login();
    Scanner scanner = new Scanner(System.in);
    Stack<Integer> navigation = new Stack<>();
    int i = 0;

    public static void main(String[] args) {

        Main mainApp = new Main();

        mainApp.run();


    }

    public void run() {
        while (true){
            System.out.println("Choose an option : \n1. Check Balance\n2. Transfer\n0. Quit");
            int choice = scanner.nextInt();

            switch (choice){
                case 1 :
                    System.out.println("My Balance : " + myAccount.getBalance() + "\n");
                    break;
                case 2 :
                    while (true){
                        System.out.println("""
                            Chose option :
                            1. Add account
                            2. Add general account
                            3. Transfer to local account
                            4. Transfer to general account
                            0. Quit""");
                        int choiceTransfer = scanner.nextInt();

                        if (choiceTransfer == 1){
                            addLocalAccount(scanner);
                        } else if (choiceTransfer == 2) {
                            addGeneralAccount(scanner);
                        } else if (choiceTransfer == 3 && bankList.displayLocalAccounts()) {
                            mTransfer.transferLocal(bankList, myAccount);
                        } else if (choiceTransfer == 4 && bankList.displayGeneralBankAccounts()) {
                            mTransfer.transferGeneral(bankList, myAccount);
                        } else if (choiceTransfer == 0) {
                            break;
                        } else if (choiceTransfer == 5) {
                            bankList.displayAllBank();
                        }
                    }
                    break;
                case 0 :
                    System.out.println("Thank you !!!");
                    return;
                default:
                    System.out.println("Invalid input !");
            }
        }
    }


    public static int readInt (Scanner scanner, String prompt){
        System.out.println(prompt);
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
    public static String readString (Scanner scanner, String prompt){
        System.out.println(prompt);
        return scanner.nextLine();
    }
    public static void addLocalAccount (Scanner s){
        int accountNumber;
        String username;
        while (true){
            try{
                accountNumber= readInt(s, "Enter account Number : ");
                break;
            }catch (InputMismatchException e){
                System.out.println("Please input invalid number");
                s.nextLine();
            }
        }
        while (true){
            try {
                username = readString(s, "Enter username : ");
                break;
            }catch (InputMismatchException e){
                System.out.println("Please input invalid username");
                s.nextLine();
            }
        }
        bankList.addAccount(new LocalBank(accountNumber, username, 0));

    }

    public static void addGeneralAccount (Scanner s){
        int accountNumber;
        String username;
        String bankName;

        while (true){
            try {
                accountNumber = readInt(s, "Enter account number : ");
                break;
            }catch (InputMismatchException e){
                System.out.println("Invalid input.");
            }
        }

        username = readString(s, "Enter username : ");
        bankName = readString(s, "Enter bank name : ");
        bankList.addAccount(new GeneralBank(accountNumber, username, bankName, 0));
    }


}