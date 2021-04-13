package 动态规划.状压dp.小国王;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static int N = 12, M = 1 << 10, K = 110;
    static int n, m;
    static ArrayList<Integer> state = new ArrayList<>();  // 储存所有的合法状态
    static ArrayList<Integer>[] head = new ArrayList[M];   // 可以转移当前状态的所有状态
    static int[] cnt = new int[M]; //每一个合法状态有多少个1
    static long[][][] f = new long[N][K][M]; // 行数，

        static boolean check(int x){
        for(int i = 0; i < n; i++){
            if(((x >> i) & (x >> i + 1)) == 1){
                return false;
            }
        }
        return true;
    }
    static int count(int x){
        int cnt = 0;
        for(int i = 0; i < n; i++){
            cnt += ((x >> i) & 1);
        }
        return cnt;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();

        for(int i = 0; i < 1 << n; i++) head[i] = new ArrayList();
        // 预处理出所有的合法状态
        for(int i = 0; i < 1 << n; i++){
            if(check(i)){ // 如果状态 i是合法的
                state.add(i);
                cnt[i] = count(i);
            }
        }

        // 枚举当前状态可以由哪些状态转移过来
        for(int i = 0; i < state.size(); i++){
            for(int j = 0; j < state.size(); j++){
                int a = state.get(i);
                int b = state.get(j);

                if(((a & b)== 0) && check(a | b)){
                    head[a].add(b);
                }
            }
        }
        f[0][0][0] = 1;
        // 放完了前i行
        for(int i = 1; i <= n + 1; i++)
            // 已经放了j个国王
            for(int j = 0; j <= m; j ++)
                // 状态的索引为k
                for(int k = 0; k < state.size(); k++){
                    // 状态
                    int a = state.get(k);
                    // 状态a可以转移到到的其他的位置。
                    for(int b : head[a]){
                        // 如果国王的个数也满足情况就发生转移的操作
                        if(j >= cnt[a]){
                            f[i][j][a] += f[i-1][j-cnt[a]][b];
                        }
                    }
                }
        // 前n+1行--这里虽然没有第n+1行但是假设有，我们让这第n+1行的状态为0即可。
        System.out.println(f[n+1][m][0]);
    }
}
