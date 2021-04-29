package com.godme.leetcode.q138;


import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Node, Node> cache = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        if(cache.containsKey(head)){
            return cache.get(head);
        }
        Node node = new Node(head.val);
        // 先缓存，防止循环引用找不到
        cache.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}



