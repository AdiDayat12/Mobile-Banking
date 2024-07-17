public class GeneralBank extends Bank{
    private String bankName;
    public GeneralBank(int accountNumber, String username, String bankName, int balance) {
        super(accountNumber, username, balance);
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
