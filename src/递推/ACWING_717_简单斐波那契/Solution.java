package 递推.ACWING_717_简单斐波那契;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0;
        int b = 1;
        for(int i = 1;i<=n;i++)
        {
            System.out.print(a + " ");
            int fn = a + b;
            a = b;
            b = fn;
        }
        System.out.println();
    }
}
