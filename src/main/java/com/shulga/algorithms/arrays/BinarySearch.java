package com.shulga.algorithms.arrays;

/**
 * Binary search
 * O(logN)
 * <p>
 * Created by ievgen on 9/29/2014.
 */
public class BinarySearch {

    public static final int UNORDERED_ARRAY = -1;

    public static void main(String[] args) {
        int[] ar = {1, 3, 4, 5, 77, 99, 111, 122};
        System.out.println(new BinarySearch().binarySearch(77, ar)); //4
        System.out.println(new BinarySearch().binarySearch(73, ar)); //-1

        System.out.println(new BinarySearch().binarySearchRecursively(77, ar)); //4
        System.out.println(new BinarySearch().binarySearchRecursively(73, ar)); //-1
    }

    public int binarySearch(int item, int[] ar) {
        int high = ar.length - 1;
        int low = 0;
        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (item == ar[mid]) {
                return mid;
            } else if (item < ar[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchRecursively(int item, int[] ar) {
        return binarySearchInner(item, ar, 0, ar.length - 1);
    }

    private int binarySearchInner(int item, int[] ar, int low, int high) {
        int range = high - low;
        int mid = (range / 2) + low;
        if (low > high) {
            return -1;
        } else if (ar[low] > ar[high]) {
            return UNORDERED_ARRAY;
        } else {
            if (item == ar[mid]) {
                return mid;
            } else if (item < ar[mid]) {
                return binarySearchInner(item, ar, low, mid - 1);
            } else {
                return binarySearchInner(item, ar, mid + 1, high);
            }
        }
    }


}
