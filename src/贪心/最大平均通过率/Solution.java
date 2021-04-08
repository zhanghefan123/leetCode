package 贪心.最大平均通过率;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public int extraStudents;

    public double result;

    public HashMap<Integer,Integer> classes_list_add;

    public ArrayList<Integer> class_list_add_helper;

    public int[][] classes;

    public boolean[] visited;

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // 初始化
        this.extraStudents = extraStudents;
        this.classes_list_add = new HashMap<>();
        this.result = Integer.MIN_VALUE;
        this.classes = classes;
        this.extraStudents = extraStudents;
        this.class_list_add_helper = new ArrayList<>();
        // 每个班级只能够分配一个聪明的学生
        this.visited = new boolean[classes.length];
        // 二维数组之中的每个元素是一维数组
        // 一维数组的第一项是通过考试的学生数目，第二项是总共的学生的数目
        for(int i = 0;i<classes.length;i++)
        {
            classes_list_add.put(i,0);
        }
        dfs(0);
        return result;
    }

    // number 代表已经分配了几个学生
    public void dfs(int number)
    {
        if(number == extraStudents)
        {

            double tmp_res = 0;
            // 保留最大的平均通过率
            for(int key : this.classes_list_add.keySet())
            {
                int add = this.classes_list_add.get(key);
                tmp_res += ((double)(this.classes[key][0] + add) / (double)(this.classes[key][1] + add));
            }
            tmp_res /= classes.length;
            result = Math.max(tmp_res,result);
            return;
        }
        for(int i = 0; i < classes.length;i++)
        {

            if(!this.class_list_add_helper.isEmpty())
            {
                if(this.class_list_add_helper.get(this.class_list_add_helper.size()-1) <= i)
                {
                    // 如果这个班级没有添加好学生
                    this.class_list_add_helper.add(i);
                    this.classes_list_add.put(i,this.classes_list_add.get(i)+1);
                    dfs(number+1);
                    this.classes_list_add.put(i,this.classes_list_add.get(i)-1);
                    this.class_list_add_helper.remove(class_list_add_helper.size()-1);
                }
                else
                {
                    continue;
                }
            }
            else
            {
                // 如果这个班级没有添加好学生
                this.class_list_add_helper.add(i);
                this.classes_list_add.put(i,this.classes_list_add.get(i)+1);
                dfs(number+1);
                this.classes_list_add.put(i,this.classes_list_add.get(i)-1);
                this.class_list_add_helper.remove(class_list_add_helper.size()-1);
            }

        }
    }
}
