package com.shulga.algorithms.string;

/**
 * Find the longest consecutive char in string. Do not use extra space.
 * <p>
 * Created by ievgen on 2/1/2015.
 */
public class LongestConsecutiveChar {

    public static char getLongestConsecutiveCharExtraSpace(String str) {
        char[] chars = str.toCharArray();
        int[] charFrequency = new int[256];
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                charFrequency[chars[i]]++;
            }
        }
        char result = 0;
        int resultFrequency = 0;
        for (int i = 0; i < chars.length; i++) {
            if (charFrequency[chars[i]] > resultFrequency) {
                result = chars[i];
                resultFrequency = charFrequency[chars[i]];
            }
        }
        return result;
    }

    public static char getLongestConsecutiveChar(String str) {
        char[] chars = str.toCharArray();
        char maxFrequentChar = chars[0];
        int maxFrequency = 1;
        char maxFrequentCharSoFar = chars[0];
        int maxFrequencySoFar = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                if (maxFrequencySoFar > maxFrequency) {
                    maxFrequency = maxFrequencySoFar;
                    maxFrequentChar = maxFrequentCharSoFar;
                }
                maxFrequencySoFar = 1;
                maxFrequentCharSoFar = chars[i];
            } else {
                maxFrequencySoFar++;
            }
        }
        if (maxFrequencySoFar > maxFrequency) {
            maxFrequentChar = maxFrequentCharSoFar;
        }
        return maxFrequentChar;
    }

    public static void main(String[] args) {
        System.out.println(getLongestConsecutiveChar("aasss"));
        System.out.println(getLongestConsecutiveCharExtraSpace("aasss"));
    }
}
