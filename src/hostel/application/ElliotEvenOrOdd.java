/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel.application;
import java.util.Scanner;

/**
 *
 * @author Abdul-Razak Hussein
 */
public class ElliotEvenOrOdd
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a number and i will tell if it is even or odd");
        double num = keyboard.nextDouble();
        if(num%2 == 0)
        {
            System.out.println("The number is even");
        }
        else
        {
            System.out.println("The number is odd");
        }
    }
}
