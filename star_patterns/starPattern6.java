/*

      1
    1 2 1
  1 2 3 2 1
1 2 3 4 3 2 1

*/

public class starPattern6
{
    public static void main(String[] args)
    {
        int max = 6;

        for(int i=0; i<max; i++)
        {
            int printer = 0;
            for(int j=1; j<=max+i-1; j++)
            {

                if(j < max)
                {
                    if(max-j-i > 0)
                        System.out.print("  ");
                    else{
                        printer++;
                        System.out.print("" + printer + " ");
                    }
                }
                else if(j > max)
                {
                    printer--;
                    System.out.print("" + printer + " ");
                }
            }

            System.out.println();
        }
    }
}
