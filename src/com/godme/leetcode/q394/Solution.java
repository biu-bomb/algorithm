package com.godme.leetcode.q394;

// 思路: prefix + substring + suffix;
//      prefix: 简单字符串
//      substring: 需要解码的子串
//      suffix: 后续字符串
// 时间: O(n)
// 空间: O(s)
class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        // suffix
        int repeatIndex = 0, length = s.length();
        while(repeatIndex < length && !Character.isDigit(s.charAt(repeatIndex))) repeatIndex++;
        if(repeatIndex >= length) return s;
        // append prefix
        sb.append(s, 0, repeatIndex);
        int repeatTimes = 0;
        int subBegin = repeatIndex;
        // repeat times
        while(s.charAt(subBegin) != '['){
            repeatTimes = repeatTimes * 10 + s.charAt(subBegin) - '0';
            subBegin += 1;
        }
        // substring
        int count = 1, subEnd = subBegin + 1;
        while (count > 0){
            if(s.charAt(subEnd) == '['){
                count += 1;
            } else if(s.charAt(subEnd) == ']'){
                count -= 1;
            }
            subEnd += 1;
        }
        // append repeat string
        String repeatString = s.substring(subBegin+1, subEnd-1); // normal substring
        repeatString = decodeString(repeatString); // decode
        for(int i = 0; i < repeatTimes; i++){ // repeat
            sb.append(repeatString);
        }
        // suffix
        if(subEnd < length){
            String suffix = s.substring(subEnd); // suffix
            suffix = decodeString(suffix); // decode
            sb.append(suffix);
        }
        return sb.toString();
    }
}