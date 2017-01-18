package com.shulga.algorithms.graphs.algs;

/**
 * Created by eshulga on 10/28/16.
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class SearchWordDFS {
    public static void main(String[] args) {
        char[][] chars = new char[3][3];
        chars[0] = new char[]{'A', 'B', 'C', 'E'};
        chars[1] = new char[]{'S', 'F', 'C', 'S'};
        chars[2] = new char[]{'A', 'D', 'E', 'E'};
        System.out.println(new SearchWordDFS().run(chars, "ABCCED"));
    }

    private boolean run(char[][] chars, String word) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if (dfs(chars, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] m, int i, int j, String word, int k) {
        if (i < 0 || i >= m.length || j < 0 || j >= m[0].length) {
            return false;
        }
        if (m[i][j] == word.charAt(k)) {
            if (k == word.length()) return true;
            m[i][j] = '#';
            int newK = k + 1;
            if (dfs(m, i - 1, j, word, newK) || dfs(m, i + 1, j, word, newK) || dfs(m, i, j - 1, word, newK) || dfs(m, i, j + 1, word, newK)) {
                return true;
            }
            m[i][j] = word.charAt(k);
        }
        return false;
    }
}
