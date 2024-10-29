package com.xiaour.spring.boot.leetcode.simple.array;

import java.util.HashMap;
import java.util.Random;

/**
 * @author rtw
 * @since 2024/10/28
 */
public class Blacklist {
    int sz;
    int[] array;

    public static void main(String[] args) {
        Blacklist blacklist = new Blacklist(7,new int[]{2,3,5});
        System.out.println(blacklist.pick());
        System.out.println(blacklist.pick());
        System.out.println(blacklist.pick());
        System.out.println(blacklist.pick());
        System.out.println("SUCCESS");
    }

    public Blacklist(int n, int[] blacklist) {
        array = new int[n];
        sz = n - blacklist.length;
        HashMap map = new HashMap<>();
        for (int i : blacklist) {
            map.put(i, null);
        }
        // 将 [0,sz)中黑名单的数据的 value作为[sz,n)的下标
        int last = n - 1;
        for (int i = 0;i<sz;i++) {
            if (map.containsKey(i)) {
                // 黑了
                while (map.containsKey(last)) {
                    last--;
                }
                array[i] = last;
                last--;
            } else {
                continue;
            }
        }
    }


    public int pick() {
        int random =new Random().nextInt(sz);
        if (array[random]!=0){
            return array[random];
        } else {
            return random;
        }
    }


}
