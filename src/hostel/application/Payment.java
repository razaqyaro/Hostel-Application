
package hostel.application;

/** Class used to store details of a single payment in a hostel 
 * @author Abdul-Razak Hussein 
 * @version 23rd June 2021 
 */ 

public class Payment 
{
    private String month;
    private double amount;
    
    /** Constructor initialises the payment month and the amount paid 
 * @param monthIn: month of payment 
 * @param amountIn: amount of payment 
 */ 
    public Payment(String monthIn, double amountIn)
    {
        month = monthIn;
        amount = amountIn;
    }
    /** Reads the month for which payment was made 
 * @return Returns the month for which payment was made 
 */ 
    public String getMonth()
    {
        return month;
    }
    /** Reads the amount paid 
 * @return Returns the amount paid 
 */ 
    public double getAmount()
    {
        return amount;
    }
    
    @Override
    public String toString()
    {
        return "(" + month + ": "+ amount +  ")";
    }
}
