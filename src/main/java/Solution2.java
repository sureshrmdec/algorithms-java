import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.findRadius(new int[]{2, 3, 4}, new int[]{3}));
        System.out.println(solution.rodCut(10, new int[]{2, 3, 4}, new int[]{1, 4, 5}));

    }


    int rodCut(int K, int[] length, int[] values) {
        return 1;
    }

    public int findRadius(int[] houses, int[] heaters) {
        int rad = Arrays.binarySearch(houses, heaters[0]);
        for (int i = 1; i < heaters.length; i++) {
            int l = Arrays.binarySearch(houses, heaters[i - 1]);
            int r = Arrays.binarySearch(houses, heaters[i]);
            rad = Math.max((r - l - 1) / 2, rad);
        }
        rad = Math.max(houses.length - 1 - Arrays.binarySearch(houses, heaters[heaters.length - 1]), rad);
        return rad;
    }


    public int findComplement(int num) {
        String temp = "";
        for (char c : Integer.toBinaryString(num).toCharArray()) {
            temp += c == '1' ? "0" : "1";
        }
        return Integer.parseInt(temp, 2);
    }

    public String licenseKeyFormatting(String S, int K) {
        int chars = 0;
        for (int i = 0; i < S.length(); i++) {
            if (Character.isAlphabetic(S.charAt(i)) || Character.isDigit(S.charAt(i))) {
                chars++;
            }
        }
        int first = chars % K;
        int intervals = chars / K;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (j < first && i < S.length()) {
            if (S.charAt(i) == '-') {
                i++;
                continue;
            }
            if (Character.isAlphabetic(S.charAt(i))) {
                sb.append(Character.toUpperCase(S.charAt(i)));
            } else {
                sb.append(S.charAt(i));
            }
            j++;
            i++;
        }
        if (first > 0 && intervals > 0) {
            sb.append("-");
        }

        j = 0;
        while (i < S.length()) {
            if (S.charAt(i) == '-') {
                i++;
                continue;
            }
            if (Character.isAlphabetic(S.charAt(i))) {
                sb.append(Character.toUpperCase(S.charAt(i)));
            } else {
                sb.append(S.charAt(i));
            }
            j++;
            i++;
            if (j == K) {
                j = 0;
                intervals--;
                if (intervals == 0) break;
                if (i != S.length()) {
                    sb.append("-");
                }
            }
        }
        return sb.toString();
    }


    public int sumRange(int[] nums, int i, int j) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int k = 1; k < nums.length; k++) {
            dp[k] = dp[k - 1] + nums[k];
        }

        int res = dp[j];
        if (i > 0) {
            res -= dp[--i];
        }
        return res;
    }


    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            int indx = Arrays.binarySearch(nums, i + 1, nums.length, left);
            if (indx > 0) {
                return new int[]{i + 1, indx + 1};
            }
        }
        return new int[]{};
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
            if (mC == m) {
                out.println(res);
            } else {
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
