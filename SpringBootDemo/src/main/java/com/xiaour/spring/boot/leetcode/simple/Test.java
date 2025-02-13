package com.xiaour.spring.boot.leetcode.simple;

import java.util.HashSet;

/**
 * @author rtw
 * @since 2025/1/20
 */
public class Test {

    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        int[] ints = new int[]{1,2,3};
        int[] ints1 = new int[]{2,1,3};
        hashSet.add(String.valueOf(ints));
        hashSet.add(String.valueOf(ints1));
   }
}
