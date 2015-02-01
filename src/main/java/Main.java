import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        System.out.println(N);
        Percolation p = new Percolation(N);
        while (!p.percolates()) {
            int p1 = getNumber();
            int q1 = getNumber();
            p.open(p1, q1);
            System.out.println(p1 + " " + q1);
        }
        System.out.println("Percolation happened");
    }

    public static int getNumber() {
        int readInt;
        try {
            readInt = StdIn.readInt();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Percolation is impossible");
        }
        return readInt;
    }
}
