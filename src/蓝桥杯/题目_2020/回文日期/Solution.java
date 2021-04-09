package 蓝桥杯.题目_2020.回文日期;

import java.util.Scanner;

public class Solution {
    public static String source_date;

    public static String destination_date;

    public static int source_date_value;

    public static int destination_date_value;

    // 注意月份是从1开始的，所以0号位置无用处
    public static int[] month_date = new int[] {0,31,28,31,30,31,30,31,31,30,31,30,31};

    public static int res = 0;

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        source_date = sc.nextLine();
        source_date_value = Integer.parseInt(source_date);
        destination_date = sc.nextLine();
        destination_date_value = Integer.parseInt(destination_date);
        dfs();
        sc.close();
    }

    public static void dfs()
    {
        // 开始进行日期的生成
        // 首先开始前四位日期的生成
        for(int i = 1000;i<=9999;i++)
        {
            String item = Integer.toString(i);
            char[] array = item.toCharArray();
            reverse(array);
            item = item + new String(array);
            check(item);
        }
        System.out.println(res);
    }

    public static boolean check_if_run(int year)
    {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void check(String item)
    {
        // 首先判断是否在两个日期之间
        int value = Integer.parseInt(item);
        if(value>=source_date_value && value <= destination_date_value)
        {
            // 然后判断月份是否符合标准
            int month = (value / 100) % 100;
            if(month>=1 && month<=12)
            {
                // 判断日期是否符合标准
                int date = (value) % 100;
                if(month == 2)
                {
                    // 如果是闰年
                    if(check_if_run(value / 10000))
                    {
                        if(date>=1 && date <= 29)
                        {
                            res++;
                        }
                    }
                    // 如果不是闰年
                    else
                    {
                        if(date>=1 && date <= 28)
                        {
                            res++;
                        }
                    }
                }
                else
                {
                    if(date>=1 && date<=month_date[month])
                    {
                        res++;
                    }
                }
            }
        }
    }


    public static void reverse(char[] array)
    {
        int i = 0;
        int j = array.length-1;
        while(i < j)
        {
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }
}
