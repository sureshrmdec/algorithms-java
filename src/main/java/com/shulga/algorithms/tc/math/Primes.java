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
        System.out.println(toDecimal(1001, 10));
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

    public static int toDecimal(int n, int b) {
        int result = 0;
        int multiplier = 1;
        while (n > 0) {
            result += n % 10 * multiplier;
            multiplier *= b;
            n = n / 10;
        }
        return result;
    }

    //from decimal up to 10 base number
    public static int fromDecimal(int n, int b) {
        int result = 0;
        int multiplier = 1;
        while (n > 0) {
            result += n % 2 * multiplier;
            multiplier += 10;
            n = n / b;
        }
        return result;
    }

    //from decimal up to 10 base number
    public static String fromDecimal2(int n, int b) {
        String chars = "0123456789ABCDEFGHIJ";
        String result = "";
        while (n > 0) {
            result = chars.charAt(n % b) + result;
            n = n / b;
        }
        return result;
    }

    public static int[] addFraction(int[] a, int[] b) {
        int denom = LCM(a[1], b[1]);
        int[] res = {denom / a[1] * a[0] + denom / b[1] * b[0], denom};
        return res;
    }

    public static void reduceFraction(int[] a) {
        int gcd = GCD(a[0], a[1]);
        a[0] = a[0] / gcd;
        a[1] = a[1] / gcd;
    }

}
