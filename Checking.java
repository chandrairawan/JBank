
/**
 * Write a description of class Checking here.
 * 
 * @author Abdul Chandra Irawan 
 * @version 27.03.2016
 */
public abstract class Checking extends Account 
{
    protected double monthlyFee;
    protected abstract void feeAssessment();
    
    public void resetMonthlyFee() 
    {
        monthlyFee = 0;
    }
    
    public double getMonthlyFee() 
    {
        return monthlyFee;
    }
}
