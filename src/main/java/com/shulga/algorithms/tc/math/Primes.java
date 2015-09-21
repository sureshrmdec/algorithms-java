package com.shulga.algorithms.tc.math;

import java.util.Arrays;

/**
 * Created by eshulga on 9/19/15.
 */
public class Primes {
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        int m = (int) Math.sqrt(n);
        for (int i = 3; i <= m; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean[] ar = sieve(20);
        for (int i = 0; i < ar.length; i++) {
            System.out.println(i + " " + ar[i]);
        }

        System.out.println(GCD(2336, 1314));
    }

    public static boolean[] sieve(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        int m = (int) Math.sqrt(n);
        for (int i = 2; i <= m; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }

    public static int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }

    public static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}
