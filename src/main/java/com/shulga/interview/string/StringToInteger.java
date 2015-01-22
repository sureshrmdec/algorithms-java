package com.shulga.interview.string;

/**
 * Created by ievgen on 11/8/14.
 */
public class StringToInteger {

    public static int stringToInteger(String str) {
        int i = 0;
        int result = 0;
        boolean isNegative = false;
        int power = str.length() - 1;

        if (str.charAt(0) == '-') {
            isNegative = true;
            i++;
            power--;
        }

        while (i < str.length()) {
            int current = str.charAt(i) - '0';
            result += current * Math.pow(10, power--);
            i++;
        }
        if (isNegative) {
            result *= -1;
        }
        return result;
    }

    public int stringToInt(String str) {
        int i = 0;
        int num = 0;
        boolean isNeg = false;
        int len = str.length();
        if (str.charAt(0) == '-') {
            isNeg = true;
            i++;
        }

        while (i < len) {
            num *= num * 10;
            num += (str.charAt(i++) - '0');
        }

        if (isNeg)
            num *= -1;
        return num;
    }

    public static String intToString(int num) {
        boolean isNegative = false;
        int i = 0;
        char[] chars = new char[11];
        if (num < 0) {
            isNegative = true;
        }

        while (num > 0) {
            chars[i++] = (char) (num % 10 + '0');
            num /= 10;
        }
        if (isNegative) {
            chars[i++] = '-';
        }
        int start = 0;
        int end = i - 1;

        while (start < end) {
            swap(chars, start++, end--);
        }

        return new String(chars);
    }

    public static int convertStringToNum(String inputString) {
        int factor = (int) Math.pow(10, inputString.length() - 1);
        int temp1;
        int temp2 = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isDigit(inputString.charAt(i))) {
                temp1 = Character.getNumericValue(inputString.charAt(i)) * factor;
                temp2 = temp1 + temp2;
                factor = factor / 10;
            } else {
                System.out.println("Please enter numbers only");
                return 0;
            }
        }
        return temp2;
    }

    private static void swap(char[] chars, int start, int end) {
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
    }


    public static void main(String[] args) {
        System.out.println(intToString(782));
        System.out.println(stringToInteger("-876"));
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.stringToInt("-444"));
    }
}
