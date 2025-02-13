
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (canAdd(nums, slow, fast)) {
                slow ++;
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                fast++;
            } else {
                fast++;
            }
        }
        return ++slow;
    }

    // 判断[0,slow]范围内是否后续添加fast
    public boolean canAdd(int[] nums, int slow, int fast) {
        if (nums[slow] != nums[fast]) {
            return true;
        }
        if (slow -1>=0 && nums[slow-1] != nums[fast]) {
            return true;
        }
        if (slow < 1) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
