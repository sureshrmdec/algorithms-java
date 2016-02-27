package com.shulga.algorithms.arrays;

/**
 * Minimum Number of Platforms Required for a Railway/Bus Station
 * Given arrival and departure times of all trains that reach a railway station, find the minimum number of platforms required for the railway station so that no train waits.
 * We are given two arrays which represent arrival and departure times of trains that stop
 * <p>
 * Examples:
 * <p>
 * Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
 *         dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
 * Output: 3
 * There are at-most three trains at a time (time between 11:00 to 11:20)
 */
public class MinimumNuberOfPlatformsForRails {
    public static void main(String[] args) {
        System.out.println(new MinimumNuberOfPlatformsForRails().run(new String[]{"9:00",  "9:40", "9:50",  "11:00", "15:00", "18:00"},
                new String[]{"9:10", "12:00", "11:20", "11:30", "19:00", "20:00"}));
    }

    private Integer parse(String time){
        String[] split = time.split(":");
        Integer res = 0;
        for (int i = 0; i < split.length; i++) {
            res+=Integer.valueOf(split[i]);
        }
        return res;
    }

    private int run(String[] arrivals, String[] departures) {
        int minPlat = 0;
        for (int i = 0; i < arrivals.length; i++) {
            Integer depTime = parse(departures[i]);
            int tempPlat = 0;
            for (int j = i+1; j < arrivals.length; j++) {
                if(parse(arrivals[j])<depTime){
                    tempPlat++;
                }
            }
            minPlat = Math.max(minPlat,tempPlat);
        }
        return  minPlat;
    }
}
