package com.shulga.algorithms.graphs.m;

/**
 * Created by eugene on 10/1/16.
 */
public class ExclosedRegions {
    static class Coordinate {
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        int x;
        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Coordinate that = (Coordinate) o;

            if (x != that.x) return false;
            return y == that.y;

        }

    }

    static void printMatrix(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] m = new int[3][3];
        m[0][0] = 1;
        m[0][2] = 1;
        m[1][1] = 1;
        m[2][2] = 1;
        printMatrix(m);
        new ExclosedRegions().run(m);
        System.out.println();
        printMatrix(m);
    }

    public void run(int[][] m) {
        for (int i = 1; i < m.length - 1; i++) {
            for (int j = 1; j < m[0].length-1; j++) {
                if(m[i][j]!=1){
//                    dfs(m,new Coordi555nate(i,j));
                }
            }

        }
    }

}
