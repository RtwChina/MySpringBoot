import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return backTrack(s, wordDict);
    }

    private String track = new String();
    private HashSet<String> failMap = new HashSet<>();

    // 回溯算法,排列逻辑
    public boolean backTrack(String s, List<String> wordDict) {
        // 判断终结条件
        if (s.equals(track)) {
            return true;
        }

        // 拼接的字符串已经超过目标字符串长度了
        if (s.length() < track.length()) {
            return false;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            // 减枝
            if (!s.startsWith(track)) {
                return false;
            }

            // 减枝
            if (failMap.contains(track)) {
                return false;
            }

            // 选择
            track = track + wordDict.get(i);
            if (backTrack(s, wordDict)) {
                return true;
            }

            // 后序过程中，塞入每一层的track。
            failMap.add(track);
            track =  track.substring(0, track.length() - wordDict.get(i).length());
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
