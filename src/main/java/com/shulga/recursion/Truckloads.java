package com.shulga.recursion;

/**
 * Created by eshulga on 10/2/15.
 */
public class Truckloads {

    int numTrucks(int numCrates, int loadSize) {
        if (numCrates <= loadSize) {
            return 1;
        }
        int result = 0;
        if (numCrates % 2 == 0) {
            result += (numTrucks(numCrates / 2, loadSize) * 2);
        } else {
            result += numTrucks(numCrates / 2, loadSize);
            result += numTrucks(numCrates / 2 + 1, loadSize);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Truckloads().numTrucks(1024, 5));
    }
}
