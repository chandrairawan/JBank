
/**
 * Class Checking.
 * 
 * @author Abdul Chandra Irawan 
 * @version 16.04.2016
 */
public abstract class Checking extends Account 
{
    protected double monthlyFee;
    
    /**
     * Method abstract feeAssessment
     */
    protected abstract void feeAssessment();
    
    /**
     * Method resetMonthlyFee
     * 
     * @param monthlyFee = 0
     */
    public void resetMonthlyFee() 
    {
        monthlyFee = 0;
    }
    
    /**
     * Method getMonthlyFee
     * 
     * @return monthlyFee
     */
    public double getMonthlyFee() 
    {
        return monthlyFee;
    }
}
