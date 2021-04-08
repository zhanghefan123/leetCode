package 数学.蚂蚁感冒;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++)
        {
            array[i] = sc.nextInt();
        }
        // 在左边，向右边走的蚂蚁的数量
        int left = 0;
        // 在右边，向左边走的蚂蚁的数量
        int right = 0;
        // 第一个被感染的蚂蚁
        int x = array[0];
        for(int i = 1; i < n;i++){
            if(array[i] > 0 && Math.abs(array[i]) < Math.abs(x))
            {
                left++;
            }
            else if(array[i] < 0 && Math.abs(array[i]) > Math.abs(x))
            {
                right++;
            }
        }
        // 然后根据初始蚂蚁是向左还是向右来求解
        int res = 0;
        if(x < 0)
        {
            if(left > 0)
            {
                res = right + left + 1;
            }
            else
            {
                res = 1;
            }
        }
        else
        {
            if(right > 0)
            {
                res = right + left + 1;
            }
            else
            {
                res = 1;
            }
        }
        System.out.println(res);
    }
}
