package com.godme.leetcode.q236;


class Solution {
    /**
     * 漏洞：
     *  1. 一定存在公共祖先
     *  2. 节点一定不重复
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 遍历到叶子结点，没发现
        if(root == null) return null;
        // 自身为祖先，直接返回: 如果包含另一个，自动屏蔽另一个分支，根据对立分支结果判断是否包含
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode leftCommon = lowestCommonAncestor(root.left, p, q);
        TreeNode rightCommon = lowestCommonAncestor(root.right, p, q);
        // 一端不存在，只能是另一端
        if(leftCommon == null){
            return rightCommon;
        }
        // 两端分散就只能是当前节点
        return rightCommon == null ? leftCommon : root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
