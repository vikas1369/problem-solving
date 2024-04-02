package com.vikas.core.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomNumber {
    public static void main(String[] args){

    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node current = head;
        while(current!=null){
            Node copy = new Node(current.val);
            map.put(current, copy);
            current = current.next;
        }

        current = head;
        while(current!=null){
            Node copy = map.get(current);
            copy.next = map.get(current.next);
            copy.random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
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
