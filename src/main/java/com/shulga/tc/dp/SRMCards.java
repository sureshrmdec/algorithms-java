package com.shulga.tc.dp;

import java.util.Arrays;

/**
 * Created by eugene on 9/26/15.
 */
public class SRMCards
{
    int maxTurns(int[] cards){
        Arrays.sort(cards);
        int counter=0;
        for (int i = 0; i < cards.length; i++) {
            if(cards[i]!=0){
                counter++;
                if(i<cards.length-1  && cards[i]+1==cards[i+1]){
                    cards[i+1] = 0;
                }
            }

        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new SRMCards().maxTurns(new int[]{118, 321, 322, 119, 120, 320}));
    }
}
