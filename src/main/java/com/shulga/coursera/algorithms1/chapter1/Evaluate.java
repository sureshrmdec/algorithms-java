package com.shulga.coursera.algorithms1.chapter1;


import com.shulga.coursera.algorithms1.chapter2.ArrayStack;

/**
 * Created by ievgen on 10/7/2014.
 * <p>
 * Run: echo ( 1 + ( ( 3 * 5 ) * ( 3 + 1 ) ) ) | java -cp stdlib.jar;chapter2/ArrayStack.java;. Evaluate
 */
public class Evaluate {
    public static void main(String[] args) {
        ArrayStack<String> opd = new ArrayStack<String>();
        ArrayStack<Double> num = new ArrayStack<Double>();
        while (!StdIn.isEmpty()) {
            String taken = StdIn.readString();
            if ("(".equals(taken) || " ".equals(taken)) {

            } else if ("*".equals(taken) || "+".equals(taken)) {
                opd.push(taken);
            } else if (")".equals(taken)) {
                String operand = opd.pop();
                if ("+".equals(operand)) {
                    num.push(num.pop() + num.pop());
                } else if ("*".equals(operand)) {
                    num.push(num.pop() * num.pop());
                }
            } else {
                num.push(Double.parseDouble(taken));
            }
        }
        System.out.println(num.pop());
    }
}
