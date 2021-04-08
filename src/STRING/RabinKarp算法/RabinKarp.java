package STRING.RabinKarp算法;

public class RabinKarp {
    public static void RabinKarpAlogrithm(char[] T, char[] P, int d, int q) {
        //q是一个素数，d是进制
        int n = T.length;//n是主串的长度
        int m = P.length;//m是可能包含的子串的长度
        if (n < m) return;
        int h = 1;
        for (int i = 1; i <= m - 1; i++)   // 计算高度 h
            h = h * d % q;//m-1个d相乘然后模q
        //预处理，计算p--字串的哈希值，t--和子串相同长度的哈希值。
        int p = 0, t = 0;
        for (int i = 0; i < m; i++) {
            p = ((d * p + P[i]) % q);
            t = ((d * t + T[i]) % q);
        }
        //开始匹配
        for (int s = 0; s < n - m + 1; s++) {
            //如果哈希值相同
            if (p == t) {
                int i;
                //进行进一步的验证
                for (i = 0; i < m; i++)
                    if (P[i] != T[s + i])
                        break;
                //说明发生了完全的匹配，可以退出了。
                if (i == m) System.out.println("Pattern occurs with shift:" + s);
            }
            //如果s<n-m -- 即主串还有子串的长度没有进行匹配，说明还有可能匹配出来。
            if (s < n - m)
                t = (d * (t - T[s] * h % q) + T[s + m]) % q;  // 计算ts+1
        }
        System.out.println("string matching ends");
    }

    public static void main(String[] args) {
        String strT = "2359023141526739921";
        String strP = "31415";
        char[] T = strT.toCharArray();
        char[] P = strP.toCharArray();
        int d = 10;
        int q = 13;
        RabinKarp.RabinKarpAlogrithm(T, P, d, q);
    }
}
