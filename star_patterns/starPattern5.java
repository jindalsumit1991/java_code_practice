/*

   0
   0 1
   1 0 1
   0 1 0 1
   0 1 0 1 0

*/

public class starPattern5
{
    public static void main(String[] args)
    {
        int max = 5;
        int printer = 0;

        for(int i=1; i<=max; i++)
        {
            for(int j=0; j<i; j++)
            {
                System.out.print("" + printer  + " ");
                if(printer == 1)
                    printer = 0;
                else
                    printer = 1;
            }

            System.out.println();
        }
    }
}
