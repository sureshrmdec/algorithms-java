package com.shulga.algorithms.tc.stringparsing.div11;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eshulga on 9/23/15.
 */
public class KingSort {
    //        String[] small = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//        String[] big = new String[]{"X", "XX", "XXX", "XL", "L"};
    Map<String, Integer> small = new HashMap<>();
    Map<String, Integer> big = new HashMap<>();

    {
        small.put("I", 1);
        small.put("II", 2);
        small.put("III", 3);
        small.put("VI", 4);
        small.put("V", 5);
        small.put("VI", 6);
        small.put("VII", 7);
        small.put("VIII", 8);
        small.put("IX", 9);

        big.put("X", 10);
        big.put("XX", 20);
        big.put("XXX", 30);
        big.put("XL", 40);
        big.put("L", 50);
    }

    String[] getSortedList(String[] kings) {
        for (int i = 0; i < kings.length; i++) {
            for (int j = i + 1; j < kings.length; j++) {
                if (less(kings[j], kings[i])) {
                    String temp = kings[i];
                    kings[i] = kings[j];
                    kings[j] = temp;
                }
            }
        }
        return kings;
    }

    boolean less(String a, String b) {
        String[] asplit = a.split(" ");
        String[] bsplit = b.split(" ");
        String aname = asplit[0];
        String aNum = asplit[1];
        String bname = bsplit[0];
        String bNum = bsplit[1];
        if (!aname.equals(bname)) {
            return aname.compareTo(bname) < 0 ? true : false;
        }
        if (big.getOrDefault(aNum, 0) + small.getOrDefault(aNum, 0) < big.getOrDefault(bNum, 0) + small.getOrDefault(bNum, 0)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] sortedList = new KingSort().getSortedList(new String[]{"John X", "John I", "John L", "John V"});
        for (String king : sortedList) {
            System.out.println(king);
        }
    }
}
