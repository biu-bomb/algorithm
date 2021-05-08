package com.godme.leetcode.q589;


import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        res.add(root.val);
        for(Node child: root.children){
            res.addAll(preorder(child));
        }
        return res;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}