import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by eshulga on 2/25/16.
 */
public class Report {
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
        private static boolean less(Comparable v, Comparable w, int type) {
            if (type == 1) {
                return (v.compareTo(w) < 0);
            }
            return (v.compareTo(w) > 0);
        }

        public void solve(int[] arr, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int managers = in.nextInt();
            Comparable[] ar = new Comparable[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextInt();
            }
            for (int i = 0; i < managers; i++) {
                int t = in.nextInt();
                int r = in.nextInt();
                sort(ar, 0, r - 1, t);
            }
            for (int i = 0; i < n; i++) {
                out.print(ar[i] + " ");
            }
        }

        private void sort(Comparable[] ar, int low, int high, int type) {
            Comparable[] copy = new Comparable[ar.length];
            mergeSort(ar, copy, low, high, type);
        }

        private void mergeSort(Comparable[] ar, Comparable[] copy, int low, int high, int type) {
            if (low >= high) {
                return;
            }
            int mid = low + (high - low) / 2;
            mergeSort(ar, copy, low, mid, type);
            mergeSort(ar, copy, mid + 1, high, type);
            merge(ar, copy, low, mid, high, type);
        }

        private void merge(Comparable[] ar, Comparable[] copy, int low, int mid, int high, int type) {
            for (int i = low; i <= high; i++) {
                copy[i] = ar[i];
            }
            int i = low;
            int j = mid + 1;
            for (int k = low; k <= high; k++) {
                if (i > mid) ar[k] = copy[j++];
                else if (j > high) ar[k] = copy[i++];
                else if (less(copy[i], copy[j], type)) ar[k] = copy[i++];
                else ar[k] = copy[j++];
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
