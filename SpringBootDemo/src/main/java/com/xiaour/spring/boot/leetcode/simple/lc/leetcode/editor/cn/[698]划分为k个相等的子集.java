package com.xiaour.spring.boot.leetcode.simple.lc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Boolean ans = false;
    List<Integer> track = new LinkedList<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            track.add(i, 0);
        }
        Integer tar = Arrays.stream(nums).sum() / k ;
        backtrack(nums, 0, k, tar);
        return ans;
    }

    public void backtrack(int[] nums, int index, int k,int tar) {
        if (index >= nums.length) {
            int right = 0;
            for (Integer integers : track) {
                if (integers == tar) {
                    right++;
                }
            }
            if (right == k) {
                ans = true;
            }
            return;
        }

        for (int i = 0; i < k; i++) {

            Integer sumI = track.get(i);
            track.set(i, sumI+nums[index]);
            backtrack(nums, index+1, k,tar);
            track.set(i, sumI-nums[index]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
