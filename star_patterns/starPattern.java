public class starPattern
{
    public static void main(String[] args)
    {
        int[] arr = {1,2,4,6,3,8};
        int size = arr.length;

        int max = -1;
        for(int num : arr)
        {
            System.out.print("" + num + " ");
            if(max < num)
                max = num;
        }
        System.out.println();

        for(int i=0; i<max; i++)
        {
            for(int j=0; j<size; j++)
            {
                if(max-arr[j]-i > 0)
                    System.out.print("  ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }
}
