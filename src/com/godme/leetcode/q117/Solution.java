package com.godme.leetcode.q117;


class Solution {
    Node last = null, nextHead = null;

    public Node connect(Node root) {
        if(root == null) return null;
        Node head = root;
        while(head != null){
            last = null;
            nextHead = null;
            for(Node cursorHead = head; cursorHead != null; cursorHead = cursorHead.next){
                if(cursorHead.left != null){
                    connectLast(cursorHead.left);
                }
                if(cursorHead.right != null){
                    connectLast(cursorHead.right);
                }
            }
            head = nextHead;
        }
        return root;
    }
    public void connectLast(Node node){
        if(last != null){
            last.next = node;
        }
        if(nextHead == null){
            nextHead = node;
        }
        last = node;
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