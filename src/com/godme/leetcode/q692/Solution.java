package com.godme.leetcode.q692;

import java.util.*;

// 1. 词频统计
// 2. 小根堆统计
// 时间: O(n) 遍历，且无嵌套
// 空间: O(n)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // 词频统计
        Map<String, Integer> count = new HashMap<>();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        // 小顶堆
        PriorityQueue<String> heap = new PriorityQueue<>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2));

        for (String word: count.keySet()) {
            heap.offer(word);
            // 维护堆大小
            if (heap.size() > k) heap.poll();
        }

        // 结果输出
        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
}