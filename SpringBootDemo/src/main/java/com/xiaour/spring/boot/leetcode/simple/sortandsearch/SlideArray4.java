package com.xiaour.spring.boot.leetcode.simple.sortandsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 滑动数组
 * 3. 无重复字符的最长子串
 *
 * @author rtw
 * @since 2024/9/29
 */
public class SlideArray4 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        SlideArray4 slideArray = new SlideArray4();
        System.out.println(slideArray.lengthOfLongestSubstring(s));
    }

    /**
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s == "") {
            return 0;
        }
        // 当前窗口内的数据
        int[] window = new int[128];

        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            char ss = s.charAt(right);
            right++;
            window[ss]++;


            while (window[ss] > 1) {
                char c = s.charAt(left);
                left++;
                window[c]--;
            }

            max = Math.max(max, right - left) ;
        }
        return max;
    }
}
