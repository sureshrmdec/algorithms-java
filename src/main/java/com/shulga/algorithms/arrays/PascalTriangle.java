package com.shulga.algorithms.arrays;

/**
 * Created by eshulga on 6/22/16.
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * 1 5 10 10 5 1
 */
public class PascalTriangle {

    public static void main(String[] args) {
        new PascalTriangle().run(5);
    }

    private void run(int num) {
        int n = 7;
        printPascal(n);
//        printPascalExtraSpace(n);
        System.out.println(printPascalElement(4, 1));
        System.out.println(binomialCoeffElen(4, 1));
    }
// A simple O(n^3) program for Pascal's Triangle

// See http://www.geeksforgeeks.org/archives/25621 for details of this function

    // Function to print first n lines of Pascal's Triangle
    void printPascal(int n) {
        // Iterate through every line and print entries in it
        for (int line = 0; line < n; line++) {
            // Every line has number of integers equal to line number
            for (int i = 0; i <= line; i++)
                System.out.print(binomialCoeff(line, i) + " ");
            System.out.println();
        }
    }

    // See http://www.geeksforgeeks.org/archives/25621 for details of this function
    int binomialCoeff(int n, int k) {
        int res = 1;
        if (k > n - k)
            k = n - k;
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    // A O(n^2) time and O(n^2) extra space method for Pascal's Triangle
    void printPascalExtraSpace(int n) {
        int[][] arr = new int[n][n]; // An auxiliary array to store generated pscal triangle values

        // Iterate through every line and print integer(s) in it
        for (int line = 0; line < n; line++) {
            // Every line has number of integers equal to line number
            for (int i = 0; i <= line; i++) {
                // First and last values in every row are 1
                if (line == i || i == 0) {
                    arr[line][i] = 1;
                } else {// Other values are sum of values just above and left of above
                    arr[line][i] = arr[line - 1][i - 1] + arr[line - 1][i];
                }
                System.out.print(arr[line][i] + " ");
            }
            System.out.println();
        }
    }

    // A O(n^2) time and O(1) extra space function for Pascal's Triangle
    void printPascalNoExtraSpace(int n) {
        for (int line = 1; line <= n; line++) {
            int C = 1;  // used to represent C(line, i)
            for (int i = 1; i <= line; i++) {
                System.out.println(C + " ");  // The first value in a line is always 1
                C = C * (line - i) / i;
            }
            System.out.println();
        }
    }

    int printPascalElement(int i, int j) {
        if (i == 0 || i == j) return 1;
        else return printPascalElement(i - 1, j - 1) + printPascalElement(i - 1, j);
    }

    int binomialCoeffElen(int n, int k) {
        int[] C = new int[k + 1];
        C[0] = 1;  // nC0 is 1
        for (int i = 1; i <= n; i++) {
            // Compute next row of pascal triangle using
            // the previous row
            for (int j = Math.min(i, k); j > 0; j--)
                C[j] = C[j] + C[j - 1];
        }
        return C[k];
    }
/**
 * Created by eshulga on 6/22/16.
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * 1 5 10 10 5 1
 */
}