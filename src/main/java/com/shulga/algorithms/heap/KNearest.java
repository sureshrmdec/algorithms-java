package com.shulga.algorithms.heap;

/**
 * Pretty optimal min-heap solution
 */
public class KNearest {

    private enum Metric {
        EUCLIDEAN, MANHATTAN
    }

    public static Metric metric = Metric.EUCLIDEAN;  // default, can be changed

    public static void main(String[] args) {
        KNearest kNearest = new KNearest();
        Point[] datastore = new Point[]{new Point(1, 2), new Point(0, 2), new Point(1, 3)};

        //       the workflow        //
        kNearest.loadPoint(datastore);

        //should return [(0,2),(1,2)]
        printResult(kNearest.nearest(2));

        kNearest.addPoint(new Point(0, 1));

        //should return [(0,1),(0,2)]
        printResult(kNearest.nearest(2));

    }

    private MinHeap heap;

    public KNearest() {}

    /**
     * Return the K points on the plane closest to the origin
     * Time complexity is supposed to be K*logN
     * Assume the points input is random
     * You can not use java collections framework data structures (HashMap, TreeMap, etc)
     */
    private Point[] nearest(int k) {
        // Edge cases
        if (!isLoaded()) {
            System.out.println("Warning: No data points loaded.");
            return null;
        }
        if (k < 1) {
            System.out.println(String.format("Warning: Requesting k=%d < 1", k));
            return null;
        }
        if (k > size()) {
            System.out.println(String.format("Warning: Requesting k=%d larger than number of loaded data points: %d", k, size()));
            return null;
        }

        // Just retrieve the first k
        Point[] result = new Point[k];
        int i = 0;
        for (MinHeap.Node node : heap.take(k)) {
            result[i++] = node.data;
        }
        return result;
    }

    /**
     * Adds streaming 1 point to datastore
     */
    private void addPoint(Point point) {
        heap.add(point);
    }

    /**
     * Loads data during start time
     */
    private void loadPoint(Point[] points) {
        heap = new MinHeap();
        for (Point p : points) {
            heap.add(p);
        }
    }

    /**
     * BasicOps for data points loaded
     */
    private boolean isLoaded() {
        return size() > 0;
    }

    /**
     * @return number of data points loaded
     */
    private int size() {
        return heap == null ? 0 : heap.size;
    }

    /**
     * Container class for a 2D point
     */
    private static class Point {

        public static final Point ORIGIN = new Point(0, 0);

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)", x, y);
        }

        public static double distance(Point a, Point b, Metric metric) {
            switch (metric) {
                case EUCLIDEAN:
                    return euclideanDistance(a, b);
                case MANHATTAN:
                    return manhattanDistance(a, b);
                default:
                    return 0.0;
            }
        }

        private static double euclideanDistance(Point a, Point b) {
            double dx = (double) (a.x - b.x);
            double dy = (double) (a.y - b.y);
            return Math.sqrt(dx*dx + dy*dy);
        }

        private static double manhattanDistance(Point a, Point b) {
            return Math.abs(a.x - b.x) + Math.abs(a.y - a.x);
        }
    }

    /**
     * Prints an array of points to stdout
     */
    private static void printResult(Point[] p) {
        if (p == null) {
            System.out.println("null");
        } else if (p.length == 0) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i < p.length - 1; ++i) {
                System.out.print(p[i] + ",");
            }
            System.out.print(String.format("%s]\n", p[p.length-1]));
        }
    }

    /**
     * A min-heap implementation
     */
    public static class MinHeap {

        public int size;
        public Node[] nodes;

        public MinHeap() {
            size = 0;
            nodes = new Node[64];  // default starting size, dynamically resized if needed
        }

        public void add(Point p) {
            // Check capacity
            if (size == nodes.length) {
                resize();
            }

            Node node = new Node(p);

            // First node
            if (size == 0) {
                nodes[0] = node;
                size = 1;
                return;
            }

            // General case of insertion, need to heapify
            size++;
            int i = size - 1;
            nodes[i] = node;

            // Fix the min heap property if it is violated
            while (i != 0 && nodes[parent(i)].value > nodes[i].value) {
                Node tmp = nodes[i];
                nodes[i] = nodes[parent(i)];
                nodes[parent(i)] = tmp;
                i = parent(i);
            }
        }

        // Heap index getters
        private int parent(int i) {
            return (i-1)/2;
        }

        private int left(int i) {
            return (2*i + 1);
        }

        private int right(int i) {
            return (2*i + 2);
        }

        /**
         * Recursive function to satisfy heap property: parent node value is smaller than children values
         */
        private void heapify(int i) {
            int l = left(i);
            int r = right(i);
            int smallest = i;
            if (l < size && nodes[l].value < nodes[i].value) {
                smallest = l;
            }
            if (r < size && nodes[r].value < nodes[smallest].value) {
                smallest = r;
            }
            if (smallest != i) {
                Node tmp = nodes[i];
                nodes[i] = nodes[smallest];
                nodes[smallest] = tmp;
                heapify(smallest);
            }
        }

        /**
         * Pop the minimum value from the heap, re-heapify.
         * Note: this destroys the current heap!
         */
        public Node pop() {
            if (size == 0) {
                return null;
            }
            Node result = nodes[0];
            nodes[0] = nodes[size-1];
            size--;
            heapify(0);
            return result;
        }

        /**
         * Pop the first k nodes, copy them, then put back in the heap, return the k copied nodes.
         * This is to avoid destruction of the heap from popping alone.
         */
        public Node[] take(int k) {
            if (k < 1) {
                return null;
            }
            Node[] result = new Node[k];
            // Get first k
            for (int i = 0; i < k; ++i) {
                result[i] = pop();
            }
            // Restore heap state by copying the results back into the heap
            for (Node node : result) {
                add(node.data);
            }
            return result;
        }

        /**
         * Increase size of the heap array by doubling capacity
         */
        private void resize() {
            Node[] tmp = new Node[nodes.length*2];
            for (int i = 0; i < nodes.length; ++i) {
                tmp[i] = nodes[i];
            }
            nodes = tmp;
        }

        public static MinHeap copyOf(MinHeap current) {
            MinHeap result =  new MinHeap();
            result.nodes = new Node[current.size];
            result.size = current.size;
            for (int i = 0; i < current.size; ++i) {
                result.nodes[i] = current.nodes[i];
            }
            return result;
        }

        public static class Node {
            public double value;
            public Point data;

            public Node(Point p) {
                data = p;
                value = Point.distance(Point.ORIGIN, p, metric);
            }
        }
    }
}