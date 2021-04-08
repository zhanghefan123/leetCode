package ARRAY.构建乘积数组;

import java.util.Deque;
import java.util.LinkedList;


public class Solution {
    public int[] multiply(int[] A) {
        Deque<Integer> queue = new LinkedList<>();
        int length = A.length;
        if(length == 0)
        {
            return new int[]{};
        }
        int[] B = new int[length];
        B[0] = 1;
        for(int i = 1; i < length; i ++){
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for(int j = length - 2; j >= 0; j --){
            temp *= A[j + 1];//temp始终会记录值，每次只需要加上这行上三角没有乘进来的数就可以了。
            B[j] *= temp;
        }
        return B;
    }
}
