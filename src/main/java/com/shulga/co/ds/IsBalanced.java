package com.shulga.co.ds;

/**
 * Created by eshulga on 6/1/16.
 */
public class IsBalanced {

    public static void main(String[] args) {
        System.out.println(new IsBalanced().isBalanced("[]"));
        System.out.println(new IsBalanced().isBalanced("(){}"));
        System.out.println(new IsBalanced().isBalanced("({})"));
        System.out.println(new IsBalanced().isBalanced("{[]}()"));
        System.out.println(new IsBalanced().isBalanced("{"));
        System.out.println(new IsBalanced().isBalanced("{[}"));
        System.out.println(new IsBalanced().isBalanced("foo(bar);"));
        System.out.println(new IsBalanced().isBalanced("foo(bar[i);"));
    }

    String isBalanced(String exp) {
        if(exp.length()==1) return String.valueOf(1);
        Stack s = new Stack(exp.length());
        char[] chars = exp.toCharArray();
        int i;
        for (i = 1; i <= chars.length; i++) {
            Character ch = chars[i-1];
            if (ch == '[' || ch == '(' || ch == '{') {
                s.push(ch);
            } else if (ch == ']' || ch == ')' || ch == '}') {
                Character poped = s.pop();
                if ((poped == '(' && ch != ')') || (poped == '[' && ch != ']') || (poped == '{' && ch != '}')) {
                    return String.valueOf(i);
                }
            }
        }
        return "Success";
    }

    private class Stack {
        Character[] ar;
        int length;
        int counter = 0;

        Stack(int n) {
            length = n;
            ar = new Character[length];
        }

        boolean isEmpty() {
            return counter == 0;
        }

        void push(Character s) {
            if (counter == length) {
                throw new IllegalArgumentException("Stack is full,catnt push");
            }
            ar[counter++] = s;
        }

        Character peek() {
            if (isEmpty()) {
                return null;
            }
            return ar[counter - 1];
        }

        Character pop() {
            if (isEmpty()) {
                return null;
            }
            Character res = ar[--counter];
            ar[counter] = null;
            return res;
        }
    }
}
