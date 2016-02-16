package com.shulga.algorithms.tc.div2practice;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by eshulga on 10/22/15.
 */
public class SubstitutionCipher {
    public String decode(String a, String b, String y) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        char[] yc = y.toCharArray();

        HashMap<Character, Character> hesh = new HashMap<>();
        HashSet<Character> ah = new HashSet<>();
        HashSet<Character> bh = new HashSet<>();

        for (int i = 0; i < 26; ++i) {
            ah.add((char) ('A' + i));
            bh.add((char) ('A' + i));
        }
        for (int i = 0; i < bc.length; ++i) {
            hesh.put(bc[i], ac[i]);
            bh.remove(bc[i]);
            ah.remove(ac[i]);
        }

        if (ah.size() == 1 && bh.size() == 1) {
            for (char c : ah)
                for (char d : bh)
                    hesh.put(d, c);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < yc.length; ++i) {
            if (!hesh.containsKey(yc[i])) return "";
            sb.append(hesh.get(yc[i]));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SubstitutionCipher().decode("THEQUICKBROWNFOXJUMPSOVERTHELAZYHOG", "UIFRVJDLCSPXOGPYKVNQTPWFSUIFMBAZIPH", "DIDYOUNOTICESKIPPEDLETTER"));
    }
}
