package com.shulga.algorithms.tc.recursion;

/**
 * Created by eshulga on 10/1/15.
 */
public class Maze {

    boolean isMazeSolvable(String[][] maze) {
        int startX = -1;
        int startY = -1;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == "S") {
                    startX = j;
                    startY = i;
                }
            }
        }
        if (startX == -1) {
            return false;
        }
        return exploreMaze(maze, startX, startY);
    }

    private boolean exploreMaze(String[][] maze, int startX, int startY) {
        if (startX < 0 || startX == maze[0].length || startY < 0 || startY == maze.length) {
            return false;
        }
        if (maze[startY][startX] == "*") {
            return false;
        }
        if (maze[startY][startX] == "E") {
            return true;
        }
        if (exploreMaze(maze, startX, startY - 1)) return true;
        if (exploreMaze(maze, startX, startY + 1)) return true;
        if (exploreMaze(maze, startX - 1, startY)) return true;
        if (exploreMaze(maze, startX + 1, startY)) return true;
        return false;
    }

    public static void main(String[] args) {
        String[][] ar = new String[5][5];
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {

                if (i == 3 && j == 4) {
                    ar[i][j] = "S";
                } else {
                    ar[i][j] = "*";
                }
            }
        }
        System.out.println(new Maze().isMazeSolvable(ar));
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                System.out.print(ar[i][j] + " ");
            }
            System.out.println();
        }
    }
}
