package com.xiaour.spring.boot.leetcode.simple.array;

import com.alibaba.fastjson.JSON;

/**
 * 区间加法
 * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。
 * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
 * 请你返回 k 次操作后的数组。
 *
 * @author rtw
 * @since 2024/10/24
 */
public class ModifiedArray {
    int[] modified ;

    public static void main(String[] args) {
        int[] array = new int[]{2,1,3,4};
        ModifiedArray modifiedArray = new ModifiedArray();
        modifiedArray.init(array);
        modifiedArray.increment(1,2,2);
        System.out.println(JSON.toJSONString(modifiedArray.result()));
        System.out.println("SUCCESS");
    }
    /**·
     * 普通数组转化为差分数组
     * @param array
     */
    public void init(int[] array){
        modified = new int[array.length];
        modified[0] = array[0];
        for (int i =1;i<array.length;i++) {
            modified[i] = array[i] - array[i-1];
        }
    }


    /**
     * [i,j]增加 val数值
     */
    public void increment(int i , int j , int val){
        modified[i] = modified[i] + val;
        if ((j+1)<modified.length) {
            modified[j+1] = modified[j+1] - val;
        }
    }


    /**
     * 差分数组恢复为原数组
     */
    public int[] result(){
        int[] re = new int[modified.length];
        re[0] = modified[0];

        for (int i = 1; i < modified.length; i++) {
            re[i] =  re[i-1] + modified[i];
        }
        return re;
    }
}
