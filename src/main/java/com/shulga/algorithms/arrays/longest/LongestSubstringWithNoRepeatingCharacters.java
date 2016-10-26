package com.shulga.algorithms.arrays.longest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eshulga on 10/18/16.
 */
public class LongestSubstringWithNoRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithNoRepeatingCharacters().run("abcabcbb"));
        System.out.println(new LongestSubstringWithNoRepeatingCharacters().run("bbbbb"));
        System.out.println(new LongestSubstringWithNoRepeatingCharacters().run("pwwkew"));
        System.out.println(new LongestSubstringWithNoRepeatingCharacters().run("abba"));
    }

    private int run(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        int i;
        for (i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1,start);
                map.remove(ch);
            }
            map.put(ch, i);
            max = Math.max(max, i - start+1);
        }
        return max;
    }
}
