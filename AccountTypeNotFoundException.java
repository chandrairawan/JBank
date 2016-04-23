import java.lang.Exception;

/**
 * Class AccountTypeNotFoundException.
 * 
 * @author Abdul Chandra Irawan
 * @version 16.04.2016
 */
public class AccountTypeNotFoundException extends Exception
{
    public char acctType;
    //public String message;

    /**
     * Constructor for objects of class AccountTypeNotFoundException
     */
    public AccountTypeNotFoundException(char acct)
    {
        super("Account type does not exist");
        acctType = acct;
    }

    /**
     */
    public String getMessage()
    {
        String message = "";
        
        switch(acctType){
            case 'S': message = "Savings "+super.getMessage();
            break;
            case 'I': message = "Investment "+super.getMessage();
            break;
            case 'O': message = "OverDraftProtect "+super.getMessage();
            break;
            case 'L': message = "LineOfCredit"+super.getMessage();
            break;
        }

        return message;
    }
}
