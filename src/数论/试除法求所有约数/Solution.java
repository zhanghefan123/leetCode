package 数论.试除法求所有约数;

import java.util.*;
class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i<n;i++)
        {
            int tmp = sc.nextInt();
            function(tmp);
        }
    }

    public static void function(int n)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1;i<=n/i; i++)
        {
            if(n % i == 0)
            {
                if(i == n/i)
                {
                    list.add(i);
                }
                else
                {
                    list.add(i);
                    list.add(n/i);
                }
            }

        }
        Collections.sort(list,new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2)
            {
                return o1 - o2;
            }
        });
        for(int i : list)
        {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}