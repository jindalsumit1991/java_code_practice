/* *************************************************
 *
 * Take 4 numbers, print the minimum and maximum
 *
 * ***********************************************/

import java.util.*;

public class problem1
{
    public static void main(String[] str)
    {
        int count, min, max;

        /* They say int has a default value of 0, but compiler gives me error
           if I don't initialize the int variables */

        min = max = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of inputs: ");
        count = scanner.nextInt();

        System.out.print("\nInput the numbers seperated by space/newline: ");
        for(int i=0; i<count; i++)
        {
            if(i == 0)
                min = max = scanner.nextInt();

            else
            {
                int maxTemp, minTemp;
                maxTemp = minTemp = scanner.nextInt();

                if(max < maxTemp)
                    max = maxTemp;

                if(min > minTemp)
                    min = minTemp;
            }
        }
        System.out.println("Max: " + max + "\nMin: " + min);
    }
}
