
package hostel.application;

/** Class used to record the details of a tenant 
 * @author Abdul-Razak Hussein 
 * @version 2nd July 2021 
 */ 

public class Tenant 
{
    private String name;
    private int room;
    private PaymentList payments;
    public static final int MAX = 12;
    
    public  Tenant(String nameIn, int roomIn)
    {
        name = nameIn;
        room = roomIn;
        payments = new PaymentList(MAX);
    }
    
    /** Records a payment for the tenant 
 * @param paymentIn: payment made by tenant 
 */
 
    public void makePayment(Payment paymentIn)
    {
        payments.addPayment(paymentIn);   // call paymentList method
    }
    
    /** Reads the name of the tenant 
 * @return Returns the name of the tenant 
 */ 
    public String getName()
    {
        return name;
    }
    
    /** Reads the room number of the tenant 
     * @return Returns the room number of the tenant
     */
   public int getRoom()
   {
       return room;
   }
   
   /** Reads the payments made by the tenant 
    * @return Returns the payments made by the tenant
    */
   public PaymentList getPayment()
   {
       return payments;
   }
   @Override
   
   public String toString()
   {
       return name+" , "+room+" , "+payments; 
   }
    
     
     
  
}
