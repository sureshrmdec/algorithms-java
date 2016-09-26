import java.io.*;
import java.util.StringTokenizer;

public class SolutionB {
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
            if (n == 1) {
                out.print("YES");
                return;
            }
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextInt();
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, ar[i]);
                max = Math.max(max, ar[i]);
            }
            int dif;
            if ((max - min) % 2 != 0) {
                dif = (max - min);
            } else {
                dif = (max - min) / 2;
            }

            int same = ar[0];
            if (ar[0] == max) {
                same = ar[0] - dif;
            } else if (ar[0] == min) {
                same = ar[0] + dif;
            }
            for (int i = 0; i < n; i++) {
                int current = ar[i];
                if (current == same) {
                    continue;
                } else if (current == max) {
                    current -= dif;
                } else if (current == min) {
                    current += dif;
                }
                if (current != same) {
                    out.print("NO");
                    return;
                }

            }
            out.print("YES");
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
