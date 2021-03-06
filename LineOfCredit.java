import java.util.*;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Class LineOfCredit untuk memodelkan Account Line of Credit
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 21.04.2016
 */
public class LineOfCredit extends Checking 
{
    private double creditBalance;
    private double creditLimit;
    
	/**
     * Constructor LineOfCredit
     * 
     * @param cust.getCustId(), amount, & creditAmount
     */
    public LineOfCredit(Customer cust, double amount, double creditAmount)
    {
        super();
        
        ID = String.valueOf(cust.getCustID()) + "L";
        balance = amount;
        creditLimit = creditAmount;
    }
    
    /**
     * method feeAssessment untuk menghitung montly fee
     */
    public void feeAssessment() 
    {
        int days = new GregorianCalendar ().get(Calendar.DAY_OF_MONTH);
        double deficit = creditLimit - creditBalance;
        double financeCharge = deficit*(Math.pow(((1 + (.21/365))), (1 * days)));
        monthlyFee = financeCharge - deficit;
    }
    
	/**
     * Method accessor untuk mendapatkan balance credit
     * @return Balance credit
     */
    public double getCreditBalance()
    {
        return creditBalance;
    }
	
    /**
     * Method withdraw untuk melakukan pengambilan uang
     * 
     * @param amount yang akan diambil
     * @throws AmountOverDrawnException Apabila melebihi jumlah uang dalam akun
     */
    @Override
    public void withdraw(double amount) throws AmountOverDrawnException
    {
        if(amount > balance + creditLimit) {
            throw new AmountOverDrawnException(this);
        }
        else if(amount > balance) {
            creditBalance -= (amount - balance);
            balance = 0;
        } else{
            balance -= amount;
        }
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
     * @param amounts
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
