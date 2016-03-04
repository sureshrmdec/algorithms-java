package com.shulga.tc.s679.d2;

import java.util.Arrays;

public class ListeningSongs {

    public int listen(int[] durations1, int[] durations2, int minutes, int T) {
        int totalSec = minutes * 60;
        int currentTime = 0;
        int numSong = 0;
        Arrays.sort(durations1);
        Arrays.sort(durations2);
        int smallerLength = Math.min(durations1.length, durations2.length);
        int biggerLength = Math.max(durations1.length, durations2.length);
        if (smallerLength < T) {
            return -1;
        }
        int i;
        for (i = 0; i < T; i++) {
            currentTime += durations1[i];
            currentTime += durations2[i];
            numSong += 2;
            if (currentTime > totalSec) {
                return -1;
            }
        }
        int d1 = i;
        int d2 = i;
        while(d1<durations1.length || d2<durations2.length) {
            int next;
            if (d1 >= durations1.length) {
                next = durations2[d2++];
            } else if (d2 >= durations2.length) {
                next = durations1[d1++];
            } else if (durations1[d1] <= durations2[d2]) {
                next = durations1[d1++];
            } else {
                next = durations2[d2++];
            }
            if (currentTime + next <= totalSec) {
                currentTime += next;
                numSong++;
            }
        }
        return numSong;
    }
}
