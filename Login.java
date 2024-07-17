import java.util.Scanner;

public class Login {
    MyAccount myAccount = new MyAccount();
    Scanner scanner = new Scanner(System.in);
    public boolean login (){
        System.out.println("Enter Password : ");
        String pass = scanner.nextLine();
        return pass.equals(myAccount.getPass());
    }
}
