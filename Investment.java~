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
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
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
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public boolean withdraw(int amount)
    {
        boolean check = false;
        if(amount > balance) {
            check = false;
        }
        else if(Calendar.getInstance().before(endDate)) {
            check = false;
        }
        else if(amount > balance - (balance * (20/100))) {
            check = false;
        }
        else {
            balance = balance - (balance * (20/100)) - amount;
            check = true;
        }
        return check;
    }

}
