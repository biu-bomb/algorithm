package com.godme.leetcode.q116;

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        for(Node iter = root, current; iter.left != null; iter = iter.left){
            current = iter;
            while (current != null){
                current.left.next = current.right;
                if(current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
        }
        return root;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}