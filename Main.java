public class Main {
    public static void main(String[] args) {
        LocalBank localBank;
        OtherBank otherBank;
        M_Transfer mTransfer = new M_Transfer();
        System.out.println("Choose : \n1. m-Banking\n2. New Bank Account");
        int choice = 0;
        if (choice == 1){
            System.out.println("Enter Access Code : ");

            System.out.println("1. m-Info\n2. m-Transfer");

            System.out.println("1. Register New account\n2. Transfer");

            //if chose 1
            System.out.println("1. among our bank\n2. among banks");

            // if chose 1, call method add account
            System.out.println("Enter account number :");
            System.out.println("Enter customer name : ");
            localBank = new LocalBank(1, "");
            mTransfer.addAccount(localBank);

            // if chose 2, call method add account from other bank
            System.out.println("Enter Bank Name : ");
            System.out.println("Enter account number :");
            System.out.println("Enter customer name : ");
            otherBank = new OtherBank(1, "", "");
            mTransfer.addAccount(otherBank);
        }
    }
}
