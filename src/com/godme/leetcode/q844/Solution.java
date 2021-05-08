package com.godme.leetcode.q844;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        // 1. 前向指针，删除键后面的肯定没被删除，减少变量
        int si = s.length() -1, ti = t.length() -1;
        // 2. 删除计数，存在连续删除，需要计数
        int sd = 0, td = 0;
        while(si > -1 || ti > -1){
            // 如果是删除键或者补删除，都需要向前删除
            while(si > -1 && (s.charAt(si) == '#' || sd > 0)){
                // 删除累计还是删除执行
                sd += s.charAt(si) == '#' ? 1 : -1;
                si -= 1;
            }
            while (ti > -1 && (t.charAt(ti) == '#' || td > 0)){
                td += t.charAt(ti) == '#' ? 1 : -1;
                ti -= 1;
            }
            // 是否同时到达起点，不是说明某一方有剩余
            if(si < 0 || ti < 0) return si == ti;
            // 非起点，字符串是否相等
            if(s.charAt(si) != t.charAt(ti))  return false;
            // 相等，判断前一个
            si -= 1;
            ti -= 1;
        }
        return true;
    }
}