package com.shulga.algorithms.graphs.m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eugene on 10/1/16.
 * 0 1 0
 * 0 1 1
 * 0 0 0
 */
public class SearchTheMaze {
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
        int[][] maze = new int[3][3];
        maze[0][1] = 1;
        maze[1][2] = 1;
        maze[1][1] = 1;
        Coordinate s = new Coordinate(0, 0);
        Coordinate e = new Coordinate(2, 2);
        List<Coordinate> run = new SearchTheMaze().run(maze, s, e);
        for (Coordinate c : run) {
            System.out.println(c);
        }

        System.out.println();
        run = new SearchTheMaze().run(maze, s, e);
        for (Coordinate c : run) {
            System.out.println(c);
        }
    }

    private List<Coordinate> run(int[][] maze, Coordinate s, Coordinate e) {
        List<Coordinate> path = new ArrayList<>();
        path.add(s);
        maze[s.x][s.y] = 1;
        if (!dfs(maze, s, e, path)) {
            path.remove(path.size() - 1);
        }
        return path;
    }

    // 0 1 0
    // 0 1 1
    // 0 0 0
    private boolean dfs(int[][] maze, Coordinate curr, Coordinate e, List<Coordinate> path) {
        if (curr.equals(e)) {
            return true;
        }
        List<Coordinate> shift = Arrays.asList(new Coordinate(0, 1), new Coordinate(1, 0), new Coordinate(0, -1)
                , new Coordinate(-1, 0));
        for (Coordinate c : shift) {
            Coordinate next = new Coordinate(curr.x + c.x, curr.y + c.y);
            if (isValid(next, maze)) {
                path.add(next);
                maze[next.x][next.y] = 1;
                boolean dfs = dfs(maze, next, e, path);
                if (dfs) {
                    return dfs;
                }
                path.remove(path.size() - 1);
            }

        }
        return false;
    }

    private boolean isValid(Coordinate next, int[][] maze) {
        if (next.x >= 0 && next.y >= 0 && next.x < maze.length && next.y < maze[0].length && maze[next.x][next.y] != 1) {
            return true;
        }
        return false;
    }


}
