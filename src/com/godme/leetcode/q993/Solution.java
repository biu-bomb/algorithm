package com.godme.leetcode.q993;


class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || root.val == x || root.val == y) return false;
        Wrapper a = find(root, null, x, 0);
        Wrapper b = find(root, null, y, 0);
        return a.depth == b.depth && a.parent != b.parent;
    }

    public Wrapper find(TreeNode node, TreeNode parent, int val, int depth){
        if(node == null) return null;
        if(node.val == val){
            return new Wrapper(parent, depth);
        }
        Wrapper res = find(node.left, node, val, depth+1);
        if(res == null){
            res = find(node.right, node, val, depth+1);
        }
        return res;
    }

}

class Wrapper{
    TreeNode parent;
    int depth;

    public Wrapper(TreeNode parent, int depth){
        this.parent = parent;
        this.depth = depth;
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
