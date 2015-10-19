package com.shulga.coursera.algorithms1;

/**
 * Created by eugene on 10/6/15.
 */
public class PriorityQueue {
    private Comparable[] ar;
    private int N = 0;
    public PriorityQueue(int n){
        ar = new Comparable[n];
    }

    public void add(Comparable n){
        ar[N] = n;
        swim(++N);
    }

    public Comparable delMax(){
        Comparable temp = ar[1];
        exch(1,N--);
        ar[N+1] = null;
        sink(1);
        return temp;
    }

    private void swim(int k){
        while(k>1 && less(ar[k],ar[k/2])){
            exch(k,k/2);
            k = k/2;
        }
    }

    private void sink(int n){
        while(n*2<= N){
            int j = n*2;
            if(n*2< N && less(ar[j],ar[j+1])){
                j++;
            }
            if(less(ar[j],ar[n])) {
                break;
            }
            exch(j,n);
            n = j;
        }

    }

    void exch(int i,int j){
        Comparable temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
}
