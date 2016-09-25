package com.shulga.algorithms.hashmap;

/**
 * Created by eugene on 9/18/16.
 */
public class SmallestSubArrayThatCoversValuesSequentially {
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
        System.out.println(new SmallestSubArrayThatCoversValuesSequentially().run(new String[]{"after", "hello", "world", "after", "sun", "light",
                "hello", "after"}, new String[]{"hello", "after"}));
    }

    public RInterval run(String[] text, String[] keywords) {
        int left = 0;
        int right = 0;
        int keywordCounter = 0;
        RInterval interval = new RInterval(-1, -1);
        while (left <= right) {
            while (keywordCounter != keywords.length && right<text.length) {
                if (text[right].equals(keywords[keywordCounter])) {
                    keywordCounter++;
                }
                right++;
            }

            if(keywordCounter!=keywords.length){
                break;
            }

            while (keywordCounter == keywords.length) {
                if ((interval.start == -1 && interval.end == -1) || interval.end - interval.start > right - left) {
                    interval.start = left;
                    interval.end = right;
                }
                if(text[left]==keywords[0]){
                    keywordCounter=0;
                    left=right;
                }else {
                    left++;
                }
            }

        }
        return interval;

    }
}
