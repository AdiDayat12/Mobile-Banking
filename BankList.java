import java.util.ArrayList;
import java.util.List;

public class BankList {
    List<Bank> bankList = new ArrayList<>();

    //adding local account
    public void addAccount (LocalBank localBank){
        bankList.add(localBank);
        System.out.println("Account was successfully added");
    }

    //adding other bank account
    public void addAccount (GeneralBank otherBank){
        bankList.add(otherBank);
        System.out.println("Account was successfully added");
    }

    //display local account
    public void displayLocalAccounts (){
        int i = 1;
        for (Bank localbanks : bankList){
            if (localbanks instanceof LocalBank){
                System.out.println(i + "  " + localbanks.getAccountNumber() + " - " + localbanks.getUsername());
                i++;
            }
        }
    }

    //display general bank accounts
    public void displayGeneralBankAccounts (){
        int i = 1;
        for (Bank generalbanks : bankList){
            if (generalbanks instanceof GeneralBank){
                System.out.println(i + "  " + ((GeneralBank) generalbanks).getBankName() + " " + generalbanks.getAccountNumber() + " - " + generalbanks.getUsername());
                i++;
            }
        }
    }

}