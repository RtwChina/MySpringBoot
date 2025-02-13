import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] target = new int[][]{
                {1,2,3},{4,5,0}
        };
        return bfs(board, target);
    }


    public int bfs(int[][] board, int[][] target) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(encode(board));
        HashSet<String> visited = new HashSet<>();
        int step = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 处理第零层
            step++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(encode(target))) {
                    return step;
                }

                int[] neighbor = findNeighbor(poll);
                int zeroIndex = findzero(poll);
                for (int neighborIndex : neighbor) {
                    String swap = swap(neighborIndex, zeroIndex, poll);
                    if (visited.contains(swap)) {
                        continue;
                    }
                    visited.add(swap);
                    queue.offer(swap);
                }
            }
        }
        return -1;
    }

    public String swap(int x, int y,String str) {
        char[] charArray = str.toCharArray();
        char xValue =  charArray[x];
        charArray[x] = charArray[y];
        charArray[y] = xValue;
        return String.valueOf(charArray);
    }
    String encode(int[][] array) {
        String code = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                code = code + array[i][j];
            }
        }
        return code;
    }


    int[][] decode(String decoStr) {
        int[][] array = new int[2][3];
        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = decoStr.charAt(index);
                index++;
            }
        }
        return array;
    }


    /**
     * 返回领居的index.
     * @param encodeStr
     * @return
     */
    public int[] findNeighbor(String encodeStr) {
        // 先找到为 0 的节点
        int i = encodeStr.indexOf("0");
        int[][] mapping = new int[][] {
                {1, 3},
                {0, 4, 2},
                {1, 5},
                {0, 4},
                {3, 1, 5},
                {4, 2}
        };
       return mapping[i];
    }


    public int findzero(String encodeStr) {
        // 先找到为 0 的节点
        return   encodeStr.indexOf("0");
    }
    public int[] findZero(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
