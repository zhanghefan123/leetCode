package 枚举.错误票据;



import java.util.*;
public class Solution{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        int max_value = Integer.MIN_VALUE;
        int min_value = Integer.MAX_VALUE;
        for(int i = 0;i < N;i++)
        {
            String line = sc.nextLine();
            String[] array = line.split(" ");
            for(String item : array)
            {
                int current_number = Integer.parseInt(item);
                max_value = Math.max(max_value,current_number);
                min_value = Math.min(min_value,current_number);
                list.add(current_number);
            }
        }
        boolean[] boolean_array = new boolean[max_value+1];
        int lose = 0;
        int duplicate = 0;
        // 进行遍历填充布尔数组
        for(int item : list)
        {
            if(!boolean_array[item])
            {
                boolean_array[item] = true;
            }
            else
            {
                duplicate = item;
            }
        }
        // 再次进行一次布尔数组的遍历
        for(int i = min_value; i < boolean_array.length;i++)
        {
            if(!boolean_array[i])
            {
                lose = i;
                break;
            }
        }
        System.out.println(lose + " " + duplicate);
    }
}
