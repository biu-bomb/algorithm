package com.godme.leetcode.q3;

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length < 2){
            return length;
        }
        HashSet<Character> uniqCharacter = new HashSet<>();
        int maxLength = 0, left = 0, right = 0;
        char ch = s.charAt(0);
        while(left < length){
            // 只要不重复，一直往下加
            while(right < length && !uniqCharacter.contains((ch = s.charAt(right)))){
                uniqCharacter.add(ch);
                right += 1;
            }
            // 最大不重复字符串
            maxLength = Math.max(maxLength, uniqCharacter.size());
            // 顺序去除，直到不重复
            while (left < length && uniqCharacter.contains(ch)){
                uniqCharacter.remove(s.charAt(left));
                left += 1;
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "dvdf";
        System.err.println(solution.lengthOfLongestSubstring(s));
    }
}