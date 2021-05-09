package com.godme.leetcode.q199;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    Deque<TreeNode> currentLine = new LinkedList<>();
    Deque<TreeNode> nextLine = new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        currentLine.add(root);
        while (!currentLine.isEmpty()){
            root = currentLine.getLast();
            res.add(root.val);
            swap();
        }
        return res;
    }

    public void swap(){
        TreeNode node;
        Deque<TreeNode> temp;
        nextLine.clear();
        while(!currentLine.isEmpty()){
            node = currentLine.pop();
            if(node.left != null){
                nextLine.add(node.left);
            }
            if(node.right != null){
                nextLine.add(node.right);
            }
        }
        temp = currentLine;
        currentLine = nextLine;
        nextLine = temp;
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

