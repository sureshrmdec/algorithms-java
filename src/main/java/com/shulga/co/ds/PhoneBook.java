package com.shulga.co.ds;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * Created by eugene on 6/15/16.
 */
public class PhoneBook {
    Node[] hashMap = new Node[1000];
    Set<Integer> codes = new HashSet<>();
    Set<Integer> codesRaw = new HashSet<>();

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        Random r = new Random();
        for (int i = 0; i < 200000; i++) {
            int number = r.nextInt(9999999);
//            System.out.println(number);
            pb.insert(number, number + "");
        }
        int counter = 0;
        for (int i = 0; i < pb.hashMap.length; i++) {
            if (pb.hashMap[i] == null || pb.hashMap[i].next != null) {
                counter++;
            }
        }
        System.out.println(pb.codes.size());
        System.out.println(pb.codesRaw.size());
        Iterator<Integer> iteratorCodes = pb.codes.iterator();
        Iterator<Integer> iteratorCodesRaw = pb.codesRaw.iterator();
//        for (int i = 0; i < 10 && iteratorCodes.hasNext(); i++) {
//            System.out.println(iteratorCodes.next());
//        }
//        System.out.println();
//        for (int i = 0; i < 10 && iteratorCodesRaw.hasNext(); i++) {
//            System.out.println(iteratorCodesRaw.next());
//        }
    }

    public String find(Integer number) {
        Node node = findNode(number);
        return node == null ? null : node.value;
    }

    private Node findNode(Integer number) {
        int hash = hashCode(number);
        Node node = hashMap[hash];
        while (node != null) {
            if (node.key.equals(number)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public boolean contains(Integer key) {
        return find(key) != null;
    }

    public boolean remove(Integer number) {
        int hash = hashCode(number);
        Node node = hashMap[hash];
        Node previous = null;
        while (node != null) {
            if (node.key.equals(number)) {
                previous.next = node.next;
                return true;
            }
            previous = node;
            node = node.next;
        }
        return false;
    }

    public void insert(Integer number, String name) {
        System.out.println(number);
        Node find = findNode(number);
        if (find != null) {
            find.value = name;
            return;
        }
        int hash = hashCode(number);
        codes.add(hash);
        Node node = hashMap[hash];
        Node newNode = new Node();
        newNode.value = name;
        newNode.next = node;
    }

    public int hashCode(int num) {
        int original = (31 * num + 2) % 1000018;
        int code = original;
        codesRaw.add(code);
        return code % 1000;
    }

    public int hashCode(String str) {
        int hash = 0;
        for (int i = str.length() - 1; i <= 0; i--) {
            hash = (hash + 31 * str.charAt(i));
        }
        return hash % 1000;
    }

    class Node {
        Node next;
        Integer key;
        String value;
    }
}
