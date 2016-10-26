import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution1 {
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
            int[] ar = new int[]{10, 20 ,20 ,10 ,10 ,30 ,50 ,10 ,20};
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < ar.length; i++) {
                int current = ar[i];
                if(map.containsKey(current)) {
                    map.put(current,map.get(current)+1);
                }else{
                    map.put(current,1);
                }
            }
            int res = 0;
            for (Map.Entry<Integer,Integer> entry:map.entrySet()){
                res+=entry.getValue()/2;
            }
            out.println(res);
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
