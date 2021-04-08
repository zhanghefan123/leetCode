package Recursion.NthTribonacciNumber;

public class NthTribonacciNumber {
    public int tribonacci(int n) {

        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return 1;
        }
        if(n==2)
        {
            return 1;
        }
        int [] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;
        if(n<=2)
        {
            return array[n];
        }
        for(int i=3;i<=n;i++)
        {
            array[i] = array[i-3] + array[i-2] + array[i-1];
        }
        return array[n];
    }
}
