package com.godme.leetcode.q450;


class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            if(root.left.right == null) {
                root.left.right = root.right;
                return root.left;
            }
            if(root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            }
            TreeNode parent = root.left, target = root.left.right;
            while(target.right != null){
                parent = target;
                target = target.right;
            }
            if(target.left == null){
                parent.right = null;
            } else {
                parent.right = target.left;
            }
            target.left = root.left;
            target.right = root.right;
            return target;
        }
        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root;
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
