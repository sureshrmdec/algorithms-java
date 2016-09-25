package com.shulga.algorithms.greedy;

/**
 * Created by eugene on 9/24/16.
 */
public class CarFuel {
    public static void main(String[] args) {
        int[] stations = new int[]{0, 3, 3, 5, 6, 10};
        System.out.println(minGasStations(stations, 3));
    }

    private static int minGasStations(int[] stations, int L) {
        int current = 0;
        int res = 0;
        while (current < stations.length) {
            int last = current;
            while (last + 1 < stations.length && stations[last + 1] - stations[current] <= L) {
                last++;
            }
            if (last == current) {
                if(current != stations.length - 1) {
                    return -1;
                }else{
                    break;
                }
            }
            current = last;
            res++;
        }
        return res;
    }
}
