
package hostel.application;
/** Collection class to hold a list of tenants 
 * @author Abdul-Razak Hussein 
 * @version 3rd July 2021 
 */
import java.util.ArrayList;

public class TenantList
{
    private ArrayList<Tenant>tList;
    public final int MAX;
    
    public TenantList(int maxIn)
    {
        tList = new ArrayList<>();
        MAX = maxIn;
    }
    /** Adds a new Tenant to the list 
 * @param tIn The Tenant to add 
 * @return Returns true if the tenant was added successfully and false otherwise 
 */
    public boolean addTenant(Tenant tIn)
    {
        if(!isFull())
        {
            tList.add(tIn);
            return true;
        }
        else
        {
            return false;
        }
    }
    /**Remove the tenant in the given room number
     * @param roomIn The room number of the tenant to be removed
     *@return Returns true if the tenant is removed and false otherwise
     */
    public boolean removeTenant(int roomIn)
    {
        Tenant findT = search(roomIn);  // call the search method
        if(findT != null)          // check tenant is found at given room number
        {
            tList.remove(findT);  // remove given tenant
            return true;
        }
        else
        {
            return false;
        }
    }
    /**Searches for tenant with the given room number
     * @param  roomIn The room number to search for
     * @return Returns the tenant in the given room or null if no tenant in the given room
     */
    public Tenant search(int roomIn)
    {
        for(Tenant currentTenant: tList)
        {
            // find tenant with given room number 
            if(currentTenant.getRoom()== roomIn)
            {
                return currentTenant;
            }
        }
        return null;    // no tenant found with given room number 
    }
    /**Reads the tenant at a given position in the list
     * @param positionIn The logical position of the tenant in the list
     * @return Returns the tenant at the given logical position
     */
    public Tenant getTenant(int positionIn)
    {
        if(positionIn < 1 || positionIn > getTotal())   // check for valid logical position
        {
            return null;  // No object found at the given position
        }
        else
        {
            return tList.get(positionIn - 1);
        }
    }
    /**
     * Reports whether or not the list is empty or not
     * @return Returns true if the list is empty and false otherwise
     */
    public boolean isEmpty() 
        { 
          return tList.isEmpty();
        } 
    /**Reports on whether or not the list is full
     * @return Returns true if the list full and false otherwise
     */
    public boolean isFull()
    {
        return tList.size()== MAX;
    }
    /**Gets the total number of tenants
     * @return Returns the total number of tenants currently in the list
     */
    public int getTotal()
    {
        return tList.size();
    }
    
    @Override
    
    public String toString()
    {
        return tList.toString();
    }
}
