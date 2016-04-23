
/**
 * Class OverDraftProtection.
 * 
 * @author Abdul Chandra Irawan 
 * @version 16.04.2016
 */
public class OverDraftProtection extends Checking 
{
    private Savings savingsAccount;

    /**
     * Constructor OverDraftProtection
     * 
     * @param cust.getCustId()
     * @param amount
     * @param save
     */
    public OverDraftProtection(Customer cust, double amount, Savings save) 
    {
        super();
        id = Integer.toString(cust.getCustId());
        balance = amount;
        savingsAccount = save;
    }
    
    /**
     * method feeAssessment
     */
    public void feeAssessment () 
    {
        monthlyFee += 3;
        balance -= 3;
    }
    
    /**
     * Method Withdraw
     * 
     * @param amount
     */
    public boolean withdraw (double amount) 
    {
        if ( ( balance + savingsAccount.getBalance() ) - amount >= 10) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                savingsAccount.withdraw(amount - balance);
                balance = 0;
                feeAssessment();
            }
            return true;
        } else {
            return false;
        }
    }
}
