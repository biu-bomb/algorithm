package com.godme.leetcode.q9;

class Solution {
    public boolean isPalindrome(int x) {
        if( x < 0) return false;
        int mirror = 0;
        while(mirror < x){
            mirror = mirror * 10 + x % 10;
            x = x / 10;
        }
        return mirror == x || mirror / 10 == x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.isPalindrome(121));
    }
}