package com.godme.offer.q35;


import java.util.HashMap;

class Solution {

    HashMap<Node, Node> cache = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(cache.containsKey(head)){
            return cache.get(head);
        }
        Node node = new Node(head.val);
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
