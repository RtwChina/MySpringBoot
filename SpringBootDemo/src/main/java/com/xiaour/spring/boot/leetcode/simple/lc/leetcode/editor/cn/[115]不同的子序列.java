import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String s, String t) {
        mem = new int[s.length() +1][t.length()+1];
        for (int[] memx:mem) {
            Arrays.fill(memx, -1);
        }
        return dp(s, t, 0, 0);
    }

    int[][] mem;

    /**
     * 计算出s[sStart ~] 中包含 t[tStart ~]的子序列数量
     *
     * @param s
     * @param t
     * @param sStart
     * @param tStart
     * @return
     */
    public int dp(String s, String t, int sStart, int tStart) {
        int sLen = s.length();
        int tLen = t.length();

        // 终点 todo
//        if (sStart >= sLen || tStart >= tLen) {
//            return 0;
//        }
//
        // base case，t的最后一个字符已经在s中找到位置
        if (tStart == tLen) {
            mem[sStart][tStart] = 1;
            return 1;
        }
        // 表示s的最后一个字符，但是走到这里，表示tStart还未在结尾，说明已经不可能在s中找到后续字符了
        if (sStart >= sLen) {
            return 0;
        }
        int sum = 0;
        for (int i = sStart; i < sLen; i++) {
            char c = s.charAt(i);
            if (c == t.charAt(tStart)) {
                if (mem[i+1][tStart + 1] != -1) {
                    sum += mem[i+1][tStart + 1];
                } else {
                    int count = dp(s, t, i + 1, tStart + 1);
                    sum += count;
                }
            }
        }
        mem[sStart][tStart] = sum;
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
