package com.shulga.algorithms.linkedlist;

/**
 * Created by eshulga on 6/20/16.
 */
public class OverlappingLists {
    static class ListNode{
        ListNode(int data){
            this.data=data;
        }
        ListNode next;
        int data;
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);

        ListNode node1 = new ListNode(-5);
        node1.next = new ListNode(-1);
        node1.next.next = new ListNode(-2);
        node1.next.next.next = listNode;

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(4);
        node2.next.next = listNode;
        node2.next.next.next = new ListNode(7);
        node2.next.next.next.next = new ListNode(9);
        node2.next.next.next.next = new ListNode(11);

        System.out.println(new OverlappingLists().run(node1,node2).data);
    }

    private ListNode run(ListNode node1, ListNode node2) {
        if(node1==null || node2==null) return null;
        int node1Count = 0;
        int node2Count = 0;
        ListNode node1Current=node1;
        ListNode node2Current=node2;
        while(node1Current.next!=null || node2Current.next!=null){
            if(node1Current.next!=null) {
                node1Current = node1Current.next;
                node1Count++;
            }
            if(node2Current.next!=null) {
                node2Current = node2Current.next;
                node2Count++;
            }
        }
        if(node1Current!=node2Current) return null;
        node1Count++;
        node2Count++;
        ListNode bigger;
        ListNode smaller;
        if(node1Count>node2Count){
            bigger=node1;
            smaller = node2;
        }else{
            bigger = node2;
            smaller = node1;
        }
        int offset =  Math.max(node1Count,node2Count) - Math.min(node1Count,node2Count);
        int counter = 0;
        while(bigger!=null){
            bigger = bigger.next;
            if(counter<offset) {
                counter++;
            }else{
                smaller = smaller.next;
            }
            if(bigger==smaller) return bigger;
        }
        return null;
    }
}
