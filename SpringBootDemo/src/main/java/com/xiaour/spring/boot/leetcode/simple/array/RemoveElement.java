package com.xiaour.spring.boot.leetcode.simple.array;

/**
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element/description/
 * @author rtw
 * @since 2024/10/20
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums =new int[]{0,1,2,2,3,0,4,2};
        RemoveElement removeElement = new RemoveElement();
        int i = removeElement.removeElement(nums, 2);
        System.out.println("SUCCESS");
    }

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while(fast < nums.length) {
            if(nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast ++;
        }
        return slow;
    }
}
