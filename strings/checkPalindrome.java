/* *************************************************
 *
 * Check if a string is palindrome or not
 *
 * ***********************************************/

import java.util.*;

public class checkPalindrome
{
    public static void main(String[] str)
    {
        Scanner scanner = new Scanner(System.in);
        String name;

        System.out.print("Enter the input string: ");
        name = System.console().readLine();

        int length = name.length();

        int mid = length/2;
        int index = mid-1;

        boolean isPalindrome = true;
        for(int i=0; i<=mid-1; i++)
        {
            if(name.charAt(i) != name.charAt(length-i-1))
                isPalindrome = false;
        }
        System.out.println("Palindrome : " + isPalindrome);
    }
}
