/*

          *
        * *
      * * *
    * * * *
  * * * * *
* * * * * *

*/

public class starPattern1
{
    public static void main(String[] args)
    {
        int max = 5;

        for(int i=0; i<=max; i++)
        {
            for(int j=0; j<=max; j++)
            {
                if(max-j-i > 0)
                    System.out.print("  ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }
}
