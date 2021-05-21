package com.godme.leetcode.q385;


import java.util.LinkedList;
import java.util.List;


// 思路: 递归解析 1. 纯数字 2. 嵌套数组 3. 空数组
// 时间: O(n)
// 空间: O(n*single)
class Solution {
    public NestedInteger deserialize(String s) {
        // 纯数字
        if(!s.startsWith("[")){
            return new NestedInteger(Integer.parseInt(s));
        }
        NestedInteger nestedInteger = new NestedInteger();
        // 空数组
        if(s.length() == 2) return nestedInteger;
        s = s.substring(1, s.length()-1);
        int index = 0, count = 0, start = 0;
        s += ",";
        while(index < s.length()){
            char ch = s.charAt(index);
            if(ch == '['){
                count += 1;
            } else if(ch == ']'){
                count -= 1;
            } else if(ch == ',' && count == 0){ // 子串
                nestedInteger.add(deserialize(s.substring(start, index)));
                start = index + 1;
            }
            index += 1;
        }
        return nestedInteger;
    }
}

class NestedInteger{

    Integer value;
    List<NestedInteger> list = new LinkedList<>();

    NestedInteger(int value){
        setInteger(value);
    }

    NestedInteger(){
    }
    public boolean isInteger() {
        return value != null;
    }

    public Integer getInteger() {
        return value;
    }

    public void setInteger(int value) {
        this.value = value;
    }

    public void add(NestedInteger ni) {
        list.add(ni);
    }

    public List<NestedInteger> getList() {
        return list;
    }
}