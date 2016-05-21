
/**
 * Class Savings untuk membentuk isi dari Account Saving.
 * 
 * @author Abdul Chandra Irawan - 1306405244 
 * @version 21.04.2016
 */
public class Savings extends Account 
{
    protected double interestEarned;

    /**
     * Constructor for objects of class Savings
     * @param cust & amount
     */
    public Savings(Customer cust, double amount)
    {
        super();
        
        if(amount >= 10) {
            ID = String.valueOf(cust.getCustID()) + "S";
            balance = amount;
        }
    }

    /**
     * Method getInterestEarned, merupakan accessor untuk mendapatkan interest yang didapatkan
     * @return interestEarned
     */
    public double getInterestEarned()
    {
        return interestEarned;
    }
    
    /**
     * Metode withdraw untuk pengambilan uang
     * @param amount - yang diambil
     * @throws AmountOverDrawnException jika melebihi jumlah uang dalam akun
     */
    public void withdraw(double amount)throws AmountOverDrawnException
    {
        if(balance - amount >= 10) {
            balance-=amount;
        } else {
            throw new AmountOverDrawnException(this);
        }
    }

    /**
     * Metode addDailyInterest untuk menghitung interest
     * @param days
     */
    public void addDailyInterest(int days)
    {
        double A;
        A = Math.pow(((1 + (.03/360))), (1*days));
        interestEarned = (A*balance) - balance;
        balance = balance*A;
    }
}
