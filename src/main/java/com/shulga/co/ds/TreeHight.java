package com.shulga.co.ds;

/**
 * Created by eshulga on 6/1/16.
 */
public class TreeHight {

    class Node{
        Node(int data){
            this.data=data;
        }
        int data;
    }

    public static void main(String[] args) {
        int[] tree = new int[]{4, -1, 4, 1, 1};
        System.out.println(new TreeHight().run(tree,5));
    }

    private int run(int[] tree, int length) {
        for (int i = 0; i < tree.length; i++) {
            int el = tree[i];
            while(el != -1){

            }
        }
        return 0;
    }

}
