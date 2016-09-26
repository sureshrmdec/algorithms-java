package com.shulga.algorithms.string;

/**
 * Created by eshulga on 11/7/14.
 */
public class ReverseWords {

    public static String reverseString(String str, int s, int e) {
        char[] chars = str.substring(s, e + 1).toCharArray();
        int begin = 0;
        int end = chars.length - 1;

        while (begin < end) {
            swap(begin++, end--, chars);
        }
        return new String(chars);
    }

    //TODO finish my task
    public static String reverseWords(String str) {
        int start = 0;
        String reversed = reverseString(str, 0, str.length() - 1);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < reversed.length(); i++) {
            if (reversed.charAt(i) == ' ') {
                sb.append(reverseString(reversed, start, i - 1));
                sb.append(" ");
                start = i + 1;
            }
        }
        sb.append(reverseString(reversed, start, reversed.length() - 1));

        return sb.toString();
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
        String str = "hello world";
        System.out.println(reverseString(str, 0, str.length() - 1));
        String str1 = "hello world I'm Here";
        System.out.println(reverseWords(str1));
    }
}
