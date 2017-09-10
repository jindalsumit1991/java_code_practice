import java.util.ArrayList;
import java.util.List;

public class fibTopDown {

    private long[] arr;
    public fibTopDown(int n) {
	arr = new long[n+1];
	for(int i=0; i<=n; i++)
	    arr[i] = -1;
    }
    public long fib(int n) {
	if(n==0 || n==1)
	    return 1;
	
	if(arr[n] != -1)
	    return arr[n];
	
        arr[n] = fib(n-1) + fib(n-2);
	return arr[n];
    }

    public static void main(String[] s){
        int n = 49;
	fibTopDown obj = new fibTopDown(n);
	System.out.println("" + n + "th fibonacci term is " + obj.fib(n));
    }
}
