package com.godme.leetcode.q938;


class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        TreeNode node;
        while (root != null){
            if(root.left != null){
                node = root.left;
                while (node.right != null && node.right != root){
                    node = node.right;
                }
                if(node.right == null){
                    node.right = root;
                    root = root.left;
                    continue;
                }
            }
            if(root.val > high) return sum;
            if(root.val >= low){
                sum += root.val;
            }
            root = root.right;
        }
        return sum;
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
