
/**
 * Write a description of class Savings here.
 * 
 * @author Abdul Chandra Irawan 
 * @version 27.03.2016
 */
public class Savings extends Account 
{
    protected double interestEarned;

    /**
     * Constructor for objects of class Savings
     */
    public Savings(Customer cust, double amount)
    {
        super();
        
        id = Integer.toString(cust.getCustId());
        super.balance = amount;
    }

    /**
     * 
     */
    public double getInterestEarned()
    {
        return interestEarned;
    }
    
    /**
     * 
     */
    public boolean withdraw(double amount)
    {
        if(balance - amount >= 10) {
            balance = balance - amount;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     */
    public void addDailyInterest(int days)
    {
        double A, period;
        period = (double)days / 365;
        A = futureValue(balance, 0.03, 360, period);
        interestEarned = A - balance;
        balance = A;
    }
}