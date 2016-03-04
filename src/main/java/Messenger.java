import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by eshulga on 2/25/16.
 */
public class Messenger {
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
            String[] t = new String[n];
            String[] s = new String[m];
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                t[i] = in.next();
            }
            for (int i = 0; i < m; i++) {
                s[i] = in.next();
            }
            int counter = 0;
            for (int i = 0; i < t.length; i++) {
                String[] stokenIn = s[0].split("-");
                String[] ttokenIn = t[i].split("-");
                if (ttokenIn[1].equals(stokenIn[1]) && Integer.valueOf(ttokenIn[0]) >= Integer.valueOf(stokenIn[0])) {
                    int c = i;
                    int j;
                    for (j = 1; j < s.length - 1; j++) {
                        c++;
                        if (c >= t.length || !t[c].equals(s[j])) {
                            break;
                        }

                    }
                    if (j >= s.length - 1) {
                        String[] stoken = s[s.length - 1].split("-");
                        String[] ttoken = t[c].split("-");
                        if (ttokenIn[1].equals(stokenIn[1]) && Integer.valueOf(ttoken[0]) >= Integer.valueOf(stoken[0])) {
                            counter++;
                        }
                    }
                }
            }
            out.println(counter);
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
