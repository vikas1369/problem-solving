package com.vikas.core.leetcode.linkedlist;

public class ReorderLists {
    public static void main(String[] args){
        ReorderLists reorderLinkedList = new ReorderLists();

        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = new ListNode(6);

        // Reorder the linked list
        reorderLinkedList.reorderList(head);

        // Print the reordered linked list
        reorderLinkedList.printList(head);
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public void reorderList(ListNode head) {
        //Get to the middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow.next;
        //reverse the other half
        ListNode reversedHalf = reverse(middle);
        //printList(reversedHalf);
        slow.next = null;

        //merge two lists
        mergeLists(head, reversedHalf);

    }

    private void mergeLists(ListNode l1, ListNode l2) {
        while(l2 != null){
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;

            l1.next = l2;
            l2.next = temp1;

            l1 = temp1;
            l2 = temp2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
