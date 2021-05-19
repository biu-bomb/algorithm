package com.godme.leetcode.q1353;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
// 盲点: 没说一定要开始到结束，只是说每天只能一场
// 思路:
//      1. 今天能开的哪些
//      2. 优先提前结束的
// 时间:
// 空间: O(n)
class Solution {
    public int maxEvents(int[][] events) {
        // 按照开始时间排序
        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
        // 维护结束时间排序
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0, last = 1, i = 0, n = events.length;
        while (i < n || !pq.isEmpty()) {
            // 今天开始的会议入栈
            while (i < n && events[i][0] == last) {
                pq.offer(events[i++][1]);
            }
            // 今天结束的会议出栈
            while (!pq.isEmpty() && pq.peek() < last) {
                pq.poll();
            }
            // 有会议可以开，+1
            if (!pq.isEmpty()) {
                // 先把先结束的会议开了，然后移除
                pq.poll();
                res++;
            }
            last++;
        }
        return res;
    }
}
