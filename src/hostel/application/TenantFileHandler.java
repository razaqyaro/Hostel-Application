
 
package hostel.application;

import java.io.*;

/**
 *
 * @author Abdul-Razak Hussein
 */
public class TenantFileHandler 
{
    
    public static void saveRecords(int noOfRoomsIn, TenantList listIn)
    {

            try
            {
                FileOutputStream tenantFile = new FileOutputStream("Tenants.dat");
                DataOutputStream tenantWriter = new DataOutputStream(tenantFile);
                tenantWriter.writeInt(listIn.getTotal());
                for(int i=1; i <= noOfRoomsIn; i++)
                {
                       if(listIn.getTenant(i) != null)
                       {
                          tenantWriter.writeInt(listIn.getTenant(i).getRoom());
                          tenantWriter.writeUTF(listIn.getTenant(i).getName());
                          tenantWriter.writeInt(listIn.getTenant(i).getPayment().getTotal());
                          for(int j = 1; j<= listIn.getTenant(i).getPayment().getTotal(); j++)
                          {
                              tenantWriter.writeUTF(listIn.getTenant(i).getPayment().getPayment(j).getMonth());
                              tenantWriter.writeDouble(listIn.getTenant(i).getPayment().getPayment(j).getAmount());
                           }
                       }
                }
                tenantWriter.flush();
                tenantWriter.close();
            }
            catch(IOException ioe)
            {
                System.out.println("Error writing file");
            }

    }

    public static void readRecords(TenantList listIn)
    {

        try
        {
               FileInputStream tenantFile = new FileInputStream("Tenants.dat");
               DataInputStream tenantReader = new DataInputStream(tenantFile);

               int tempRoom = 0;
               String tempName = new String("");
               String tempMonth = new String("");
               double tempAmount = 0 ;
               Tenant tempTenant = null;
               Payment tempPayment =  null;
               int tot = 0;
               int totpay = 0;

               tot = tenantReader.readInt();
               for(int j = 1; j<=tot; j++)
               {
                      tempRoom = tenantReader.readInt();
                      tempName = tenantReader.readUTF();
                      tempTenant = new Tenant(tempName,tempRoom);
                      totpay = tenantReader.readInt();
                      for(int k = 1; k <= totpay; k++)
                      {
                          tempMonth = tenantReader.readUTF();;
                          tempAmount = tenantReader.readDouble();
                          tempPayment = new Payment(tempMonth, tempAmount);
                          tempTenant.makePayment(tempPayment);
                      }
                      listIn.addTenant(tempTenant);

                  }
                  tenantReader.close();
         }

         catch(IOException ioe)
         {
            System.out.println("No records found");
         }

    }
}


