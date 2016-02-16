package com.shulga.arrays;

/**
 * A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element).
 */
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println("Ans: " + new MajorityElement().run2(new int[]{5, 2, 2, 2, 5, 5, 5}));
    }

    public static int findCandidate(int[] ar, int length) {
        int majElem = 0;
        int count = 1;
        int j;
        for (j = 0; j < length; j++) {
            if (ar[majElem] == ar[j]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majElem = j;
                count = 1;
            }
        }
        return ar[majElem];
    }

    public static int run2(int[] ar) {
        int candidate = findCandidate(ar, ar.length);
        int counter = 0;
        for (int i = 0; i < ar.length; i++) {
            if (candidate == ar[i]) {
                counter++;
            }
            if (counter > ar.length / 2) {
                return candidate;
            }
        }
        return 0;
    }


}
