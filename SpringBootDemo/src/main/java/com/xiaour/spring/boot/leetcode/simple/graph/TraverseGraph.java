package com.xiaour.spring.boot.leetcode.simple.graph;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.core.Link;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/all-paths-from-source-to-target/description/
 * 遍历所有的路径
 * @author rtw
 * @since 2024/12/14
 */
public class TraverseGraph {

    public static void main(String[] args) {
        String s = new String("12");
        int[][] graph = {
                {1,2},{3},{3},{}
        };
        TraverseGraph graph1 = new TraverseGraph();
        List<List<Integer>> lists = graph1.allPathsSourceTarget(graph, 0, new LinkedList<>());
        System.out.println(JSON.toJSONString(graph1.allPath));
    }

    List<List<Integer>> allPath = new LinkedList<>();

    /**
     *
     * @param graph 邻接表
     * @param s 节点
     * @param path 当前的路径
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph, int s, List<Integer> path) {
        // 当前路径加入 S
        path.add(s);

        // 判断路径是否已经到结尾
        if (s == graph.length-1) {
            // 需要重新生成一个 LinkedList
            allPath.add(new LinkedList(path));
            path.remove(path.size() - 1);
            return allPath;
        }


        for (int i : graph[s]) {
            allPathsSourceTarget(graph, i, path);
        }

        // 删除路径
        path.remove(path.size() - 1);
        return allPath;
    }

}
