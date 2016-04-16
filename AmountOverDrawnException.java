import java.lang.Exception;

/**
 * Class AmountOverDrawnException.
 * 
 * @author Abdul Chandra Irawan 
 * @version 16.04.2016
 */
public class AmountOverDrawnException extends Exception
{
    public Account acctType;
    
    /**
     * Constructor for objects of class AmountOverDrawnException
     */
    public AmountOverDrawnException(Account acct)
    {
        super("Insufficient funds");
        this.acctType = acct;
    }
    
    public String getMessage()
    {
        String message = "Account Type Not Found !";
        
        if(acctType instanceof Savings && !(acctType instanceof Investment)) {
            message = super.getMessage() + " in Savings Account";
        }
        else if(acctType instanceof Investment) {
            message = super.getMessage() + " in Investment Account";
        }
        else if(acctType instanceof LineOfCredit) {
            message = super.getMessage() + " in Line-Of-Credit Account";
        }
        else if(acctType instanceof OverDraftProtection) {
            message = super.getMessage() + " in Overdraft Protection Account";
        }
        
        return message;
    }
}
