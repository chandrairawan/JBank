import java.lang.Exception;

/**
 * Write a description of class AccountTypeAlreadyExistException here.
 * 
 * @author Abdul Chandra Irawan
 * @version 14.04.2016
 */
public class AccountTypeAlreadyExistException extends Exception
{
    public char acctType;
    private Account accountType;
    
    /**
     * Constructor for objects of class AccountTypeAlreadyExistException
     */
    public AccountTypeAlreadyExistException(char acctType)
    {
        super("Unable to create duplicate account of type");
        this.acctType = acctType;
    }
    
    public String getMessage()
    {
        String message = "Account Type Not Found !";
        
        if (accountType instanceof Savings && !(accountType instanceof Investment) ){
            return super.getMessage() + "Savings";
        } else if (accountType instanceof Investment){
            return super.getMessage() + "Investments";
        } else if (accountType instanceof OverDraftProtection){
            return super.getMessage() + "OverDraft Protection";
        } else if (accountType instanceof LineOfCredit){
            return super.getMessage() + "Line of Credit";
        } else {
            return message;
        }
    }
}
