package com.vikas.core.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    public static  void main(String[] args){
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        Node current = cache.head;
        while(current!=null){
            System.out.println("Node val"+current.value);
            current = current.next;
        }
        System.out.println("Tail prev"+cache.tail.prev);
        System.out.println("Tail prev key"+cache.tail.prev.key);
        cache.put(3,3);
        System.out.println(cache.get(2));
    }
    class Node{
        Integer key;
        Integer value;
        Node next;
        Node prev;

        Node(Integer key, Integer value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    Map<Integer, Node> cache;
    int capacity;
    Node head;
    Node tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public void addToHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void removeNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            //if present
            Node node = cache.get(key);
            int value = node.value;
            removeNode(node);
            addToHead(node);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            removeNode(node);
        }else if (cache.size() == capacity){
            //evict least recently used entry
            cache.remove(tail.prev.key);
            removeNode(tail.prev);
        }

        Node newNode = new Node(key, value);
        addToHead(newNode);
        cache.put(key, newNode);
    }
}
