package com.godme.leetcode.q814;


import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<TreeNode> set = new HashSet<>();
    public TreeNode pruneTree(TreeNode root) {
        if(allZero(root)) return null;
        root.left = allZero(root.left) ? null : pruneTree(root.left);
        root.right = allZero(root.right) ? null : pruneTree(root.right);
        return root;
    }

    public boolean allZero(TreeNode root){
        if(root == null) return true;
        if(set.contains(root)) return true;
        if(root.val == 1) return false;
        boolean bingo = allZero(root.left) && allZero(root.right);
        if(bingo){
            set.add(root);
        }
        return bingo;
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
