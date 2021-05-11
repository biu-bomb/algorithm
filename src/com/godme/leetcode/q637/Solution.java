package com.godme.leetcode.q637;


import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        List<TreeNode> currentLine = new LinkedList<>();
        currentLine.add(root);
        List<TreeNode> nextLine = new LinkedList<>(), temp;
        double sum = 0;
        while(!currentLine.isEmpty()){
            nextLine.clear();
            sum = 0;
            for(TreeNode node: currentLine){
                sum += node.val;
                if(node.left != null){
                    nextLine.add(node.left);
                }
                if(node.right != null){
                    nextLine.add(node.right);
                }
            }
            res.add(sum / currentLine.size());
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
