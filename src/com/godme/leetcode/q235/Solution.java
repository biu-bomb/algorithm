package com.godme.leetcode.q235;


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val) return root;
        if(p.val > q.val){
            TreeNode t = p;
            p = q;
            q = t;
        }
        if(root.val > p.val && root.val < q.val) return root;
        if(root.val < p.val) return lowestCommonAncestor(root.right, p, q);
        return lowestCommonAncestor(root.left, p, q);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

