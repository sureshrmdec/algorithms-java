package com.shulga.tc.srm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eshulga on 10/7/15.
 */
public class LiveConcert {

    int maxHappiness(int[] h, String[] s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < h.length; i++) {
            String singer = s[i];
            if (!map.containsKey(singer) || (map.containsKey(singer) && map.get(singer) < h[i])) {
                map.put(singer, h[i]);
            }
        }
        int totalHappy = 0;
        for (Integer happy : map.values()) {
            totalHappy += happy;
        }
        return totalHappy;
    }

    public static void main(String[] args) {
        System.out.println(new LiveConcert().maxHappiness(new int[]{1,2,3,4,5,6,7,8,9,10,100}, new String[]{"a","b","c","d","e","e","d","c","b","a","abcde"}));
    }
}
