package com.godme.leetcode.q242;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.equals(t)) return true;
        int[] counter = new int[255];
        for(int i = 0; i < s.length();i ++){
            counter[s.charAt(i)] += 1;
        }
        for(int i = 0; i < t.length(); i++){
            if(counter[t.charAt(i)] == 0) return false;
            counter[t.charAt(i)] -= 1;
        }
        for(int i: counter){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
