package com.godme.leetcode.q501;


import java.util.*;
class Solution {

    int maxCount = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> counter = new HashMap<>();
        record(counter, root);
        List<Integer> collect = new LinkedList<>();
        counter.forEach((v, c)->{
            if(c == maxCount) collect.add(v);
        });
        int[] res = new int[collect.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = collect.get(i);
        }
        return res;
    }

    public void record(Map<Integer, Integer> counter, TreeNode node){
        if(node == null) return;
        int currentCount = counter.getOrDefault(node.val, 0) + 1;
        maxCount = Math.max(maxCount, currentCount);
        counter.put(node.val, currentCount);
        record(counter, node.left);
        record(counter, node.right);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
