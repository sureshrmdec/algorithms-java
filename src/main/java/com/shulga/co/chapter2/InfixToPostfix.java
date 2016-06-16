package com.shulga.co.chapter2;

/**
 * Created by ievgen on 7/26/2015.
 */
public class InfixToPostfix {

    private static java.util.Stack<String> stack = new java.util.Stack<>();

    public static void main(String[] args) {
        System.out.println(test("((1+2)*((3-4)*(5-6)))"));
        ;
    }

    private static String test(String arg) {
        char[] chars = arg.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == ')') {
                String number2 = stack.pop();
                String operand = stack.pop();
                String number1 = stack.pop();
                String res = String.format("%s %s %s", number1, number2, operand);
                stack.push(res);
            } else if (ch == '(') {
                //ignore
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
