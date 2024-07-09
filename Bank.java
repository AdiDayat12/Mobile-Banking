public abstract class Bank {
    private int accountNumber;
    private String username;
    private int balance;

    public Bank (int accountNumber, String username, int balance){
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void deposit(int money) {
        balance += money;
    }
}
