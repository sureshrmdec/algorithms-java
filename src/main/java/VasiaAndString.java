import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by eshulga on 2/25/16.
 */
public class VasiaAndString {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(new int[]{1, 1, 3}, in, out);
        out.close();
    }
//4 2
//abba
    static class TaskA {

        public void solve(int[] arr, InputReader in, PrintWriter out) {
            int length = in.nextInt();
            int changes = in.nextInt();
            String str = in.next();

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
