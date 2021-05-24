package com.godme.leetcode.q402;

import java.util.Deque;
import java.util.LinkedList;


// 思路: 剔除高位大数，然后检测高位0
// 时间: O(n)
// 空间: O(n)
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int removed = 0;
        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i);
            while(removed < k && !deque.isEmpty() && ch < deque.getLast()){
                    deque.removeLast();
                    removed += 1;
            }
            deque.addLast(ch);
        }
        while(removed < k){
            deque.removeLast();
            removed += 1;
        }
        while (!deque.isEmpty() && deque.getFirst() == '0') deque.removeFirst();
        if(deque.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}
