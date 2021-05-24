package com.godme.leetcode.q451;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 思路: 计数+小顶堆
// 时间: O(n)
// 空间: O(n)
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> characters = new PriorityQueue<>((c1, c2)-> counter.get(c2) - counter.get(c1));
        for(Character ch: counter.keySet()){
            characters.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!characters.isEmpty()){
            char ch = characters.poll();
            for(int i = 0; i < counter.get(ch); i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
