package com.godme.leetcode.q538;

class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        sumAll(root);
        setAll(root);
        return root;
    }

    public void sumAll(TreeNode root){
        if(root == null) return ;
        sumAll(root.left);
        sum += root.val;
        sumAll(root.right);
    }

    public void setAll(TreeNode root){
        if(root == null) return;
        setAll(root.left);
        int value = root.val;
        root.val = sum;
        sum -= value;
        setAll(root.right);
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
