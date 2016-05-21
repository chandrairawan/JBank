import java.lang.Exception;

/**
 * Class AccountTypeNotFoundException.
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 21.04.2016
 */
public class AccountTypeNotFoundException extends Exception
{
    public char acctType;
    
    /**
     * Constructor for objects of class AccountTypeNotFoundException
     * @param type
	 */
    public AccountTypeNotFoundException(char type)
    {
        super("Account type does not exist");
        this.acctType = type;
    }

    /**
     */
    public String getMessage()
    {
        String message = "";
        
        switch(acctType){
            case 'S': message = "Savings " + super.getMessage();
				break;
            case 'I': message = "Investment " + super.getMessage();
				break;
            case 'O': message = "OverDraftProtect " + super.getMessage();
				break;
            case 'L': message = "LineOfCredit" + super.getMessage();
				break;
        }
        return message;
    }
}
