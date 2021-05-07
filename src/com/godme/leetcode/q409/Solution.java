package com.godme.leetcode.q409;


class Solution {
    public int longestPalindrome(String s) {
        int[] cache = new int[123];
        int single = 0, length = s.length();
        for(int index = 0; index < length; index++){
            cache[s.charAt(index)] += 1;
        }
        for(int count: cache){
            single += (count & 1);
        }
        return s.length() - single + Math.min(single, 1);
    }

    public static void main(String[] args) {
        System.err.println(new Solution().longestPalindrome("abccccdd"));
    }
}
