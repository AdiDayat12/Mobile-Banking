public abstract class Bank {
    private int accountNumber;
    private String username;

    public Bank (int accountNumber, String username){
        this.accountNumber = accountNumber;
        this.username = username;
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
}
