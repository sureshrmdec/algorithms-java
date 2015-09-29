package com.shulga.algorithms.tc.s443;

/**
 * Created by eshulga on 9/29/15.
 */
public class MagicWords {

    int howMany(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            boolean[] hit = new boolean[256];
            int j;
            for (j = 1; j < word.length; j++) {
                if (hit[word[j]]) {
                    break;
                }
                if (word[j] != word[j - 1]) {
                    hit[word[j - 1]] = true;
                }
            }
            if (j == word.length) {
                count++;
            }
        }
        return count;
    }

    int howManyNoExtraSpace(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            boolean isMatch = true;
            for (int j = 0; j < word.length - 1; j++) {
                if (word[j] != word[j + 1]) {
                    for (int k = j + 1; k < word.length; k++) {
                        if (word[k] == word[j]) {
                            isMatch = false;
                        }
                    }
                }
            }
            if (isMatch) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new MagicWords().howManyNoExtraSpace(new String[]{"ccazzzzbba", "code", "aabbbccb", "topcoder"}));
    }
}
