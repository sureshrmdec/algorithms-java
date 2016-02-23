import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int numCases = in.nextInt();
            for (int j = 0; j < numCases; j++) {

                int sum = in.nextInt();
                int N = in.nextInt();
                int[] ar = new int[N + 1];
                for (int i = 1; i < ar.length; i++) {
                    ar[i] = in.nextInt();
                }

                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i = 1; i < ar.length; i++) {
                    map.put(ar[i], i);
                }

                for (int i = 1; i < ar.length; i++) {
                    if (map.containsKey(sum - ar[i])) {
                        out.println(i + " " + map.get(sum - ar[i]));
                        return;
                    }
                }
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
