package com.shulga.interview.string;

import java.util.*;

/**
 * Find duplicates in string O(N)
 * <p/>
 * Created by ievgen on 9/29/2014.
 */
public class FindDuplicates {

    public Set<String> findDuplicates(List<String> list) {
        Set tempSet = new HashSet();
        Set duplicates = new HashSet();
        for (String string : list) {
            if (!tempSet.add(string)) {
                duplicates.add(string);
            }
        }
        return duplicates;
    }

    public List<String> findDuplicatesOrCountUsingFrequency(List<String> inputStringList) {
        Set<String> tempSet = new HashSet<String>();
        List<String> outList = new ArrayList<String>();
        tempSet.addAll(inputStringList);
        for (String str : tempSet) {
            outList.add(str + ": " + Collections.frequency(inputStringList, str));
        }
        return outList;
    }
}
