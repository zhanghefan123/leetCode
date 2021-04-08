package SORT.基于比较的排序.MERGESORT_时间复杂度nlogn;

//并归排序的思路：先将左侧排好序，再将右侧排好序，然后将两个利用外排的方式进行排好
//举例 5 2 6 3 0 1 进行排序
/*
1.数组先进行折半的操作，分为 A数组: 5 2 6    B数组:3 0 1
2.创建一个临时数组长度为整体数组的长度
3.使用A指针和B指针分别指向两个数组开头的元素
4.两个元素比较大小
5.哪个元素更小哪个元素插入到临时数组之中，并且对应指针后移
6.如果两个元素相等则同时向后移动一个位置。
* */
//时间复杂度 T(n)=2T(n/2)+O(N)
//空间复杂度 O(n)临时数组产生的
public class MergeSort {
    public static void main(String[] args) {

    }
    //只是将一个数组分成两部分然后分别进行排好序，然后进行外排
    public static void mergeSort(int[] arr)
    {
        if(arr==null||arr.length<2)
        {
            return;
        }

    }
    //这个函数是在L到R范围上实现归并排序
    public static void sortProcess(int[]arr,int L,int R)
    {
        //如果L==R即只有一个元素直接进行返回，不用排序
        if(L==R)
        {
            return;
        }
        //否则找到中间元素，对左边进行排序，再对右边进行排序，然后将左右两个数组进行merge
        int mid = L+((R-L)>>1);
        sortProcess(arr,L,mid);
        sortProcess(arr,mid+1,R);
        merge(arr,L,mid,R);
    }
    public static void merge(int[] array,int L,int mid,int R)
    {
        //临时辅助数组
        int[] help = new int[R-L+1];//L到R一共存在R-L+1个数，即创建一个这么大的数组
        int i = 0;
        int p1 = L;//指向左侧数组首元素的指针
        int p2 = mid+1;//指向右侧数组首元素的指针
        while(p1<=mid && p2<=R)
        {
            help[i++] = array[p1] < array[p2] ? array[p1++]:array[p2++]; //选择小的插入，并且对应指针后移
        }
        //两个指针必有且只有一个会发生越界的情况
        while(p1<=mid)
        {
            //将余下的数组依次进行填入的操作
            help[i++] = array[p1++];
        }
        while(p2<=R)
        {
            help[i++] = array[p2++];
        }
        //将数组拷贝到原数组之中
        for(int j=0;j<=(L-R+1);j++)
        {
            array[L+i] = help[i];
        }
    }
}
