class Solution {

    int res = 0;
    boolean[][] visited;
    int visitedCount = 0;
    int totalCount = 0;

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        visited = new boolean[m][n];

        int startI = 0, startJ = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 识别起点
                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                }
                // 计算总步数，因为要求把所有的空白结点都走到
                if (grid[i][j] == 1 || grid[i][j] == 0) {
                    totalCount++;
                }
            }
        }
        // 为什么有这一步呢，因为采用了回溯算法，导致根节点是遍历不到的。这是和DFS最大的区别
//        visited[startI][startJ] = true;
        dfs(grid, startI, startJ);

        return res;
    }

    // DFS 算法框架
    void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;

        // 剪枝，索引越界
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        // 到达终点
        if (grid[i][j] == 2) {
            if (visitedCount == (totalCount)) {
                res++;
            }
            return;
        }

        // 剪枝，跳过起点、障碍物、已访问的格子
        if (grid[i][j] == -1 ) {
            return;
        }

        for (int[] dir : dirs) {
            int i1 = i + dir[0];
            int j1 = j + dir[1];
            // 剪枝，索引越界
            if (i1 < 0 || i1 >= m || j1 < 0 || j1 >= n) {
                continue;
            }
            // 访问都是需要放在循环内部了，放在循环外部的话永远都是访问过了，相当于先设置为true，然后校验是否访问过
            if (visited[i][j]) {
                break;
            }

            visited[i][j] = true;
            visitedCount++;
            dfs(grid, i1, j1);
            visited[i][j] = false;
            visitedCount--;
        }
    }
}
//runtime:0 ms
//memory:40.2 MB
