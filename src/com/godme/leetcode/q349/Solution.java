package com.godme.leetcode.q349;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new LinkedList<>();
        Set<Integer> store = new HashSet<>();
        for(int num: nums1){
            store.add(num);
        }
        for(int num: nums2){
            if(store.contains(num)){
                res.add(num);
                store.remove(num);
            }
        }
        int[] ans = new int[res.size()];
        for(int index = 0; index < ans.length; index++){
            ans[index] = res.get(index);
        }
        return ans;
    }
}