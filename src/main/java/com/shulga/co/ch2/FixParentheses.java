package com.shulga.co.ch2;

/**
 * Created by ievgen on 7/26/2015.
 */
public class FixParentheses {
    private static java.util.Stack<String> stack = new java.util.Stack<>();

    public static void main(String[] args) {
        System.out.println(test("1+2)*3-4)*5-6)))"));
        ;
    }

    private static String test(String arg) {
        char[] chars = arg.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == ')') {
                String number2 = String.valueOf(stack.pop());
                String operand = String.valueOf(stack.pop());
                String number1 = String.valueOf(stack.pop());
                stack.push(String.format("( %s %s %s %s", number1, operand, number2, ch));
            } else {
                stack.push(String.valueOf(ch));
            }
        }
        String res = "";
        for (String s : stack) {
            res = s + res;
        }
        return res;
    }
}
