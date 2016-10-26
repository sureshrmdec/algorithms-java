package com.shulga.algorithms.tries;

import java.util.PriorityQueue;

/**
 * Created by eshulga on 10/20/16.
 */
public class Huffman {

    // alphabet size of extended ASCII
    private static final int R = 256;

    // compress bytes from standard input and write to standard output
    public static String compress(String s) {
        // read the input
//        String s = ;
        char[] input = s.toCharArray();

        // tabulate frequency counts
        int[] freq = new int[R];
        for (int i = 0; i < input.length; i++)
            freq[input[i]]++;

        // build Huffman trie
        Node root = buildTrie(freq);

        // build code table
        String[] st = new String[R];
        buildCode(st, root, "");

        // print trie for decoder
        StringBuffer sb = new StringBuffer();
        writeTrie(root, st, sb);

        // print number of bytes in original uncompressed message
        System.out.println();
        System.out.println("number of bytes in original uncompressed message " + input.length);

        // use Huffman code to encode input
        for (int i = 0; i < input.length; i++) {
            String code = st[input[i]];
            for (int j = 0; j < code.length(); j++) {
                if (code.charAt(j) == '0') {
                    System.out.print(false);
                } else if (code.charAt(j) == '1') {
                    System.out.print(true);
                } else throw new RuntimeException("Illegal state");
            }
        }

        return sb.toString();
    }

    // build the Huffman trie given frequencies
    private static Node buildTrie(int[] freq) {

        // initialze priority queue with singleton trees
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for (char i = 0; i < R; i++)
            if (freq[i] > 0)
                pq.add(new Node(i, freq[i], null, null));

        // merge two smallest trees
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.add(parent);
        }
        return pq.poll();
    }

    // write bitstring-encoded trie to standard output
    private static void writeTrie(Node x, String[] st, StringBuffer sb) {
        if (x.isLeaf()) {
//            System.out.print(true);
//            System.out.print(st[x.ch]+"t");
            sb.append("t"+st[x.ch]);
            return;
        }
        sb.append("f");
        writeTrie(x.left, st, sb);
        writeTrie(x.right, st, sb);
    }

    // make a lookup table from symbols and their encodings
    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left, s + '0');
            buildCode(st, x.right, s + '1');
        } else {
            st[x.ch] = s;
        }
    }

    // expand Huffman-encoded input from standard input and write to standard output
    public static String expand(String encoded) {

        // read in Huffman trie from input stream
        Counter counter = new Counter();
        System.out.println();
        System.out.println("reading tree:"+encoded);
        System.out.println();
        Node root = readTrie(encoded, counter);
        StringBuffer sb = new StringBuffer();
        // number of bytes to write
        int length = encoded.length();

        // decode using the Huffman trie
        for (int i = 0; i < length; i++) {
            Node x = root;
            if(x!=null) {
                while (!x.isLeaf()) {
                    char c = encoded.charAt(i);
                    boolean bit = false;
                    if (c == 't') {
                        bit = true;
                    }
                    if (bit) x = x.right;
                    else x = x.left;
                }
                sb.append(x.ch);
            }
        }
        return sb.toString();
    }

    private static Node readTrie(String coding, Counter c) {
        if (c.c == coding.length() - 1) return null;
        boolean isLeaf = false;
        if (coding.charAt(c.c) == 't') {
            isLeaf = true;
        }
        if (isLeaf) {
            c.c++;
            return new Node(coding.charAt(c.c), -1, null, null);
        } else {
            c.c++;
            return new Node('\0', -1, readTrie(coding, c), readTrie(coding, c));
        }

    }

    public static void main(String[] args) {
        String coding = compress("hello");
        System.out.println(expand(coding));
//        else if (args[0].equals("+")) expand();
    }

    // Huffman trie node
    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        // is the node a leaf node?
        private boolean isLeaf() {
            assert (left == null && right == null) || (left != null && right != null);
            return (left == null && right == null);
        }

        // compare, based on frequency
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    static class Counter {
        int c;
    }

}