package com.godme.leetcode.q344;

class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while(left < right){
            swap(s, left++, right--);
        }
    }
    void swap(char[]s, int a, int b){
        char t = s[a];
        s[a] = s[b];
        s[b] = t;
    }
}