package com.shulga.tc.srm;

import java.util.Arrays;

/**
 * Created by eshulga on 9/19/15.
 */
public class UserName {

    public static String newMember(String[] existingNames, String newName) {
        Arrays.sort(existingNames);
        String suggestion = newName;
        int counter = 1;
        while (Arrays.binarySearch(existingNames, suggestion) >= 0) {
            suggestion = newName + counter++;
        }
        return suggestion;
    }

    public static void main(String[] args) {
//        String[] existingNames = {"grokster2", "BrownEyedBoy", "Yoop", "BlueEyedGirl",
//                "grokster", "Elemental", "NightShade", "Grokster1"};
//        String name="grokster";

        String[] existingNames = {"Bart4", "Bart5", "Bart6", "Bart7", "Bart8", "Bart9", "Bart10",
                "Lisa", "Marge", "Homer", "Bart", "Bart1", "Bart2", "Bart3",
                "Bart11", "Bart12"};
        String name = "Bart";
        System.out.println(newMember(existingNames, name));
    }

}
