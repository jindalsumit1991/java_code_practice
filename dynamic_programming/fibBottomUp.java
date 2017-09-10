import java.util.ArrayList;
import java.util.List;

public class fibBottomUp {

    public static long fib(int n) {
        long[] array = new long[n];
	array[0] = 1;
	array[1] = 1;
        for(int i=2; i<n; i++)
	    array[i] = array[i-1] + array[i-2];
	
	return array[n-1];
    }

    public static void main(String[] s){
        int n = 50;
	System.out.println("" + n + "th fibonacci term is " + fib(n));
    }
}
