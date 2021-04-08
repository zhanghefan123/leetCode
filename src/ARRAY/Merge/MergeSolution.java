package ARRAY.Merge;
// 快速排序的merge
/*
first step:
A = [1,2,3,0,0,0]
         ^     ^
         p1    p
B = [2,5,6]

second step:
A = [1,2,3,0,0,6]
         ^   ^
         p1  p
B = [2,5,6]
       ^
       p2

third step:
A = [1,2,3,0,5,6]
         ^ ^
         p1 p
B = [2,5,6]
     ^
    p2

forth step:
A = [1,2,3,3,5,6]
       ^ ^
       p1 p
B = [2,5,6]
     ^
    p2

fifth step:
A = [1,2,2,3,5,6]
     ^ ^
     p1 p
B = [2,5,6]
     ^
    p2

sixth step:
A = [1,2,2,3,5,6]
     ^ ^
     p1 p
B = [2,5,6]
   ^
   p2

总的来说思路也是一样的就是：
创建一个新的数组，然后两个指针从后向前进行遍历，

 */
public class MergeSolution {
    public void merge(int[] A, int m, int[] B, int n) {
            int i = m - 1, j = n - 1;
            while(i >= 0 && j >= 0) {
                if(B[j] >= A[i]) {
                    A[i + j + 1] = B[j--];//注意这个i+j+1是从A数组最后一个位置开始的指针
                } else {
                    A[i + j + 1] = A[i--];
                }
            }
            // 我们是将B数组插入到A数组之中，自然可能最终是B数组没有全部插入
            // 所以最终使用while循环将剩余的B数组之中的元素插入。
            while(j >= 0) {
                A[j] = B[j--];
            }
    }

}
