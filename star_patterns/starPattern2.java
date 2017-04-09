/*

1
2 2
3 3 3
4 4 4 4
5 5 5 5 5

*/

public class starPattern2
{
    public static void main(String[] args)
    {
        int max = 5;
        for(int i=1; i<=max; i++)
        {
            for(int j=0; j<i; j++)
            {
                System.out.print("" + i + " ");
            }
            System.out.println();
        }
    }
}
