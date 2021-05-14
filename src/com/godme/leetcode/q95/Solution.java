package com.godme.leetcode.q95;


import java.util.LinkedList;
import java.util.List;

class Solution {
    // 二叉树： left < root < right
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> res = new LinkedList<>();
        if(start > end){
            res.add(null);
            return res;
        }

        for(int i = start; i <= end; i++){
            for(TreeNode left: generateTrees(start, i-1)){
                for(TreeNode right: generateTrees(i+1, end)){
                    res.add(new TreeNode(i, left, right));
                }
            }

        }
        return res;
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

