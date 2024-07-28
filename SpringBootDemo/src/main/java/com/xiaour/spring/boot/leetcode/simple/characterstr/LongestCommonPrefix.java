package com.xiaour.spring.boot.leetcode.simple.characterstr;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最长公共前缀
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnmav1/
 *
 * @author rtw
 * @since 2024/7/27
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
       String[] a= {"flower","flow","flight"};
        String s = LongestCommonPrefix.longestCommonPrefix(a);
        System.out.println(s);
    }


    /**
     * 通过Map的方式管理每一个字符串的第 N 位的数字是否重复
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        Map<Integer, HashMap<String, Integer>> map = new HashMap<>();
        Integer minSize = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                HashMap<String, Integer> stringIntegerHashMap = map.get(j);
                if (stringIntegerHashMap == null) {
                    stringIntegerHashMap = new HashMap<>();
                }
                Integer integer = stringIntegerHashMap.get(String.valueOf(str.charAt(j)));
                stringIntegerHashMap.put(String.valueOf(str.charAt(j)), integer == null ? 0 : ++integer);
                map.put(j, stringIntegerHashMap);
            }
            minSize = Math.min(minSize, str.length());
        }
        // 处理 Map
        String prefix = "";
        for (int i = 0; i < minSize; i++) {
            HashMap<String, Integer> stringIntegerHashMap = map.get(i);
            if (stringIntegerHashMap.keySet().size() == 1) {
                // 有前缀
                prefix += stringIntegerHashMap.keySet().stream().findFirst().get();
            } else {
                break;
            }
        }
        return prefix;
    }
}
