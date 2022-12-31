package  bankaccountinformation;;
import java.util.*;


public class SavingsAccount extends Account {
    
    long creditCard;
    public Calendar expirydate;
    Random rng =new Random();
    
    SavingsAccount(){
        
    }
    public long getCreditCardNumber(){
        return creditCard;
    }
    SavingsAccount(int id,double balance,double interestRate){
        
        super(id,balance,interestRate);
        creditCard=rng.nextLong()%10000000000000000L;
        expirydate = Calendar.getInstance();
        expirydate.add(Calendar.YEAR,5);
    }
    public double getCreditBalance(){
        return getbalance()*3;
    }
    
}
