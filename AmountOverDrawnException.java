import java.lang.Exception;

/**
 * Class AmountOverDrawnException handling exception saat withdraw lebih besar dari saldo.
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 21.04.2016
 */
public class AmountOverDrawnException extends Exception
{
    public Account account;
    
    /**
     * Constructor for objects of class AmountOverDrawnException
     * @param acct
	 */
    public AmountOverDrawnException(Account acct)
    {
        super("Insufficient funds");
        this.account = acct;
    }
    
	/**
     * Method getMessage untuk meyampaikan pesan error
     * @return message
     */
    public String getMessage()
    {
        String message = "Account Type Not Found !";
        
        if(account instanceof Savings && !(account instanceof Investment)) {
            message = super.getMessage() + " in Savings Account";
        }
        else if(account instanceof Investment) {
            message = super.getMessage() + " in Investment Account";
        }
        else if(account instanceof LineOfCredit) {
            message = super.getMessage() + " in Line-Of-Credit Account";
        }
        else if(account instanceof OverDraftProtection) {
            message = super.getMessage() + " in Overdraft Protection Account";
        }
        
        return message;
    }
}
