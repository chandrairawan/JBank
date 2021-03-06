import java.util.*;

/**
 * Class Investment yang memodelkan Account Investment.
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 21.04.2016
 */
public final class Investment extends Savings
{
    private Date startDate;
    private Date endDate;
    private double interestRate;
    private int term;
    
    /**
     * Constructor for objects of class Investment
	 * @param cust, amount & months 
     */
    public Investment(Customer cust, double amount, int months)
    {
        super(cust, amount);
        ID = String.valueOf(cust.getCustID()) + "I";
        
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
	 * Method addDailyInterest untuk menghitung interest yang didapatkan
     * @param days Waktu penyimpanan uang dalam hari
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
	 * Metode untuk melakukan pengambilan uang
     * @param amount Jumlah uang yang akan diambil
     * @throws AmountOverDrawnException Apabila jumlah uang yang akan diambil melebihi jumlah uang dalam akun
     */
    @Override
    public void withdraw(double amount) throws AmountOverDrawnException
    {
        if(amount > balance) {
            throw new AmountOverDrawnException(this);
        }
        else if(Calendar.getInstance().getTime().before(endDate)) {
            if(amount > (balance * 0.8)) {
                throw new AmountOverDrawnException(this);
            }
            else {
                balance = (balance * 0.8) - amount;
            }
        }
        else {
            balance = balance - amount;
        }
    }
}
