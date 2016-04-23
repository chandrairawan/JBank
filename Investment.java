import java.util.*;

/**
 * Write a description of class Investment here.
 * 
 * @author Abdul Chandra Irawan 
 * @version 16.04.2016
 */
public class Investment extends Savings
{
    private Date startDate;
    private Date endDate;
    private double interestRate;
    private int term;
    
    /**
     * Constructor for objects of class Investment
     */
    public Investment(Customer cust, double amount, int months)
    {
        super(cust, amount);
        
        if(months >= 6) {
            term = months;
        }
        else {
            term = 6;
        }
        
        Calendar s = new GregorianCalendar();
        
        startDate = s.getTime();
        s.add(Calendar.MONTH, term);
        endDate = s.getTime();
        
        if(term > 0 || term <= 6) {
            interestRate = .05;
        }
        else if(term > 6 || term <= 12) {
            interestRate = .06;
        }
        else if(term > 12) {
            interestRate = .07;
        }
    }

    /**
     */
    @Override
    public void addDailyInterest(int days)
    {
        double f;
        f = Math.pow(((1 + (interestRate/365))), (1 * days));
        interestEarned = (balance * f) - balance;
        balance = balance * f;
    }
    
    /**
     */
    public boolean withdraw(int amount) throws AmountOverDrawnException
    {
        if (balance - amount >= 100) {
            if (Calendar.getInstance().before(endDate)) {
                if ( (balance * 0.8) - amount >= 100 ) {
                    balance *= 0.8;
                    balance -= amount;
                    return true;
                } else {
                    throw new AmountOverDrawnException(this);
                }
                
            } else {
                throw new AmountOverDrawnException(this);
            }
        } else {
            throw new AmountOverDrawnException(this);
        }
    }

}
