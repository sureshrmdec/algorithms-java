package com.shulga.algorithms.string;

/**
 * Created by eshulga on 11/7/14.
 */
public class ReverseWords {

    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int begin = 0;
        int end = chars.length - 1;

        while (begin < end) {
            swap(begin++, end--, chars);
        }
        return new String(chars);
    }

    //TODO finish
    public static String reverseWords(String str) {
        char[] chars = str.toCharArray();
        int begin = 0;
        int end = 0;
        int length = str.length();
        String reversed = reverseString(str);

        while (end < length) {
            if (chars[end] != ' ') {
                begin = end;
                while (end < length && chars[end] != ' ') {
                    end++;
                }
            }
        }
        return new String(chars);
    }

    private static void swapString(int begin, int end, String[] split) {
        String tmp = split[begin];
        split[begin] = split[end];
        split[end] = tmp;
    }

    private static void swap(int begin, int end, char[] chars) {
        int tmp = chars[begin];
        chars[begin] = chars[end];
        chars[end] = (char) tmp;
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello world"));
        System.out.println(reverseWords("hello world I'm Here"));
    }
}
