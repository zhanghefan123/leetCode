package 滑动窗口.ACWING_1238_日志统计;

import java.util.*;
class Single_log{
    int time;
    int id;
    public Single_log(int time,int id)
    {
        this.time = time;
        this.id = id;
    }
    public String toString()
    {
        return "时间:" + time +" " + "id:" + id;
    }

}
public class Solution {

    public static ArrayList<Single_log> log_list = new ArrayList<>();

    public static int[] id_to_likes_count = new int[100001];

    public static boolean[] is_hot_id = new boolean[100001];

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 总共存在N行
        int N = sc.nextInt();
        // 长度为D的时间段
        int D = sc.nextInt();
        // 赞的数量不小于K则被称之为热帖
        int K = sc.nextInt();
        // 首先将所有的记录进行读入
        for(int i = 0; i < N; i++)
        {
            int time = sc.nextInt();
            int id = sc.nextInt();
            Single_log log = new Single_log(time,id);
            log_list.add(log);
        }
        // 对于log_list按照时间进行排序
        Collections.sort(log_list, new Comparator<Single_log>() {

            @Override
            public int compare(Single_log o1, Single_log o2) {
                return o1.time - o2.time;
            }
        });
        // 开始进行滑动窗口
        // step1:找到右侧的窗口
        int window_left = 0;
        int window_right = 0;
        while(window_right < log_list.size())
        {
            Single_log right_current_log = log_list.get(window_right);
            int right_id = right_current_log.id;
            int right_time = right_current_log.time;
            id_to_likes_count[right_id]++;

            Single_log left_current_log = log_list.get(window_left);
            int left_id = left_current_log.id;
            int left_time = left_current_log.time;
            while(right_time - left_time >= D)
            {
                id_to_likes_count[left_id]--;
                left_current_log = log_list.get(++window_left);
                left_id = left_current_log.id;
                left_time = left_current_log.time;
            }
            if(is_hot_id[right_id] || id_to_likes_count[right_id] >= K)
            {
                is_hot_id[right_id] = true;
            }
            window_right++;
        }
        // 进行遍历输出id
        for(int i = 0; i < is_hot_id.length;i++ )
        {
            if(is_hot_id[i])
            {
                System.out.println(i);
            }
        }
    }
}
