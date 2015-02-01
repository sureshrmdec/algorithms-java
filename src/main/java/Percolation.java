public class Percolation {
    private int[] sites;
    private int N;
    private int top;
    private int buttom;
    private WeightedQuickUnionUF uf;

    public Percolation(int N) {
        this.N = N;
        this.top = N * N;
        int cellsCount = N * N + 2;
        this.buttom = N * N + 1;
        uf = new WeightedQuickUnionUF(cellsCount);
        sites = new int[cellsCount];
        sites[top] = 1;
        sites[buttom] = 1;
    }

    public void open(int i, int j) {
        checkRange(i, j);
        if (isOpen(i, j)) {
            return;
        }
        int index = getCellIndex(i, j);
        sites[index] = 1;
        int[][] neighbors = getNeighbors(i, j);
        for (int k = 0; k < 4; k++) {
            int[] n = neighbors[k];
            int nIndex = getCellIndex(n[0], n[1]);
            if (nIndex < 0 || nIndex >= N * N) {
                continue;
            }
            if (sites[nIndex] == 1) {
                union(nIndex, index);
            }
        }
        if (i == 1) {
            union(index, top);
        }
        if (i == N) {
            union(index, buttom);
        }
    }

    private void union(int p, int q) {
        if (!uf.connected(p, q)) {
            uf.union(p, q);
        }
    }

    private int getCellIndex(int row, int column) {
        return (N * (row - 1)) + column - 1;
    }

    private void checkRange(int i, int j) {
        if (i <= 0 || j <= 0 || i > N || j > N) {
            throw new IndexOutOfBoundsException();
        }
    }

    private int[][] getNeighbors(int i, int j) {
        int[][] ar = new int[4][2];
        ar[0] = new int[]{i - 1, j};
        ar[1] = new int[]{i + 1, j};
        ar[2] = new int[]{i, j - 1};
        ar[3] = new int[]{i, j + 1};
        return ar;
    }

    public boolean isOpen(int i, int j) {
        checkRange(i, j);
        return sites[getCellIndex(i, j)] == 1;
    }

    public boolean isFull(int i, int j) {
        checkRange(i, j);
        return uf.connected(top, getCellIndex(i, j));
    }

    public boolean percolates() {
        return uf.connected(top, buttom);
    }
}
