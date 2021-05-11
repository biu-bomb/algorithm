package com.godme.leetcode.q590;


import java.util.LinkedList;
import java.util.List;


class Solution {

    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res =new LinkedList<>();
        if(root == null) return res;
        if(root.children != null){
            for(Node node : root.children){
                res.addAll(postorder(node));
            }
        }
        res.add(root.val);
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

