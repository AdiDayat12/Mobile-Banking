import java.util.Objects;

public class LocalBank extends Bank {
    public LocalBank(int accountNumber, String username, int balance) {
        super(accountNumber, username, balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountNumber(), getUsername());
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocalBank other = (LocalBank) obj;
        return getAccountNumber() == other.getAccountNumber();
    }
}
