import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
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
            int[] nPock = new int[n];
            int[] mPock = new int[m];
            for (int i = 0; i < n; i++) {
                nPock[i] = in.nextInt();
            }
            for (int i = 0; i < m; i++) {
                mPock[i] = in.nextInt();
            }
            Arrays.sort(nPock);
            Arrays.sort(mPock);
            int res = 0;
            int mC = 0;
            for (int i = 0; i < n; i++) {
                if (mC == m || nPock[i] <= mPock[mC]) {
                    res += nPock[i];
                } else {
                    mC++;
                }
            }
            if(mC==m) {
                out.println(res);
            }else{
                out.println(-1);
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
