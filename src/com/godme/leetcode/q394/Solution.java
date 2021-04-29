package com.godme.leetcode.q394;

class Solution {
    public String decodeString(String s) {
        // 无需解析
        int left = s.indexOf('[');
        if (left == -1) {
            return s;
        }
        // 重复部分
        int right = left + 1;
        char currentChar;
        for (int match = 1; match > 0; right++) {
            currentChar = s.charAt(right);
            match += currentChar == '[' ? 1 : currentChar == ']' ? -1 : 0;
        }
        // 重复次数
        int np;
        for (np = left - 1; np > 0 && (currentChar = s.charAt(np-1)) >= '0' && currentChar <= '9'; np--);
        int repeatTimes = Integer.parseInt(s.substring(np, left));
        StringBuilder repeatString = new StringBuilder();
        // 重复
        for (String atomRepeatString = decodeString(s.substring(left+1, right-1)); repeatTimes > 0; repeatTimes--){
            repeatString.append(atomRepeatString);
        }
        // prefix + repeat(decode(?)) + decode(suffix)
        return s.substring(0, np) + repeatString.toString() + decodeString(s.substring(right));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "3[a2[c]]";
        System.err.println(solution.decodeString(s));
    }
}