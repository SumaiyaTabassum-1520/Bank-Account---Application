//Driver Class
package bankaccountinformation;
import java.util.*;

public class BankAccountInformation {

    ArrayList<Account> accountlist = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    void Account() {
        Account Acc = new Account(1122, 20000, 4.5);
        Acc.Withdraw(2500);
        Acc.deposit(3000);
        System.out.println("Account Id is : " + Acc.getid());
        System.out.println("Total balance : " + Acc.getbalance());
        System.out.println("Annual interest rate :" + Acc.getannualInterestRate());
        System.out.println(Acc.display());
    }

    void CheckingAccount() {
        Account Acc = new CheckingAccount(1122, 20000, 4.5, 5000);
        System.out.println("Account Id is : " + Acc.getid());
        System.out.println("Total balance : " + Acc.getbalance());
        System.out.println("Annual interest rate :" + Acc.getannualInterestRate());
        System.out.println("Enter the amount for withdraw");
        double amount = input.nextDouble();
        double value = Acc.Withdraw(amount);
        if (value == -1) {
            System.out.println("This amount can not withdraw");
        } else {
            System.out.println("After withdraw the balance is" + value);
        }
        Acc.DipositeAmmount();
        System.out.println(Acc.display());
        Acc = new SavingsAccount(1234, 30000, 4.5);
        System.out.println("Account Id is : " + Acc.getid());
        System.out.println("Credit balance : " + ((SavingsAccount) Acc).getCreditBalance());
        System.out.println("Annual interest rate :" + Acc.getannualInterestRate());
        Acc.DipositeAmmount();
        System.out.println("Enter the amount for withdraw");
        amount = input.nextDouble();
        value = Acc.Withdraw(amount);
        if (value == -1) {
            System.out.println("This amount can not withdraw");
        } else {
            System.out.println("After withdraw the balance is" + value);
        }

        System.out.println("credit card balance" + ((SavingsAccount) Acc).getCreditBalance()); //etao Downcasting 
        System.out.println("Account expire date " + ((SavingsAccount) Acc).expirydate.getTime());
    }
    int breakLoop = 0;

    void SavingsAccount() {

        while (printmenu() == 1) {
            int options = input.nextInt();
            switch (options) {
                case 1:

                    System.out.println("enter the account id");
                    int Id = input.nextInt();
                    System.out.println("Enter the amount of money");
                    double money = input.nextDouble();
                    System.out.println("Enter the Annual interest rate");
                    double rate = input.nextDouble();
                    System.out.println("Enter the overdraft limit");
                    double overdraft = input.nextDouble();
                    accountlist.add(new CheckingAccount(Id, money, rate, overdraft));

                    break;
                case 2:

                    System.out.println("enter the account id");
                    Id = input.nextInt();
                    System.out.println("Enter the amount of money");
                    money = input.nextDouble();
                    System.out.println("Enter the Annual interest rate");
                    rate = input.nextDouble();

                    accountlist.add(new SavingsAccount(Id, money, rate));
                    break;
                case 3:
                    breakLoop = 1;
                    break;
                default:
                    System.out.println("wrong option");
                    break;
            }
            if (breakLoop == 1) {
                break;

            }
        }
        for (int i = 0; i < accountlist.size(); i++) {

            System.out.println("Balance" + accountlist.get(i).getbalance());
            accountlist.get(i).DipositeAmmount();
            System.out.println("Enter the amount for withdraw");
            double amount = input.nextDouble();
            double value = accountlist.get(i).Withdraw(amount);
            if (value == -1) {
                System.out.println("This amount can not withdraw");
            } else {
                System.out.println("After withdraw the balance is" + value);
            }
            if (accountlist.get(i) instanceof SavingsAccount savingsAccount) {
                SavingsAccount Sa = savingsAccount;

                System.out.println("This is a savings account");
                System.out.println("Account Id : " + Sa.getid());
                System.out.println("Date Created" + Sa.getdateCreated().getTime());
                System.out.println("Current balance" + Sa.getbalance());
                System.out.println("Annual interest rate :" + Sa.getannualInterestRate());
                System.out.println("Monthly interest amount :" + Sa.getMonthlyInterestAmount());
                System.out.println("Credit card number :" + Sa.getCreditCardNumber());
                System.out.println("Expirydate :" + Sa.expirydate.getTime());
                System.out.println("Credit balance : " + Sa.getCreditBalance());

            } else {
                CheckingAccount Ca = ((CheckingAccount) accountlist.get(i));
                System.out.println("This is a checking account");
                System.out.println("Account Id : " + Ca.getid());
                System.out.println("Date Created" + Ca.getdateCreated().getTime());
                System.out.println("Current balance : " + Ca.getbalance());
                System.out.println("Annual interest rate :" + Ca.getannualInterestRate());
                System.out.println("Monthly interest amount :" + Ca.getMonthlyInterestAmount());
                System.out.println("Overdraft limit :" + Ca.getOverDraft());
            }
        }
    }

    public void run() {

        Account();
        CheckingAccount();
        SavingsAccount();

    }

    public int printmenu() {
        System.out.println("Press (1) for creating a Checking Account");
        System.out.println("Press (2) for creating a Savings Account");
        return 1;
    }

    public static void main(String[] args) {
        BankAccountInformation bank = new BankAccountInformation();
        bank.run();

    }

}
