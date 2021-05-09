package com.godme.leetcode.q99;

class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode a = null, b = null, prev = null, last = null;
        while(root != null){
            if(root.left != null){
                last = root.left;
                while(last.right != null || last.right != root){
                    last = last.right;
                }
                if(last.right == null){
                    last.right = root;
                    root = root.left;
                } else {
                    if(prev != null && prev.val > root.val){
                        b = root;
                        a = a == null?prev:a;
                    }
                    prev = root;
                    root = root.right;
                }
            } else {
                if(prev != null && prev.val > root.val){
                    b = root;
                    a = a == null?prev:a;
                }
                prev = root;
                root = root.right;
            }
        }
        swap(a, b);
    }
    public void swap(TreeNode a, TreeNode b) {
        int t = a.val;
        a.val = b.val;
        b.val = t;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
