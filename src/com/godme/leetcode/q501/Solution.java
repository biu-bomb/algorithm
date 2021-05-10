package com.godme.leetcode.q501;


import java.util.HashSet;
import java.util.Set;

class Solution {

    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        connectRight(root);
        root = findMin(root);
        Set<Integer> collect = new HashSet<>();
        int count = 0, maxCount = 0, currentValue = Integer.MAX_VALUE;
        while (root != null){
            if(currentValue == Integer.MAX_VALUE){

            }
        }
        return null;
    }


    public void connectRight(TreeNode root){
        TreeNode cursor;
        while (root != null){
            if(root.left != null){
                cursor = root.left;
                while (cursor.right != null && cursor.right!=root){
                    cursor = cursor.right;
                }
                if(cursor.right == null){
                    cursor.right = root;
                    root = root.left;
                } else {
                    root = root.right;
                }
            } else {
                root = root.right;
            }
        }
    }

    public TreeNode findMin(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
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
