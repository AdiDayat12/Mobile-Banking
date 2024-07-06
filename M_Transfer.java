import java.util.ArrayList;
import java.util.List;

public class M_Transfer {
    List<Bank> bankList;

    public M_Transfer (){
        this.bankList = new ArrayList<>();
    }

    public void addAccount (LocalBank localBank){
        bankList.add(localBank);
        System.out.println("Account successfully added");
    }
    public void addAccount (OtherBank otherBank){
        bankList.add(otherBank);
        System.out.println("Account successfully added");
    }
}
