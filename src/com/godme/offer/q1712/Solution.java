package com.godme.offer.q1712;


import java.util.Deque;
import java.util.HashMap;

class Solution {
    public TreeNode convertBiNode(TreeNode root) {
        TreeNode curr;
        while (root != null){
            if(root.left != null){
                curr = root.left;
                while (curr.right != null && curr.right!=root){
                    curr = curr.right;
                }
                if(curr.right == null){
                   curr.right = root;
                   root = root.left;
                   continue;
                }
            }
            root.left = null;
            root = root.right;
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
