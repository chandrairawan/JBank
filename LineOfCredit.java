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
 * @version 16.04.2016
 */
public class LineOfCredit extends Checking 
{
    private double creditBalance, creditLimit;
    
    /**
     * Constructor LineOfCredit
     * 
     * @param cust.getCustId()
     * @param amount
     * @param creditAmount
     */
    public LineOfCredit (Customer cust, double amount, double creditAmount) 
    {
        super();
        id = Integer.toString(cust.getCustId());
        balance = amount;
        creditBalance = creditAmount;
        creditLimit = creditAmount;
    }
    
    /**
     * method feeAssessment
     */
    public void feeAssessment() 
    {
        int days = new GregorianCalendar ().get(Calendar.DAY_OF_MONTH);
        double deficit = creditLimit - creditBalance, period = (double) days/365; 
        double financeCharge = futureValue(deficit,0.21,360,period);
        monthlyFee = new BigDecimal(financeCharge).subtract(new BigDecimal(deficit), mc.DECIMAL32).doubleValue();
    }
    
    /**
     * Method withdraw
     * 
     * @param amount
     */
    public boolean withdraw (double amount) throws AmountOverDrawnException
    {
        if(amount > balance + creditBalance){
            throw new AmountOverDrawnException(this);
        } else if(amount > balance){
            balance = 0;
            creditBalance -= (amount - balance);
            feeAssessment();
            return true;
        } else{
            balance -= amount;
            return true;
        }
    }
    
    /**
     * Method getCreditBalance
     * 
     * @return creditBalance
     */
    public double getCreditBalance() 
    {
        return creditBalance;
    }
    
    /**
     * Method getCreditLimit
     * 
     * @return creditLimit
     */
    public double getCreditLimit() 
    {
        return creditLimit;
    }
    
    /**
     * Method setCreditBalance
     * 
     * @param amount
     */
    public void setCreditBalance(double amount) 
    {
        creditBalance = amount;
    }
    
    /**
     * Method setCreditLimit
     * 
     * @param amount
     */
    public void setCreditLimit (double amount) 
    {
        creditLimit = amount;
    }
}
