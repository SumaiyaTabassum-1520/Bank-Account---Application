package bankaccountinformation;

public class CheckingAccount extends Account {
    
    double overDraft;
    public CheckingAccount(){
        
    }
    public CheckingAccount(int id,double balance,double annualInterestRate,double D ) {

       super(id,balance,annualInterestRate);
       this.overDraft=D;
       
    }
    public double getOverDraft(){
        return overDraft;
    }

    @Override
    public double Withdraw(double amount) {

        double value = -1;
        if (amount < overDraft ) {
            value = super.Withdraw(amount);

        }
        return value;
    }

}
