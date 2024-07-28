package com.xiaour.spring.boot.leetcode.simple.characterstr;

/**
 * 回文
 *
 * @author rtw
 * @since 2024/6/21
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(StrStr.solution("abcccccr", "r"));
    }

    /**
     *
     */
    public static int solution(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int needleSize = needle.length();
        for (int i = 0; i + needleSize <= haystack.length(); i++) {
            String haySub = haystack.substring(i, i + needleSize);
            if (haySub.equals(needle)) {
                return i;
            }
        }
        return -1;
    }


}
