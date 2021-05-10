package com.godme.leetcode.q437;


class Solution {

    int single = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        single = 0;
        series(root, targetSum);
        int res = single;
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    public void series(TreeNode root, int targetSum){
        if(root == null) return ;
        targetSum -= root.val;
        if(targetSum == 0){
            single += 1;
        }
        series(root.left, targetSum);
        series(root.right, targetSum);
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
