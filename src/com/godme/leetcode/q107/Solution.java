package com.godme.leetcode.q107;


import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        List<TreeNode> currentLine = new LinkedList<>();
        List<TreeNode> nextLine = new LinkedList<>(), temp;
        List<Integer> values;
        currentLine.add(root);
        while (!currentLine.isEmpty()){
            nextLine.clear();
            values = new LinkedList<>();
            for(TreeNode node: currentLine){
                values.add(node.val);
                if(node.left != null){
                    nextLine.add(node.left);
                }
                if(node.right != null){
                    nextLine.add(node.right);
                }
            }
            res.addFirst(values);
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

