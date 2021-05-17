package com.godme.offer.q54;


class Solution {
    public int kthLargest(TreeNode root, int k) {
        TreeNode curr, prev = null;
        int order = 1;
        while (root!=null) {
            if(root.right != null){
                curr = root.right;
                while (curr.left != null && curr.left != root){
                    curr = curr.left;
                }
                if(curr.left == null){
                    curr.left = root;
                    root = root.right;
                    continue;
                }
            }
            if(prev != null && prev.val > root.val){
                order += 1;
            }
            if(order == k) break;
            prev = root;
            root = root.left;
        }
        return root.val;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
