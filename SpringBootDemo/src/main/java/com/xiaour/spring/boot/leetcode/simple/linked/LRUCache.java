package com.xiaour.spring.boot.leetcode.simple.linked;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * 146 LRU 缓存
 * @author rtw
 * @since 2024/10/28
 */
public class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key))
        {
            return -1;
        }

        //存在，先从链表头部删除删除，在插入到链表尾部
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);

        return val;
    }

    public void put(int key, int val) {
        if(cache.containsKey(key))
        {
            cache.remove(key);
        }

        //如果链表已经满了，则删除头部节点
        if(cache.size() == capacity)
        {
            // 拿到 Key 的 set,删除其第一个
            Set<Integer> keySet = cache.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            cache.remove(iterator.next());
        }

        cache.put(key, val);
    }
}
