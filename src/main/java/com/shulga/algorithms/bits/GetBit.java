package com.shulga.algorithms.bits;

/**
 * Created by eshulga on 10/6/15.
 */
public class GetBit {
    boolean getBitFromNumber(int num, int position) {
        int bit = num & (1 << position);
        if (bit == 0) {
            return false;
        } else {
            return true;
        }
    }

    int returnNonDuplicatedSingleNumber(int[] ar) {
        int single = 0;
        for (int num : ar) {
            single = single ^ num;
        }
        return single;
    }

    int getMaxBinaryGap(int num) {
        int max = 0;
        int maxSoFar = 0;
        while (num > 0) {
            int r = num & 1;
            num = num >> 1;
            if (r == 0) {
                maxSoFar++;
            } else {
                max = Math.max(max, maxSoFar);
                maxSoFar = 0;
            }
        }
        max = Math.max(max, maxSoFar);
        return max;
    }

    int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            n = swapBits(n, i, 32 - 1 - i);
        }
        return n;
    }

    private int swapBits(int n, int i, int j) {
        int i2 = (n >> i) & 1;
        int j2 = (n >> j) & 1;
        if ((i2 ^ j2) != 0) {
            n = n ^ ((1 << i) | (1 << j));
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new GetBit().getBitFromNumber(8, 3));
        System.out.println(new GetBit().returnNonDuplicatedSingleNumber(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 5}));
        System.out.println(new GetBit().getMaxBinaryGap(9));
        System.out.println(new GetBit().reverseBits(43261596)); //return 964176192
    }
}
