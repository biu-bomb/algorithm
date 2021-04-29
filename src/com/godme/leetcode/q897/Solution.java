package com.godme.leetcode.q897;


class Solution {
    public TreeNode increasingBST(TreeNode root) {
        return midOrder(root, null);
    }    public TreeNode midOrder(TreeNode root, TreeNode result){
        if(root == null){
            return result;
        }
        TreeNode treeNode = midOrder(root.right, result);
        return midOrder(root.left, new TreeNode(root.val, null, treeNode));
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
