package 滑动窗口;

public class LongestSubstring {
    /*
    对于给定的字符种类t,我们维护滑动窗口的左右边界l,r，滑动窗口内部每个字符出现的次数cnt
    以及滑动窗口内字符种类数量tot,当tot>t时，我们不断的右移左边界，并对应的更新cnt
    以及tot,知道tot<=t为之，这样对于任何一个右边界，我们都能够找到最大的lmax使得
    s[lmax……r]之间的字符种类数目不多于t.


    * */
    public int longestSubstring(String s, int k) {
        int ret = 0;
        int n = s.length();
        // 我们枚举最长子串中的字符种类数目，它最小为 11，最大为 Σ（字符集的大小，本题中为 26）
        for (int t = 1; t <= 26; t++) {
            // 滑动窗口的左右边界
            int l = 0, r = 0;
            // 滑动窗口内部每个字符出现的次数cnt
            int[] cnt = new int[26];
            // 滑动窗口内的字符种类数目tot
            int tot = 0;
            // 这是一个计数器less,代表当前出现次数小于k(且不为0)的字符的数量。
            // 情况1：当某个字符的出现次数由0到1时，less++;
            // 情况2：当某个字符的出现次数从k-1增加到k时，less--;
            int less = 0;
            // 当右边界小于长度就继续循环
            while (r < n) {
                // 记录每个字符出现的次数
                cnt[s.charAt(r) - 'a']++;
                if (cnt[s.charAt(r) - 'a'] == 1) {
                    // 如果由0-1，则滑动窗口内的字符数++；
                    tot++;
                    // 当某个字符的出现次数由0到1时，less++;
                    less++;
                }
                //当某个字符的出现次数从k-1增加到k时，less--;
                if (cnt[s.charAt(r) - 'a'] == k) {
                    less--;
                }

                while (tot > t) {
                    cnt[s.charAt(l) - 'a']--;
                    if (cnt[s.charAt(l) - 'a'] == k - 1) {
                        less++;
                    }
                    if (cnt[s.charAt(l) - 'a'] == 0) {
                        tot--;
                        less--;
                    }
                    l++;
                }
                // 当小于k的字符个数为0时返回结果。
                if (less == 0) {
                    ret = Math.max(ret, r - l + 1);
                }
                r++;
            }
        }
        return ret;
    }
}
