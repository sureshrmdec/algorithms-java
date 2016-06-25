package com.shulga.algorithms.arrays;

/**
 * Created by eshulga on 6/23/16.
 */
public class RemoveDupsInSortedArray {
    public static void main(String[] args) {
        new RemoveDupsInSortedArray().run(new int[]{1, 1, 2, 2, 2, 3, 47, 50, 50});
    }

    private void run(int[] ar) {
        int cFinal = 1;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] == ar[i - 1]) {
                continue;
            } else if (i != cFinal) {
                ar[cFinal++] = ar[i];
            } else {
                cFinal++;
            }
        }
        for (int i = cFinal; i < ar.length; i++) {
            ar[i] = 0;
        }
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i] + " ");
        }
    }


}
