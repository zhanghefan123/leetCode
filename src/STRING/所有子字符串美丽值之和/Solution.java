package STRING.所有子字符串美丽值之和;

import java.util.Arrays;

public class Solution {
    public int beautySum(String s) {
        int INF=0x3f3f3f3f;
        char[]arr=s.toCharArray();
        int n=s.length();
        int []f=new int[26];
        int res=0;
        for(int i=0;i<n;i++){
            Arrays.fill(f,0);
            for(int j=i;j<n;j++){
                f[arr[j]-'a']++;
                int max=-INF;
                int min=INF;
                for(int k=0;k<26;k++){
                    if(f[k]==0)continue;
                    max=Math.max(max,f[k]);
                    min=Math.min(min,f[k]);
                }
                res+=(max-min);
            }
        }

        return res;
    }
}
