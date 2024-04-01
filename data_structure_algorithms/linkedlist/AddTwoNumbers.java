package com.vikas.core.leetcode.linkedlist;

import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args){

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;
        while(l1!= null || l2!=null || carry!=0 ){
            int firstDigit = l1!=null ? l1.val : 0;
            int secondDigit = l2!=null ? l2.val : 0;

            int total = firstDigit + secondDigit + carry;

            int val = total % 10;
            carry = total / 10;

            ListNode newNode = new ListNode(val);
            tail.next = newNode;
            tail = tail.next;
        }
        ListNode result = dummyHead.next;
        return result;
    }
}

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
