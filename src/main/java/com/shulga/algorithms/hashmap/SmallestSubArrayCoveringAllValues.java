package com.shulga.algorithms.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by eugene on 9/5/16.
 */
public class SmallestSubArrayCoveringAllValues {

    static class RInterval {
        public RInterval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int start;
        int end;

        @Override
        public String toString() {
            return "RInterval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"apple", "banana", "apple", "apple", "dog", "cat", "apple", "dog", "banana", "apple", "cat", "dog"};
        System.out.println(new SmallestSubArrayCoveringAllValues().run(Arrays.asList(words), Arrays.asList("banana", "cat")));
    }

    private RInterval run(List<String> text, List<String> keywords) {
        RInterval interval = new RInterval(-1, -1);
        HashMap<String, Integer> words = new HashMap<>();
        for (int left = 0, right = 0; right < text.size(); ) {

            for (; words.size() < keywords.size() && right<text.size(); right++) {
                String current = text.get(right);
                if (keywords.contains(current)) {
                    if (words.containsKey(current)) {
                        words.put(current, words.get(current) + 1);
                    } else {
                        words.put(current, 1);
                    }
                }
            }

            for (; words.size() == keywords.size(); left++) {
                String current = text.get(left);
                if (words.containsKey(current)) {
                    words.put(current, words.get(current) - 1);
                    if (words.get(current) == 0) {
                        words.remove(current);
                        if (interval.start == -1 && interval.end == -1 || interval.end - interval.start > right - left - 1) {
                            interval.start = left;
                            interval.end = right;
                        }
                    }
                }
            }
        }
        return interval;
    }
}
