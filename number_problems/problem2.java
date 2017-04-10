/* ******************************************************
 *
 * Take n numbers, print number of even no's among them
 *
 * ******************************************************/

import java.util.*;

public class problem2
{
    public static void main(String[] str)
    {
        int count, evens;

        /* They say int has a default value of 0, but compiler gives me error
           if I don't initialize the int variables */

        evens= 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of inputs: ");
        count = scanner.nextInt();

        System.out.print("\nInput the numbers seperated by space/newline: ");
        for(int i=0; i<count; i++)
        {
            int input = scanner.nextInt();
            if((input % 2) == 0)
                evens++;
        }
        System.out.println("Count of even numbers: " + evens);
    }
}
