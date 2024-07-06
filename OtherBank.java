public class OtherBank extends Bank{
    private String bankName;
    public OtherBank(int accountNumber, String username, String bankName) {
        super(accountNumber, username);
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
