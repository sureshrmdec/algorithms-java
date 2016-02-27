package com.shulga.tc.dp;

/**
 * Created by eugene on 9/26/15.
 */
public class ThePalindrome {
    int findShortest(String s){
        char[] chars = s.toCharArray();
        for (int i = 0; i <chars.length; i++) {
            if(isPalindrome(chars, i)){
                return chars.length+i;
            }
        }
        return -1;
    }

    private boolean isPalindrome(char[] chars, int max){
        char[] newArr = new char[chars.length+max];
        int oldArrCounter = 0;
        for (int i = 0; i < newArr.length; i++) {
            if(oldArrCounter==chars.length){
                oldArrCounter  =max-1;
            }
            newArr[i] = chars[oldArrCounter];
            if(i<chars.length){
                oldArrCounter++;
            }else{
                oldArrCounter--;
            }
        }
        for (int i = 0; i < newArr.length / 2; i++) {
            if(newArr[i]!=newArr[newArr.length-1-i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ThePalindrome().findShortest("abdfhdyrbdbsdfghjkllkjhgfds"));
    }
}
