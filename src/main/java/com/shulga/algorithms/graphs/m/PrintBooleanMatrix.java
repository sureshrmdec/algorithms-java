package com.shulga.algorithms.graphs.m;

import java.util.Arrays;
import java.util.List;

/**
 * Created by eugene on 10/1/16.
 * 1 0 1
 * 0 1 0
 * 0 0 1
 */
public class PrintBooleanMatrix {



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

    public static void main(String[] args) {
        int[][] m = new int[3][3];
        m[0][0] = 1;
        m[0][2] = 1;
        m[1][1] = 1;
        m[2][2] = 1;
        printMatrix(m);
        new PrintBooleanMatrix().dfs(m, new Coordinate(0, 1));
        System.out.println();
        printMatrix(m);
    }

    static void printMatrix(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void dfs(int[][] m, Coordinate current) {
        List<Coordinate> shift = Arrays.asList(new Coordinate(1, 0), new Coordinate(-1, 0), new Coordinate(0, 1),
                new Coordinate(0, -1));
        m[current.x][current.y] = 1;
        for (Coordinate c : shift) {
            Coordinate next = new Coordinate(current.x + c.x, current.y + c.y);
            if (isValid(next, m)) {
                m[next.x][next.y]=1;
                dfs(m,next);
            }
        }

    }

    private boolean isValid(Coordinate next, int[][] m) {
        if (next.x >= 0 && next.x < m.length && next.y >= 0 && next.y < m[0].length && m[next.x][next.y]==0) return true;
        return false;
    }

}
