import java.lang.Exception;

/**
 * Class AccountTypeAlreadyExistException.
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 21.04.2016
 */
public class AccountTypeAlreadyExistsException extends Exception
{
    private Account acct;
    
    /**
     * Constructor for objects of class AccountTypeAlreadyExistException
	 * @param acct
     */
    public AccountTypeAlreadyExistsException(Account acct)
    {
        super("Unable to create duplicate account of type");
        this.acct = acct;
    }
    
	/**
     * Method to get error message
     * @return Error message
     */
    public String getMessage()
    {
        String message = "";
        
        if (acct instanceof Savings && !(acct instanceof Investment) ){
            message = super.getMessage() + "Savings";
        } else if (acct instanceof Investment){
            message = super.getMessage() + "Investments";
        } else if (acct instanceof OverDraftProtection){
            message = super.getMessage() + "OverDraft Protection";
        } else if (acct instanceof LineOfCredit){
            message = super.getMessage() + "Line of Credit";
        }
        return message;
    }
}
