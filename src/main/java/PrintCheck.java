import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by eshulga on 2/25/16.
 */
public class PrintCheck {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(new int[]{1, 1, 3}, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int[] arr, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int[][] ar = new int[n][m];
            int[][] queries = new int[k][3];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < 3; j++) {
                    queries[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < k; i++) {
                int[] query = queries[i];
                if (query[0] == 1) {
                    for (int j = 0; j < m; j++) {
                        ar[query[1] - 1][j] = query[2];
                    }
                } else {
                    for (int j = 0; j < n; j++) {
                        ar[j][query[1] - 1] = query[2];
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    out.print(ar[i][j] + " ");
                }
                out.println();
            }
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
