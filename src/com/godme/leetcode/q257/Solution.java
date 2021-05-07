package com.godme.leetcode.q257;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        if(root == null) return paths;
        binaryTreePaths(paths, "", root);
        return paths;
    }

    public void binaryTreePaths(List<String> paths, String originPath, TreeNode node){
        if(node == null) return;
        originPath += ("".equals(originPath) ? "" : "->") + node.val;
        if(node.left == null && node.right == null){
            paths.add(originPath);
            return;
        }
        binaryTreePaths(paths, originPath, node.left);
        binaryTreePaths(paths, originPath, node.right);
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
