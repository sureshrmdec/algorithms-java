public class PercolationStats {
    private double[] attempts;

    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        attempts = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation p = new Percolation(N);
            int sites = 0;
            while (!p.percolates()) {
                int row = StdRandom.uniform(N) + 1;
                int column = StdRandom.uniform(N) + 1;
                if (!p.isOpen(row, column)) {
                    p.open(row, column);
                    sites++;
                }
            }
            attempts[i] = (double) sites / (N * N);
        }
    }

    public static void main(String[] args) {
        PercolationStats ps = new PercolationStats(300, 1000);
        StdOut.print("mean = " + ps.mean() + "\n");
        StdOut.print("std dev = " + ps.stddev() + "\n");
        StdOut.print("95% confidence interval = " + ps.confidenceLo() + ", "
                + ps.confidenceHi());
    }

    public double mean() {
        return StdStats.mean(attempts);
    }

    public double stddev() {
        return StdStats.stddev(attempts);
    }

    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(attempts.length));
    }

    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(attempts.length));
    }
}
