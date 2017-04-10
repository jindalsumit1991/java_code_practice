/* *********************************************************************
 *
 * Take n numbers, print the length of longest increasing sub-sequence 
 *
 * ********************************************************************/

import java.util.*;

public class problem3
{
    public static void main(String[] str)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of main sequence: ");

        int count = scanner.nextInt();
        int[] numbers = new int[count];

        System.out.print("Enter the 10 numbers");

        System.out.print("\nInput the numbers seperated by space/newline: ");
        for(int i=0; i<count; i++)
            numbers[i] = scanner.nextInt();


        int longestSoFar = 0;
        int length = 1;
        for(int i=0; i<count-1; i++)
        {
            if((numbers[i+1] >= numbers[i]))
                length++;
            else
                length = 1;
            longestSoFar = (longestSoFar < length) ? length : longestSoFar;
        }
        System.out.println("Length of longest increasing sequence is: " + longestSoFar);
    }
}
