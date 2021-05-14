package com.godme.leetcode.q230;



public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int order = 1;
        TreeNode prev = null, curr;
        while (root != null){
            if(root.left != null){
                curr = root.left;
                while (curr.right != null && curr.right != root){
                    curr = curr.right;
                }
                if(curr.right == null){
                    curr.right = root;
                    root = root.left;
                    continue;
                }
            }
            if(prev != null && prev.val < root.val){
                order += 1;
            }
            if(order == k){
                return root.val;
            }
            prev = root;
            root = root.right;
        }
        return -1;
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

