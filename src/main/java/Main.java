import java.io.*;
import java.util.*;

/**
 */
public class Main {

    public static void main(String[] args) {
//        InputStream inputStream = System.in;
//        OutputStream outputStream = System.out;
//        InputReader in = new InputReader(inputStream);
//        PrintWriter out = new PrintWriter(outputStream);
//        TaskA solver = new TaskA();
//        solver.solve(in, out);
//        out.close();

    }





    static class TaskA {
        private int runTask(char[] s1, int c, int n) {
            if (c == 0) {
                return n;
            }
            if (s1[c] != s1[c - 1]) {
                return runTask(s1, c - 1, n);
            }
            int repaint = runTask(s1, c - 1, n);
            int swapp = runTask(swap(s1, c, c - 1), c - 1, n);
            return 1 + Math.min(
                    repaint,
                    swapp
            );
        }

        private char[] swap(char[] s1, int c, int i) {
            char tmp = s1[c];
            s1[c] = s1[i];
            s1[i] = tmp;
            return s1;
        }

        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            out.print(runTask(in.next().toCharArray(), n - 1, 0));
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

