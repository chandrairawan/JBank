
/**
 * Class Checking, merupakan class abstract yang memodelkan Account Checking
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 21.04.2016
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
     * @param monthlyFee = 0
     */
    public void resetMonthlyFee() 
    {
        monthlyFee = 0;
    }
    
    /**
     * Method getMonthlyFee
     * @return monthlyFee
     */
    public double getMonthlyFee() 
    {
        return monthlyFee;
    }
}
