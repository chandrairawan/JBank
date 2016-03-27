import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Write a description of class LineOfCredit here.
 * 
 * @author Abdul Chandra Irawan 
 * @version 27.03.2016
 */
public class LineOfCredit extends Checking 
{
    private double creditBalance, creditLimit;
    
    public LineOfCredit (Customer cust, double amount, double creditAmount) 
    {
        super();
        id = Integer.toString(cust.getCustId());
        balance = amount;
        creditBalance = creditAmount;
        creditLimit = creditAmount;
    }
    
    public void feeAssessment() 
    {
        int days = new GregorianCalendar ().get(Calendar.DAY_OF_MONTH);
        double deficit = creditLimit - creditBalance, period = (double) days/365; 
        double financeCharge = futureValue(deficit,0.21,360,period);
        monthlyFee = new BigDecimal(financeCharge).subtract(new BigDecimal(deficit), mc.DECIMAL32).doubleValue();
    }
    
    public boolean withdraw (double amount) 
    {
        if ( ( balance + creditBalance >= amount)) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                creditBalance -= (amount - balance);
                balance = 0;
                feeAssessment();
            }
            return true;
        } else {
            return false;
        }
    }
    
    public double getCreditBalance () 
    {
        return creditBalance;
    }
    
    public double getCreditLimit () 
    {
        return creditLimit;
    }
    
    public void setCreditBalance (double amount) 
    {
        creditBalance = amount;
    }
    
    public void setCreditLimit (double amount) 
    {
        creditLimit = amount;
    }
}