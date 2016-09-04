package com.shulga.algorithms.linkedlist;

/**
 * Created by eshulga on 6/20/16.
 */
public class PalindromicSingleList {
    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(7);
        node.next.next.next.next = new ListNode(9);
        node.next.next.next.next = new ListNode(11);
        System.out.println(new PalindromicSingleList().run2(node));

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(4);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(3);
        node2.next.next.next.next = new ListNode(4);
        node2.next.next.next.next.next = new ListNode(2);
        System.out.println(new PalindromicSingleList().run2(node2));
    }

    private boolean run(ListNode node) {
        int length = 0;
        ListNode current = node;
        while (current != null) {
            length++;
            current = current.next;
        }
        int mid = length / 2;
        current = node;
        ListNode previous = null;
        int counter = 0;
        while (current != null) {
            if (counter < mid) {
                counter++;
                previous = current;
                current = current.next;
            } else {
                ListNode temp = current.next;
                current.next = previous;
                previous = current;
                current = temp;
            }
        }
        ListNode end = previous;
        ListNode start = node;
        counter = 0;
        while (counter < mid) {
            if (end.data != start.data) return false;
            start = start.next;
            end = end.next;
            counter++;
        }
        return true;
    }

    static class ListNode {
        ListNode next;
        int data;

        ListNode(int data) {
            this.data = data;
        }
    }

    private boolean run2(ListNode node) {
        ListNode current = node;
        int length=0;
        while(current!=null){
            length++;
            current = current.next;
        }
        int mid = length/2;
        int counter =0;
        current = node;
        ListNode previous = null;
        while(current!=null){
            if(counter==mid) break;
            counter++;
            ListNode newCurrent = current.next;
            current.next=previous;
            previous = current;
            current = newCurrent;
        }
        while(current!=null){
            if(current.data!=previous.data){
                return false;
            }
            current = current.next;
            previous = previous.next;
        }
        return true;
    }

























}
