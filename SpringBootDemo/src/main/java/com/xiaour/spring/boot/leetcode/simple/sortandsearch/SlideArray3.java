package com.xiaour.spring.boot.leetcode.simple.sortandsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 滑动数组
 * 438. 找到字符串中所有字母异位词
 *
 * @author rtw
 * @since 2024/9/29
 */
public class SlideArray3 {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        SlideArray3 slideArray = new SlideArray3();
        System.out.println(slideArray.findAnagrams(s, p));
    }

    /**
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s == "" || p == null || p == "" || s.length() < p.length()) {
            return new ArrayList<>();
        }
        // 当前窗口内的数据
        int[] window = new int[128];
        // 目标信息
        int[] need = new int[128];

        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        while (right < s.length()) {
            char ss = s.charAt(right);
            right++;
            if (window[ss] < need[ss]) {
                count++;
            }
            window[ss]++;


            while (right - left == p.length()) {
                if (count == p.length()) {
                    ans.add(left);
                }
                char c = s.charAt(left);
                left++;
                if (window[c]<=(need[c])) {
                    count--;
                }
                window[c]--;
            }
        }
        return ans;
    }
}
