package com.shulga.algorithms.tc.stringparsing.div11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by eshulga on 9/23/15.
 */
public class InternetSecurity {

    String[] determineWebsite(String[] address, String[] keyword, String[] dangerous, int threshold) {
        HashSet dangerousSet = new HashSet();
        List<String> result = new ArrayList<String>();
        addToDangerous(dangerous, dangerousSet);
        for (int i = 0; i < address.length; i++) {
            String[] siteKeywords = keyword[i].split(" ");
            int counter = 0;
            for (int j = 0; j < siteKeywords.length; j++) {
                if (dangerousSet.contains(siteKeywords[j])) {
                    counter++;
                }
                if (counter == threshold) {
                    addToDangerous(siteKeywords,dangerousSet);
                    result.add(address[i]);
                    break;
                }
            }
        }
        return result.toArray(new String[0]);
    }

    private void addToDangerous(String[] words, HashSet dangerousSet) {
        for (int i = 0; i < words.length; i++) {
            dangerousSet.add(words[i]);
        }
    }


    public static void main(String[] args) {


        String[] address =  {"a..a.ab.","...aa.b"};
        String[] keyword =  {"a bc def","def ghij klmno"};
        String[] dangerous = {"a","b","c","d","e"};
        int threshold = 1;
        String[] website = new InternetSecurity().determineWebsite(address, keyword, dangerous, threshold);
        for (int i = 0; i < website.length; i++) {
            System.out.println(website[i]);
        }
    }
}
