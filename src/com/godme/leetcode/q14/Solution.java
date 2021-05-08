package com.godme.leetcode.q14;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        int left = 0, right = Integer.MAX_VALUE;
        for(String str: strs){
            right = Math.min(right, str.length());
        }
        if(isCommonPrefix(strs, right)) return strs[0].substring(0, right);

        while(isCommonPrefix(strs, left)){
            int mid = left + (right - left) / 2;
            if(isCommonPrefix(strs, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return strs[0].substring(0, left - 1);
    }



    public boolean isCommonPrefix(String[] strs, int index){
        String prefix = strs[0].substring(0, index);
        for(String str: strs){
            if(!str.startsWith(prefix)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[]{"flower","flow","flight"};
        System.err.println(solution.longestCommonPrefix(strs));
    }
}