package com.shulga.tc.srm;

import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class Similars {

    public int maxsim(int L, int R) {
        int maxPossible = getMaxSimilarity(R - 1);
        int simMax = 0;
        for (int i = R; i >= L; i--) {
            for (int j = i - 1; j >= L; j--) {
                int sim = getSimilarity(i, j);
                if (sim == maxPossible) {
                    return sim;
                } else if (sim > simMax) {
                    simMax = sim;
                }
            }
        }
        return simMax;
    }

    private int getSimilarity(int i, int j) {
        String jStr = String.valueOf(j);
        char[] iChars = String.valueOf(i).toCharArray();
        Arrays.sort(iChars);
        Set<Character> set = new HashSet<>();
        for (int k = 0; k < jStr.length(); k++) {
            if (Arrays.binarySearch(iChars, jStr.charAt(k)) >= 0) {
                set.add(jStr.charAt(k));
            }
        }
        return set.size();
    }

    int getMaxSimilarity(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count++;
        }
        return count;
    }
}
