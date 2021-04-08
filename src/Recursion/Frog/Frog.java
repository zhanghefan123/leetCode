package Recursion.Frog;

public class Frog {
    public int numWays(int n) {

        if(n == 0 || n == 1)
        {
            return 1;
        }
        int[] array = new int[n+1];
        array[0] = 1;
        array[1] = 1;
        for(int i=2;i<n+1;i++)
        {
            array[i] = (array[i-1] + array[i-2])%1000000007;
        }
        return array[n];
    }
}
