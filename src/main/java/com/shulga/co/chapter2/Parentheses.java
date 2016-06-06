package com.shulga.co.chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ievgen on 7/26/2015.
 */
public class Parentheses {
    private static ArrayStack<Character> stack = new ArrayStack<>();

    public static void main(String[] args) {
        System.out.println(test("{if(ar[2]==1){return 4;}"));
        ;
    }

    private static boolean test(String arg) {
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        char[] chars = arg.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (isOpen(ch)) {
                stack.push(ch);
            } else if (isClosed(ch)) {
                if (map.get(stack.pop()) != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static boolean isOpen(char ch) {
        return ch == '{' || ch == '[' || ch == '(';
    }

    static boolean isClosed(char ch) {
        return ch == '}' || ch == ']' || ch == ')';
    }
}
