package ARRAY.Candies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//O(n^2)的分糖果算法
public class Candy {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        String hel = "hello";

        List<Boolean> list = new ArrayList<>();
        int choosen;
        boolean flag = false;
        for(int i=0;i<candies.length;i++)
        {
            choosen = candies[i] + extraCandies;
            flag = true;
            for(int j=0;j<candies.length;j++)
            {
                if(candies[j]>choosen)
                {
                    flag = false;
                    break;
                }
            }
            list.add(flag);
        }
        return list;
    }
}
