import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        backTrack(s, wordDict);
        return trackList;
    }

    private String track = new String();

    private boolean trackSuccess = false;
    private List<Integer> trackIndex = new ArrayList<>();

    private List<String> trackList = new LinkedList<>();
    private HashSet<String> failMap = new HashSet<>();

    // 回溯算法,排列逻辑
    public void backTrack(String s, List<String> wordDict) {
        // 判断终结条件
        if (s.equals(track)) {
            trackSuccess = true;
            trackList.add(buildMsg(wordDict, trackIndex));
            return;
        }

        // 拼接的字符串已经超过目标字符串长度了
        if (s.length() < track.length()) {
            return;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            // 减枝
            if (!s.startsWith(track)) {
                return;
            }

            // 减枝
            if (failMap.contains(track)) {
                return;
            }

            // 选择
            track = track + wordDict.get(i);
            trackIndex.add(i);
            backTrack(s, wordDict);
            // 后序过程中，塞入每一层的track。
//            failMap.add(track);
            trackIndex.remove(trackIndex.size() - 1);
            track =  track.substring(0, track.length() - wordDict.get(i).length());
        }
    }

    public String buildMsg(List<String> wordDict,  List<Integer> trackIndex) {
        StringBuilder msg = new StringBuilder();
        for (Integer index : trackIndex) {
            msg.append(wordDict.get(index)).append(" ");
        }
        return msg.substring(0, msg.length() - 1);
    }
}
