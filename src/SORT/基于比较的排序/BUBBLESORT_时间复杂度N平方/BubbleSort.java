package SORT.基于比较的排序.BUBBLESORT_时间复杂度N平方;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] A = new int[]{3,5,4,7};
        test(A);
        System.out.println(Arrays.toString(A));
    }
    //冒泡排序
    //思路：先看0位置和1位置上的数，小的放前面
    //再看1位置和2位置上的数，小的放前面，这样做的话最大的数就会来到最后面
    //此时不用管第N-1个数

    //复杂度的估算
    //2个for循环嵌套就是O(n²)
    public static void test(int[] A)
    {
        //如果是一个数或者数组为空就没有必要去排序了
        if(A == null || A.length<2)
        {
            return;
        }
        else
        {
            //第一次我们需要交换直到末尾，第二次我们只需要交换到倒数第二个
            for(int end = A.length-1;end>0;end--)
            {
                for(int i=0;i<=end-1;i++)
                {
                    if(A[i]>A[i+1])
                    {
                        int temp = 0;
                        temp = A[i];
                        A[i] = A[i+1];
                        A[i+1] = temp;
                    }
                }
            }
        }
    }
}
