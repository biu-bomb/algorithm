package com.godme.leetcode.q125;

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while(left <= right){
            while(left <= right && !isValid(s.charAt(left))) left++;
            while (left <= right && !isValid(s.charAt(right))) right--;
            if(left <= right && !eq(s.charAt(left++), s.charAt(right--))){
                return false;
            }
        }
        return true;
    }
    public boolean isValid(char ch){
        return (ch < 123 && ch > 96) || // a-z
                (ch > 64 && ch < 91) || // A-Z
                (ch > 47 && ch < 58);   // 0-9
    }
    public boolean eq(char a, char b){
        return a == b || Math.abs(a - b) == 32;
    }
}