package com.shulga.algorithms.tc.recursion;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by eugene on 10/4/15.
 */
public class ShuffleLinkedList {
    private static Random random;

    static {
        random = new Random(System.currentTimeMillis());
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        new ShuffleLinkedList().shuffle(list, Integer.MIN_VALUE);
        System.out.println(list);
    }

    private void shuffle(LinkedList<Integer> list, Integer dummy){
        if(list.size()==1) return;
        LinkedList<Integer> list1 = new LinkedList();
        LinkedList<Integer> list2 = new LinkedList();
        while(!list.isEmpty()){
            list1.addLast(list.removeLast());
            if(!list.isEmpty()){
                list2.addLast(list.removeLast());
            }
        }

        shuffle(list1, dummy);
        shuffle(list2, dummy);

        if (list2.size()<list1.size()){
            int i = random.nextInt(list2.size());
            list2.add(i,dummy);
        }
        merge(list, list1, list2, dummy);
    }

    private void merge(LinkedList<Integer> list,LinkedList<Integer> list1,LinkedList<Integer> list2, Integer dummy){
        while(list1.size()!=0 && list2.size()!=0){
            int random = (int)(Math.random()*2);
            if(random==0){
                list.addLast(list1.removeLast());
            }else{
                list.addLast(list2.removeLast());
            }
            while(!list1.isEmpty()){
                list.addLast(list1.removeLast());
            }
            while(!list2.isEmpty()){
                list.addLast(list2.removeLast());
            }
            list.remove(dummy);
        }
    }
}
