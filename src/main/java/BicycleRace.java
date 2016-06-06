import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by eshulga on 2/25/16.
 */
public class BicycleRace {
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
            int lines = in.nextInt();
            Pair[] ar = new Pair[lines + 1];
            for (int i = 0; i <= lines; i++) {
                ar[i] = new Pair(in.nextInt(), in.nextInt());
            }
            int res = 0;
            String direction = getDirection(ar[0], ar[1]);
            for (int i = 1; i < lines; i++) {
                Pair start = ar[i];
                Pair end = ar[i + 1];
                String nextDirection = getDirection(start, end);
                if (direction.equals("north")) {
                    if (nextDirection.equals("west")) {
                        res++;
                    }
                } else if (direction.equals("east")) {
                    if (nextDirection.equals("north")) {
                        res++;
                    }
                } else if (direction.equals("south")) {
                    if (nextDirection.equals("east")) {
                        res++;
                    }
                } else if (direction.equals("west")) {
                    if (nextDirection.equals("south")) {
                        res++;
                    }
                }
                direction = nextDirection;

            }
            out.println(res);
        }

        private String getDirection(Pair start, Pair end) {
            String direction = null;
            if (start.x > end.x) {
                direction = "west";
            } else if (start.x < end.x) {
                direction = "east";
            } else if (start.y > end.y) {
                direction = "south";
            } else if (start.y < end.y) {
                direction = "north";
            }
            return direction;
        }
    }

    static class Pair {
        int x;
        int y;

        Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
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

