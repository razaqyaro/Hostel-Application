
package hostel.application;

/**
 *
 * @author Abdul-Razak Hussein
 */
import java.util.Scanner;
public class PaymentListTester 
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner (System.in);
        char choice;
        int size;
        PaymentList list;  // declare PaymentList object to test
        
        //Get size of the List
        System.out.println("Size of List..?");
        size = keyboard.nextInt();
        
        list = new PaymentList(size); //Create object to test list
        
        do
        {
           //Display options
            System.out.println();
            System.out.println("[1] ADD");
            System.out.println("[2] DISPLAY");
            System.out.println("[3] IS FULL");
            System.out.println("[4] GET PAYMENT");
            System.out.println("[5] GET TOTAL");
            System.out.println("[6] CALCULATE TOTAL");
            System.out.println("[7] QUIT");
            System.out.println();
            System.out.println("Enter choice [1 - 7]");
            choice = keyboard.next().charAt(0);
            //Get choice
            switch(choice)
            {
                case '1': option1(list);
                    break;
                case '2':option2(list);
                    break;
                case '3': option3(list);
                    break;
                case '4':option4(list);
                    break;
                case '5':option5(list);
                    break;
                case '6':option6(list);
                    break;
                case '7': System.out.println("TESTING COMPLETE");
                    break;
            }
        }while(choice != '7');
        
    }
    //ADD
    static void option1(PaymentList listIn)
    {
        //prompt for payment details
        
        System.out.println("Enter month: ");
        Scanner keyboard = new Scanner (System.in);
        String month = keyboard.nextLine();
        System.out.println("Enter amount: ");
        double amount = keyboard.nextDouble();
        
        //Create new object from input
        Payment p = new Payment(month, amount);
        //Attempt to add payment to a list
        
        boolean ok = listIn.addPayment(p);
        if(!ok)
        {
            System.out.println("ERROR !!! List is full");
        }
    }
    
    //DISPlAY
    static void option2(PaymentList listIn)
    {
        System.out.println("ITEMS ENTERED");
        System.out.println(listIn);  // calls the toString method of the PaymentList class
    }
    
    //IS FULL
    static void option3(PaymentList listIn)
    {
        if(listIn.isFull())
        {
            System.out.println("List is full");
        }
        else
        {
            System.out.println("List is not full");
        }
    }
    
    //GET PAYMENT
    static void option4(PaymentList listIn)
    {
        //prompt for and receive payment number
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter payment number to retrieve: ");
        int num = keyboard.nextInt();
        //retrieve payment object from list
        Payment p = listIn.getPayment(num); //returns null if invaid position
        if(p != null)  // check if Payment retrieved
        {
            System.out.println(p);
        }
        else
        {
            System.out.println("INVALID PAYMENT NUMBER: "); // invalid position error
        }
    }
    
    //GET TOTAL
    static void option5(PaymentList listIn)
    {
        System.out.println("TOTAL NUMBER OF PAYMENTS ENTERED: ");
        System.out.println(listIn.getTotal());
    }
    
    //GET TOTAL PAID
    static void option6(PaymentList listIn)
    {
        System.out.println("TOTAL OF PAYMENTS MADE SO FAR: ");
        System.out.println(listIn.calculateTotalPaid());
    }
}
