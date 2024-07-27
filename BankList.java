import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BankList {
    Set<Bank> bankList = new HashSet<>();

    //adding local account
    public void addAccount (LocalBank localBank){
        if (!checkUserLocal(localBank)){
            System.out.println("Fail to add account. Please enter another number and username");
        } else {
            bankList.add(localBank);
            System.out.println("Account was successfully added\n");
        }

    }

    boolean checkUserLocal (LocalBank localBank){
        for (Bank bank : bankList){
            if (bank instanceof LocalBank && (bank.getAccountNumber() == localBank.getAccountNumber() || bank.getUsername().equalsIgnoreCase(localBank.getUsername()))){
                return false;
            }
        }
        return true;
    }

    public void displayAllBank (){
        for (Bank bank : bankList){
            System.out.println("Ini " + bank);
        }
    }

    //adding other bank account
    public void addAccount (GeneralBank generalBank){
        if (checkGeneralUser(generalBank)){
            System.out.println("Fail to add account. Please enter another number and username");
        }else {
            bankList.add(generalBank);
            System.out.println("Account was successfully added\n");
        }
    }

    boolean checkGeneralUser (GeneralBank generalBank){
        for (Bank bank : bankList){
            if (bank instanceof GeneralBank && (bank.getAccountNumber() == generalBank.getAccountNumber() || bank.getUsername().equalsIgnoreCase(generalBank.getUsername()))){
                return false;
            }
        }
        return true;
    }

    //display local account
    public boolean displayLocalAccounts (){
        boolean hasAccount = false;
        int i = 1;
        for (Bank localbanks : bankList){
            if (localbanks instanceof LocalBank){
                System.out.println(i + "  " + localbanks.getAccountNumber() + " - " + localbanks.getUsername());
                i++;
            }
            hasAccount = true;
        }
        System.out.println("\n");
        if (!hasAccount){
            System.out.println("No account found. Please add account first\n");
        }
        return hasAccount;
    }

    //display general bank accounts
    public boolean displayGeneralBankAccounts (){
        boolean hasAccount = false;
        int i = 1;
        for (Bank generalbanks : bankList){
            if (generalbanks instanceof GeneralBank){
                System.out.println(i + " - " + ((GeneralBank) generalbanks).getBankName() + " - " + generalbanks.getAccountNumber() + " - " + generalbanks.getUsername());
                i++;
            }
            hasAccount = true;
        }
        System.out.println("\n");
        if (!hasAccount){
            System.out.println("No account found. Please add first !\n");
        }
        return hasAccount;
    }

}