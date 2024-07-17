public class MyAccount {
    private int balance = 50000;

    public String getUsername() {
        return "Mr. Fatih";
    }

    public int getAccountNumber() {
        return 123456;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withdraw(int money) {
        balance -= money;
    }
    public String getPass (){
        return "admin123";
    }
}
