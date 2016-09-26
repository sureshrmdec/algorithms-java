package com.shulga.algorithms.BST;

import java.util.*;

/**
 * Created by eugene on 9/5/16.
 */
public class AddCredits {
    private int offset;
    private NavigableMap<Integer,Set<String>> tree = new TreeMap<>();
    private Map<String,Integer> clientToCredit = new HashMap<>();

    String max(){
       if(tree.isEmpty()){
           return null;
       }
       return tree.lastEntry().getValue().iterator().next();
    }

    int getCreditsById(String id){
        if(!clientToCredit.containsKey(id)){
            return 0;
        }
        int credit = clientToCredit.get(id);
        return credit+offset;
    }

    void incrementAll(int k){
        offset+=k;
    }

    boolean removeClient(String id){
        Integer credit = clientToCredit.get(id);
        if(credit==null) return false;
        tree.remove(credit,id);
        return true;
    }

    void add(String id,int credit){
        int creditFinal = credit-offset;
        clientToCredit.put(id, creditFinal);
        if(tree.get(creditFinal)==null){
            tree.put(creditFinal,new HashSet<>());
        }
        tree.get(creditFinal).add(id);
    }
}
