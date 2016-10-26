package com.shulga.algorithms.permutations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by eshulga on 10/11/16.
 */
public class DfsPhoneLetterCombinations {
    public static void main(String[] args) {
        System.out.println(new DfsPhoneLetterCombinations().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        List<String> result = new ArrayList<String>();
        if (digits.equals(""))
            return result;

        helper(result, new StringBuilder(), digits, 0, map);

        return result;

    }

    public void helper(List<String> result, StringBuilder sb, String digits, int index, HashMap<Character, char[]> map) {
        if (index >= digits.length()) {
            result.add(sb.toString());
            return;
        }

        char c = digits.charAt(index);
        char[] arr = map.get(c);

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            helper(result, sb, digits, index + 1, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public void dfs(List<String> res, Map<Character, char[]> map, String digits, int start, StringBuffer sb) {
        if (start == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char[] chars = map.get(digits.charAt(start));
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            dfs(res, map, digits, start + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
