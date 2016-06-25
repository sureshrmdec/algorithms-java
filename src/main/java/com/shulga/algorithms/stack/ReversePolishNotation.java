package com.shulga.algorithms.stack;


/**
 * Created by eshulga on 6/23/16.
 * 2 1 12 3 / - + = 2+1-12/3 = -1
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(new ReversePolishNotation().run("2 1 12 3 / - +"));
    }

    private int run(String exp) {
        StackWithMaxElement s = new StackWithMaxElement();
        String[] tokens = exp.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];
            if (c.equals("/")) {
                int pop = s.pop();
                s.push(s.pop() / pop);
            } else if (c.equals("-")) {
                int pop = s.pop();
                s.push(s.pop() - pop);
            } else if (c.equals("+")) {
                s.push(s.pop() + s.pop());
            } else {
                s.push(Integer.parseInt(c));
            }
        }
        return s.pop();
    }
}
