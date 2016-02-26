package com.shulga;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 You are given a matrix with mm rows and nn columns of cells, each of which contains either 11 or 00.
 Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally.
 The connected and filled (i.e. cells that contain a 11) cells form a region. There may be several regions in the matrix.
 Find the number of cells in the largest region in the matrix.

 Input Format
 There will be three parts of t input:
 The first line will contain mm, the number of rows in the matrix.
 The second line will contain nn, the number of columns in the matrix.
 This will be followed by the matrix grid: the list of numbers that make up the matrix.

 Output Format
 Print the length of the largest region in the given matrix.

 1 1 0 0
 0 1 1 0
 0 0 1 0
 1 0 0 0

 1  2  3  4
 5  6  7  8
 9  10 11 12
 13 14 15 16

 Constraints
 0<m<100<m<10
 0<n<100<n<10

 0 0 1 1
 0 0 1 0
 0 1 1 0
 0 1 0 0
 1 1 0 0
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
//        solver.solve(new int[][]{{1,1,0,0},{0,1,1,0},{1,0,1,0},{1,1,0,0}}, in, out);
//        solver.solve(new int[][]{{1,1,1}}, in, out);
        solver.solve(new int[][]{{1,0},{0,1}}, in, out);
//        solver.solve(new int[][]{{0,0,1,1},{0,0,1,0},{0,1,1,0},{0,1,0,0},{1,1,0,0}}, in, out);
        out.close();
    }

    static class Graph{
        private LinkedList<Integer>[] adj;
        private int V;
        private int count = 0;
        private boolean[] marked;
        Graph(int n){
            V = n+1;
            adj = new LinkedList[V];
            marked = new boolean[V+1];
        }

        void addEdge(Integer i,Integer j){
            if(adj[i]==null) adj[i] = new LinkedList<>();
            if(adj[j]==null) adj[j] = new LinkedList<>();
            adj[i].add(j);
            adj[j].add(i);
        }

       int dfs(int m){
           if(adj[m]==null){
               return 0;
           }
           count=1;
           dfsReq(m, marked);
           return count;
       }

        int V(){
            return V;
        }

        private void dfsReq(int m, boolean[] marked) {
            marked[m] = true;
            for (Integer node:adj[m]) {
                if(!marked[node]){
                    dfsReq(node,marked);
                    count++;
                }
            }
        }
    }

    static class TaskA {
        public void solve(int[][] ar, InputReader in, PrintWriter out) {
            int mRows=ar.length;//in.nextInt();
            int nColumns=ar.length;//in.nextInt();
//            int[][] ar = new int[mRows][nColumns];
//            for (int i = 0; i < mRows; i++) {
//                for (int j = 0; j < nColumns; j++) {
//                    ar[i][j] = in.nextInt();
//                }
//            }
            if(ar.length==0){
                out.println(0);
                return;
            }
            Graph g = new Graph(ar.length*ar[0].length);
            for (int i = 0; i < ar.length; i++) {
                for (int j = 1; j <= ar[0].length; j++) {
                    if(ar[i][j-1]!=1) continue;
                    int current = i*nColumns+j;
                    boolean hasConnection = false;
                    //left
                    if(j>1 && ar[i][j-2]!=0){
                        g.addEdge(current,current-1);
                        hasConnection=true;
                    }
                    //right
                    if(j<nColumns && ar[i][j]!=0){
                        g.addEdge(current,current+1);
                        hasConnection=true;
                    }
                    //up
                    if(i>0 && ar[i-1][j-1]!=0){
                        g.addEdge(current,current-nColumns);
                        hasConnection=true;
                    }
                    //down
                    if(i<mRows-1 && ar[i+1][j-1]!=0){
                        g.addEdge(current,current+nColumns);
                        hasConnection=true;
                    }
                    if(!hasConnection){
                        g.addEdge(current,current);
                    }
                }
            }
            int max = 0;
            for (int i = 1; i < g.V(); i++) {
                int component = g.dfs(i);
                max = Math.max(max,component);
            }
            out.println(max);
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}