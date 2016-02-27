package com.shulga.tc.srm;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by eshulga on 9/19/15.
 */
public class MatchMaking {

    public static String makeMatch(String[] namesWomen, String[] answersWomen, String[] namesMen, String[] answersMen, String queryWoman) {
        Map<String, String> women = new TreeMap<>();
        Map<String, String> men = new TreeMap<>();
        int length = namesWomen.length;
        for (int i = 0; i < length; i++) {
            women.put(namesWomen[i], answersWomen[i]);
            men.put(namesMen[i], answersMen[i]);
        }
        Map<String, String> result = new HashMap();
        for (String womanName : women.keySet()) {
            String answerString = women.get(womanName);
            char[] charsWoman = answerString.toCharArray();
            String maxMatchName = null;
            int maxMatch = 0;
            for (String manName : men.keySet()) {
                String answerStringMen = men.get(manName);
                char[] charsMen = answerStringMen.toCharArray();
                int answersMatch = 0;
                for (int i = 0; i < charsWoman.length; i++) {
                    if (charsWoman[i] == charsMen[i]) {
                        answersMatch++;
                    }
                }
                if (answersMatch > maxMatch) {
                    maxMatch = answersMatch;
                    maxMatchName = manName;
                }
            }
            result.put(womanName, maxMatchName);
            men.remove(maxMatchName);
        }
        return result.get(queryWoman);
    }

    public static void main(String[] args) {
//        String[] namesWomen={"Constance", "Alice", "Bertha", "Delilah", "Emily"};
//
//        String[] answersWomen = {"baabaa", "ababab", "aaabbb", "bababa", "baabba"};
//
//        String[] namesMen = {"Ed", "Duff", "Chip", "Abe", "Biff"};
//
//        String[] answersMen = {"aabaab", "babbab", "bbbaaa", "abbbba", "abaaba"};
//
//        String queryWoman= "Constance";
//        String result= "Duff";

        String[] namesWomen = {"F", "M", "S", "h", "q", "g", "r", "N", "U", "x", "H", "P",
                "o", "E", "R", "z", "L", "m", "e", "u", "K", "A", "w", "Q",
                "O", "v", "j", "a", "t", "p", "C", "G", "k", "c", "V", "B",
                "D", "s", "n", "i", "f", "T", "I", "l", "d", "J", "y", "b"};

        String[] answersWomen = {"abaabbbb", "bbaabbbb", "aaabaaab", "aabbaaaa", "baabbaab",
                "aaababba", "bbabbbbb", "bbbabbba", "aaabbbba", "aabbbaaa",
                "abbabaaa", "babbabbb", "aaaaabba", "aaaabbaa", "abbbabaa",
                "babababa", "abbaaaaa", "bbababba", "baaaaaba", "baaaaabb",
                "bbbbabba", "ababbaaa", "abbbabab", "baabbbaa", "bbbaabbb",
                "aababbab", "ababbabb", "abbaabba", "baabbabb", "aaabaaab",
                "aabbbaba", "aabaaabb", "abababba", "aabbaaaa", "aabbabaa",
                "bababaaa", "aabaaaab", "bbbbaabb", "baaababb", "abaabbab",
                "aabbbaaa", "baabbaba", "bbabbbaa", "aabbbbaa", "abbbaaab",
                "abababbb", "ababaaba", "bababaaa"};

        String[] namesMen = {"f", "C", "v", "g", "Q", "z", "n", "c", "B", "o", "M", "F",
                "u", "x", "I", "T", "K", "L", "E", "U", "w", "A", "d", "t",
                "e", "R", "D", "s", "p", "q", "m", "r", "H", "j", "J", "V",
                "l", "a", "k", "h", "G", "y", "i", "P", "O", "N", "b", "S"};

        String[] answersMen = {"bbbaabab", "bbabaabb", "ababbbbb", "bbbababb", "baababaa",
                "bbaaabab", "abbabbaa", "bbbabbbb", "aabbabab", "abbababa",
                "aababbbb", "bababaab", "aaababbb", "baabbaba", "abaaaaab",
                "bbaababa", "babaabab", "abbabbba", "ababbbab", "baabbbab",
                "babbaaab", "abbbbaba", "bbabbbba", "baaabaab", "ababbabb",
                "abbbaabb", "bbbbaabb", "bbbaaabb", "baabbaba", "bbabaaab",
                "aabbbaab", "abbbbabb", "bbaaaaba", "bbbababa", "abbaabba",
                "bababbbb", "aabaaabb", "babbabab", "baaaabaa", "ababbaba",
                "aaabaabb", "bbaaabaa", "baaaaabb", "bbaabaab", "bbababab",
                "aabaaaab", "aaaaabab", "aabbaaba"};

        String queryWoman = "U";

        String result = "x";

        System.out.println(makeMatch(namesWomen, answersWomen, namesMen, answersMen, queryWoman));


    }
}
