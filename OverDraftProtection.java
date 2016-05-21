
/**
 * Class OverDraftProtection sebagai memodelkan Account OverDraftProtection.
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 21.04.2016
 */
public class OverDraftProtection extends Checking 
{
    private Savings savingsAccount;

    /**
     * Constructor for objects of class OverDraftProtection
     * 
     * @param cust.getCustId(), amount & save
     */
    public OverDraftProtection(Customer cust, double amount, Savings savingsAccount)
    {
        super();
        
        balance = amount;
        this.savingsAccount = savingsAccount;
        ID = String.valueOf(cust.getCustID()) + "O";
    }
    
    /**
     * method feeAssessment untuk menghitung monthly fee
     */
    public void feeAssessment () 
    {
        monthlyFee += 3;
        balance -= monthlyFee;
    }
    
    /**
     * Method Withdraw untuk melakukan pengambilan uang
     * 
     * @param amount Jumlah uang yang akan diambil
     * @throws AmountOverDrawnException Apabila jumlah uang yang akan diambil melebihi jumlah uang dalam akun
     */
    @Override
    public void withdraw(double amount) throws AmountOverDrawnException
    {
        if(amount > balance + savingsAccount.getBalance() - 10) {
            throw new AmountOverDrawnException(this);
        }
        else if(amount > balance) {
            savingsAccount.withdraw(amount - balance);
            balance = 0;
            feeAssessment();
        }
        else {
            balance = balance - amount;
        }
    }
}
