package com.godme.leetcode.q889;


class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return buildTree(pre, post, 0, pre.length-1, 0, post.length-1);
    }

    public TreeNode buildTree(int[] pre, int[] post, int preLeft, int preRight, int postLeft, int postRight){
        if(preLeft > preRight || postLeft > postRight) return null;
        TreeNode node = new TreeNode(pre[preLeft]);
        if(preLeft == preRight){
            return node;
        }
        int postNextRootIndex = postLeft;
        while (postNextRootIndex < postRight){
            if(post[postNextRootIndex] == pre[preLeft+1])
                break;
            postNextRootIndex += 1;
        }
        int leftLength = postNextRootIndex - postLeft;
        node.left = buildTree(pre, post, preLeft+1, preLeft+leftLength+1, postLeft, postLeft+leftLength);
        node.right = buildTree(pre, post, preLeft+leftLength+2, preRight, postLeft+leftLength+1, postRight-1);
        return node;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
