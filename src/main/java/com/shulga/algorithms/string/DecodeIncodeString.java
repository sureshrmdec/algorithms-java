package com.shulga.algorithms.string;

/**
 * Created by eshulga on 8/22/16.
 */
public class DecodeIncodeString {
    public static void main(String[] args) {
        String s = "hello jazz";
        DecodeIncodeString decoder = new DecodeIncodeString();
        String encode = decoder.encode(s);
        System.out.println(encode);
        System.out.println(decoder.decode(encode));
    }

    private String decode(String encode) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < encode.length(); i++) {
            char current = encode.charAt(i);
            if (Character.isDigit(current)) {
                for (int j = 0; j < Integer.parseInt(current+""); j++) {
                    sb.append(encode.charAt(i-1));
                }
            }
        }
        return  sb.toString();
    }

    private String encode(String encode) {
        StringBuffer sb = new StringBuffer();
        int counter = 1;
        for (int i = 1; i < encode.length(); i++) {
            if (encode.charAt(i - 1) == encode.charAt(i)) {
                counter++;
            } else {
                sb.append(encode.charAt(i - 1));
                sb.append(counter);
                counter = 1;
            }
        }
        sb.append(encode.charAt(encode.length() - 1));
        sb.append(counter);
        return sb.toString();
    }
}
