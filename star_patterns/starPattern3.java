/*

0
1 2
3 4 5
6 7 8 9
0 1 2 3 4

*/

public class starPattern3
{
    public static void main(String[] args)
    {
        int max = 5;
        int counter = 0;

        for(int i=0; i<max; i++)
        {
            for(int j=0; j<=i; j++)
            {
                System.out.print("" + counter++  + " ");
                if(counter > 9)
                {
                    counter = 0;
                }
            }
            System.out.println();
        }
    }
}
