package com.xiaour.spring.boot.leetcode.simple.characterstr;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn96us/
 * 有效的字母 异位词
 *
 * @author rtw
 * @since 2024/6/21
 */
public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(IsAnagram.isAnagramV2("s/art", "//arst"));
    }

    /**
     * 方法1:
     * HashMap的判断逻辑
     * 最优解是第一步判断长度是否一致，不一致直接返回 false
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            Integer frequency = map.get(String.valueOf(temp));
            map.put(String.valueOf(temp), frequency == null ? 1 : ++frequency);
        }

        for (int i = 0; i < t.length(); i++) {
            char temp = t.charAt(i);
            Integer frequency = map.get(String.valueOf(temp));
            if (frequency == null || frequency <= 0) {
                return false;
            }

            if (frequency == 1) {
                map.remove(String.valueOf(temp));
                continue;
            }
            map.put(String.valueOf(temp), --frequency);
        }
        return map.keySet().size() == 0;
    }


    /**
     * 方法2:
     * 排序
     * @return
     */
    public static boolean isAnagramV2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] char1= s.toCharArray();
        char[] char2= t.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);


        return Arrays.equals(char1,char2);
    }


}
