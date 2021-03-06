package com.godme.leetcode.q102;


import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<TreeNode> currentLine = new LinkedList<>();
        List<TreeNode> nextLine = new LinkedList<>(), temp;
        currentLine.add(root);
        List<Integer> line;
        while(!currentLine.isEmpty()){
            nextLine.clear();
            line = new LinkedList<>();
            for(TreeNode node: currentLine){
                line.add(node.val);
                if(node.left != null){
                    nextLine.add(node.left);
                }
                if(node.right != null){
                    nextLine.add(node.right);
                }
            }
            res.add(line);
            temp = currentLine;
            currentLine = nextLine;
            nextLine = temp;
        }
        return res;
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

