package com.godme.leetcode.q106;


import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<Integer, Integer> inorderIndexMap;
    int[] inorder;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        inorderIndexMap = new HashMap<>();
        for(int index = 0; index < inorder.length; index++){
            inorderIndexMap.put(inorder[index], index);
        }
        return buildTree(0, inorder.length -1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int inorderLeft, int inorderRight, int postOrderLeft, int postOrderRight){
        if(inorderLeft > inorderRight || postOrderLeft > postOrderRight) return null;
        int rootValue = postorder[postOrderRight];
        int inorderRootIndex = inorderIndexMap.get(rootValue);
        int leftMembersCount = inorderRootIndex - inorderLeft;
        TreeNode treeNode = new TreeNode(rootValue);
        treeNode.left = buildTree(inorderLeft, inorderRootIndex-1, postOrderLeft, postOrderLeft+leftMembersCount-1);
        treeNode.right = buildTree(inorderRootIndex+1, inorderRight, postOrderLeft+leftMembersCount, postOrderRight-1);
        return treeNode;
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
