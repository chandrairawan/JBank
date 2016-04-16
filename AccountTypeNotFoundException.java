import java.lang.Exception;

/**
 * Class AccountTypeNotFoundException.
 * 
 * @author Abdul Chandra Irawan
 * @version 14.04.2016
 */
public class AccountTypeNotFoundException extends Exception
{
    public char acctType;
    public String message;

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
        switch (acctType)
        {
            case 'S':
            {
                message = " Savings ";
                return message+super.getMessage();
            }
            case 'I':
            {
                message = " Investment ";
                return message+super.getMessage();
            }
            case 'L':
            {
                message = " LineOfCredit ";
                return message+super.getMessage();
            }
            case 'O':
            {
                message = " OverDraftProtection ";
                return message+super.getMessage();
            }
            default :
            {
                message = "Wrong Type Of Account !";
                return message;
            }
        }
    }
}
