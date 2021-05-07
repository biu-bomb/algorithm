package com.godme.leetcode.q103;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


class Solution {
    // 翻转:
    //  1. 节点翻转: 费时费力，需要连续饭庄
    //  2. 结果翻转: 一次性独立操作
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        values(res, Collections.singletonList(root), true);
        return res;
    }

    public void values(List<List<Integer>> res, List<TreeNode> nodes, boolean asc){
        if(nodes.isEmpty()) return;
        List<TreeNode> next = new ArrayList<>();
        LinkedList<Integer> currentRes = new LinkedList<>();
        for(TreeNode node: nodes){
            if(asc){
                currentRes.add(node.val);
            } else {
                currentRes.addFirst(node.val);
            }
            if(node.left  != null){
                next.add(node.left);
            }
            if(node.right != null){
                next.add(node.right);
            }
        }
        res.add(currentRes);
        values(res, next, !asc);
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
