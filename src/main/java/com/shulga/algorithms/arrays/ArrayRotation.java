package com.shulga.algorithms.arrays;

/**
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 */
public class ArrayRotation {
    public static void main(String[] args) {
        int[] run = new ArrayRotation().run3(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2);
        for (int i = 0; i < run.length; i++) {
            System.out.println(run[i]);
        }
    }

    public static void reverse(int[] ar, int front, int end) {
        while (front < end) {
            int temp = ar[front];
            ar[front] = ar[end];
            ar[end] = temp;
            front++;
            end--;
        }
    }

    //O(N)
    public static int[] run3(int[] ar, int rotate) {
        reverse(ar, 0, rotate - 1);
        reverse(ar, rotate, ar.length - 1);
        reverse(ar, 0, ar.length - 1);
        return ar;
    }

    // O(N*D)
    public static int[] run2(int[] ar, int rotate) {
        int gcd = gcd(ar.length, rotate);
        for (int i = 0; i < rotate; i++) {
            for (int j = gcd + i; j < ar.length; j = j + gcd) {
                int temp = ar[j];
                ar[j] = ar[j - gcd];
                ar[j - gcd] = temp;
            }
        }
        return ar;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // O(N) + O(d) space
    public static int[] run(int[] ar, int rotate) {
        int[] dif = new int[rotate];
        for (int i = 0; i < dif.length; i++) {
            dif[i] = ar[i];
        }
        for (int i = 0; i < ar.length - rotate; i++) {
            ar[i] = ar[rotate + i];
        }
        for (int i = 0; i < dif.length; i++) {
            ar[ar.length - rotate + i] = dif[i];
        }
        return ar;
    }

}
