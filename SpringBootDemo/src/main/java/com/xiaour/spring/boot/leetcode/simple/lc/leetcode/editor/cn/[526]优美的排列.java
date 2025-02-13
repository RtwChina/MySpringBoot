
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    boolean[] visited;
    int[] track;

    public int countArrangement(int n) {
        visited = new boolean[n+1];
        track = new int[n+1];
        return track(n, 1);
    }

    public int track(int n, int start) {
        // 校验
        if (start == n+1) {
            // 所有结果都完成处理了
            for (int i = 1; i< track.length;i++) {
                if (track[i] % i != 0 && i % track[i]!=0) {
                    // 都不满足条件
                    return 0;
                }
            }
            return 1;
        }



        // 迭代
        int res = 0;
        for (int i=1;i<=n;i++) {
            if (visited[i]) {
                continue;
            }
            if (i % start != 0 && start % i!=0) {
                // 都不满足条件
                continue;
            }

            track[start] = i;
            visited[i] = true;
            res = res + track(n,start+1);
            track[start] = 0;
            visited[i] = false;
        }
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
