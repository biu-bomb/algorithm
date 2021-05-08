package com.godme.leetcode.q67;

class Solution {
    public String addBinary(String a, String b) {
        int ai = a.length() - 1, bi = b.length() - 1;
        int bingo = 0, x, y, sum;
        StringBuilder res = new StringBuilder();
        while (ai > -1 || bi > -1 || bingo > 0){
            x = ai > -1 ? a.charAt(ai) - '0' : 0;
            y = bi > -1 ? b.charAt(bi) - '0' : 0;
            sum = x + y + bingo;
            res.append(sum % 2);
            bingo = sum / 2;
            ai -= 1;
            bi -= 1;
        }
        return res.reverse().toString();
    }
}