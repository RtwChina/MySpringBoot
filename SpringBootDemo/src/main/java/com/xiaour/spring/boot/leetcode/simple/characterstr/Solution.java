package com.xiaour.spring.boot.leetcode.simple.characterstr;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 回文
 *
 * @author rtw
 * @since 2024/6/21
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Solution.solution(" "));
    }

    /**
     *
     */
    public static boolean solution(String t) {
        char[] chars = t.toCharArray();
        if (chars.length <= 1) {
            return true;
        }
        int begin = 0;
        int end = chars.length - 1;
        do {
            // 非数字或字母的跳过
            if (!Character.isLetterOrDigit(chars[begin])) {
                begin++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[end])) {
                end--;
                continue;
            }


            if (!String.valueOf(chars[begin]).toLowerCase().equals(String.valueOf(chars[end]).toLowerCase())) {
                return false;
            }
            begin++;
            end--;

        } while (begin < end);
        return true;
    }



}
