package com.shulga.algorithms.string;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by eshulga on 8/23/16.
 */
public class RabinKarp {
    private String pat;      // the pattern  // needed only for Las Vegas
    private long patHash;    // pattern hash value
    private int m;           // pattern length
    private long q;          // a large prime, small enough to avoid long overflow
    private int R;           // radix
    private long RM;         // R^(M-1) % Q

    /**
     * Preprocesses the pattern string.
     *
     * @param pattern the pattern string
     * @param R the alphabet size
     */
    public RabinKarp(char[] pattern, int R) {
        throw new UnsupportedOperationException("Operation not supported yet");
    }

    /**
     * Preprocesses the pattern string.
     *
     * @param pat the pattern string
     */
    public RabinKarp(String pat) {
        this.pat = pat;      // save pattern (needed only for Las Vegas)
        R = 256;
        m = pat.length();
        q = longRandomPrime();

        // precompute R^(m-1) % q for use in removing leading digit
        RM = 1;
        for (int i = 1; i <= m-1; i++)
            RM = (R * RM) % q;
        patHash = hash(pat, m);
    }

    // Compute hash for key[0..m-1].
    private long hash(String key, int m) {
        long h = 0;
        for (int j = 0; j < m; j++)
            h = (R * h + key.charAt(j)) % q;
        return h;
    }

    // Las Vegas version: does pat[] match txt[i..i-m+1] ?
    private boolean check(String txt, int i) {
        for (int j = 0; j < m; j++)
            if (pat.charAt(j) != txt.charAt(i + j))
                return false;
        return true;
    }

    // Monte Carlo version: always return true
    private boolean check(int i) {
        return true;
    }

    /**
     * Returns the index of the first occurrrence of the pattern string
     * in the text string.
     *
     * @param  txt the text string
     * @return the index of the first occurrence of the pattern string
     *         in the text string; n if no such match
     */
    public int search(String txt) {
        int n = txt.length();
        if (n < m) return n;
        long txtHash = hash(txt, m);

        // check for match at offset 0
        if ((patHash == txtHash) && check(txt, 0))
            return 0;

        // check for hash match; if hash match, check for exact match
        for (int i = m; i < n; i++) {
            // Remove leading digit, add trailing digit, check for match.
            txtHash = (txtHash + q - RM*txt.charAt(i-m) % q) % q;
            txtHash = (txtHash*R + txt.charAt(i)) % q;

            // match
            int offset = i - m + 1;
            if ((patHash == txtHash) && check(txt, offset))
                return offset;
        }

        // no match
        return -1;
    }


    // a random 31-bit prime
    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    /**
     * Takes a pattern string and an input string as command-line arguments;
     * searches for the pattern string in the text string; and prints
     * the first occurrence of the pattern string in the text string.
     */
    public static void main(String[] args) {
        String pat = "and";
        String txt = "hello world and this and that";

        RabinKarp searcher = new RabinKarp(pat);
        int offset = searcher.search(txt);
        System.out.println("found "+offset);
        // print results

        // from brute force search method 1
        for (int i = offset; i <offset+pat.length() ; i++)
            System.out.print(txt.charAt(i));
    }
}
