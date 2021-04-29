package com.godme.leetcode.q112;


class Solution {
    // 叶子节点并且作差为0
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        int residue = targetSum - root.val;
        if(root.left == root.right){
            return residue == 0;
        }
        return hasPathSum(root.left, residue) || hasPathSum(root.right,residue);
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

