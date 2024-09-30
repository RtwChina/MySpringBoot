package com.xiaour.spring.boot.leetcode.simple.sortandsearch;

/**
 * 二分搜索法
 * https://leetcode.cn/problems/binary-search/description/
 *
 * @author rtw
 * @since 2024/9/29
 */
public class DichotomousSearch {
    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3, 3, 3, 7, 8, 10};
        DichotomousSearch search = new DichotomousSearch();
        int search1 = search.left_search(num, 3);
        System.out.println(search1);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 采用前闭后闭的逻辑，必须采用<=，确保比如在[2,2]的时候2的元素能够被校验
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 查找左侧边界 比如 1 2 2 3，返回 1(最左边的 target 的下标)
     *
     * @param nums
     * @param target
     * @return
     */
    public int left_search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            // 里面是没有修改的
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 相等，左移右边界
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left < 0) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }


    /**
     * 查找右侧边界 比如 1 2 2 3，返回 2(最右边的 target 的下标)
     *
     * @param nums
     * @param target
     * @return
     */
    public int right_search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            // 里面是没有修改的
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 相等，左移右边界
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left  -1  < 0) {
            return -1;
        }
        // 剪一的原因是：在 while里面当 left的 mid就是最左侧 target 的时候，会剪一后跳出循环，所以最终的位置需要左移一位。
        return nums[left-1 ] == target ? left-1  : -1;
    }
}
