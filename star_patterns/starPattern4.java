/*

1
2 2 2
3 3 3 3 3 
4 4 4 4 4 4 4
5 5 5 5 5 5 5 5 5

*/

public class starPattern4
{
    public static void main(String[] args)
    {
        int max = 5;
        int counter = 0;

        for(int i=1; i<=max; i++)
        {
            for(int j=0; j<(2*i-1); j++)
                System.out.print("" + i  + " ");

            System.out.println();
        }
    }
}
