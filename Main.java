public class Main {
    public static void main(String[] args) {

        MyAccount myAccount = new MyAccount();
        LocalBank localBank1 = new LocalBank(123, "Muhammad", 5000000);
        LocalBank localBank2 = new LocalBank(124, "Ahmad", 1000000);


        M_Transfer mTransfer1 = new M_Transfer();
        mTransfer1.addAccount(localBank1);
        mTransfer1.addAccount(localBank2);
        mTransfer1.transfer(myAccount, localBank1);
        System.out.println(myAccount.getBalance());
//        if (1 == 1){
//            System.out.println("Enter Access Code : ");
//
//            System.out.println("1. m-Info\n2. m-Transfer");
//
//            System.out.println("1. Register New account\n2. Transfer");
//
//            //if chose 1
//            System.out.println("1. among our bank\n2. among banks");
//
//            // if chose 1, call method add account
//            System.out.println("Enter account number :");
//            System.out.println("Enter customer name : ");
//            localBank = new LocalBank(1, "", 1000);
//            mTransfer.addAccount(localBank);
//
//            // if chose 2, call method add account from other bank
//            System.out.println("Enter Bank Name : ");
//            System.out.println("Enter account number :");
//            System.out.println("Enter customer name : ");
//            otherBank = new OtherBank(1, "", "", 1000);
//            mTransfer.addAccount(otherBank);
//
//            //if user chose transfer there are few options : among our bank, other bank, virtual account dan inbox
//            //call among our bank
//        }
    }
}
