package com.xiaour.spring.boot.leetcode.simple.sortandsearch;

/**
 * 滑动数组
 * 567. 字符串的排列
 *
 * @author rtw
 * @since 2024/9/29
 */
public class SlideArray2 {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ooolleoooleh";
        SlideArray2 slideArray = new SlideArray2();
        System.out.println(slideArray.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1 == "" || s2 == null || s2 == "" || s2.length() < s1.length()) {
            return false;
        }
        // 当前窗口内的数据
        int[] window = new int[128];
        // 目标信息
        int[] need = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            need[s1.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int count = 0;

        while (right < s2.length()) {
            char ss = s2.charAt(right);
            right++;
            if (window[ss] < need[ss]) {
                count++;
            }
            window[ss]++;


            while (right - left >= s1.length()) {
                if (count == s1.length()) {
                    return true;
                }
                char c = s2.charAt(left);
                left++;
                if (window[c]<=(need[c])) {
                    count--;
                }
                window[c]--;
            }
        }
        return false;
    }
}
