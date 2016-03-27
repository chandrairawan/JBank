
/**
 * Write a description of class OverDraftProtect here.
 * 
 * @author Abdul Chandra Irawan 
 * @version 27.03.2016
 */
public class OverDraftProtect extends Checking 
{
    private Savings savingsAccount;

    public OverDraftProtect(Customer cust, double amount, Savings save) 
    {
        super();
        id = Integer.toString(cust.getCustId());
        balance = amount;
        savingsAccount = save;
    }
    
    public void feeAssessment () 
    {
        monthlyFee += 3;
        balance -= 3;
    }
    
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
