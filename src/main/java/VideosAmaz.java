import java.io.*;
import java.util.*;

/**
 * Using Indexed Max priority queue based on the heap data structure.
 *
 * All and Top10 videos are stored in the IndexedMaxPriorityQueue
 * This way we can use properties of the Heap to decrease running time to logN
 * To be able to increase views of particular video, index inside the Priority queue is used.
 *
 * Space complexity is O(N)
 * videoViewed - time O(logN*logM) where N is number videos, M is number of top videos
 * getTopVideos - time O(logM), space M, the M is number of top videos
 * getRanking - time O(M), can be improved to logM in case we can have bigger number of top videos. Right now use priority queue to decrease time from NLogN.
 *
 * Main method is not optimized, didn't have time to make it work nice. Sorry.
 */
public class VideosAmaz {
    private IndexedMaxPQ videosPQ = new IndexedMaxPQ();
    private static IndexedMaxPQ topVideosMaxPQ =new IndexedMaxPQ();


    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        VideosAmaz solution = new VideosAmaz();

        String videoViewed = "videoViewed";
        String getTopVideos = "getTopVideos";
        String getRanking = "getRanking";
        for (int i = 0; i < 14; i++) {
            String s = in.next();
            if (s.startsWith(videoViewed)) {
                solution.videoViewed(s.substring(videoViewed.length() + 2, s.length() - 2));
            } else if (s.startsWith(getRanking)) {
                out.println(solution.getRanking(s.substring(getRanking.length() + 2, s.length() - 2)));
            } else if (s.startsWith(getTopVideos)) {
                for (String id : solution.getTopVideos()) {
                    out.print(id + " ");
                }

            }
            out.close();
        }

    }

    /**
     * Called when a single quantity of the given product has been sold.
     * This should update internal product rankings as necessary.
     *
     * @param videoId the unique identifier for the video
     */
    void videoViewed(String videoId) {
        videosPQ.addOrIncreaseKey(videoId);
        if (topVideosMaxPQ.size() < 10 || topVideosMaxPQ.contains(videoId)) {
            topVideosMaxPQ.addOrIncreaseKey(videoId);
        } else {
            topVideosMaxPQ.add(videoId, videosPQ.keys.get(videoId));
            topVideosMaxPQ.deleteMin();
        }
    }

    /**
     * Returns the relative ranking of the product on the most popular video list.
     *
     * @return the ranking of the video.
     */
    int getRanking(String videoId) {
        return videosPQ.rankFromTopK(videoId);
    }


    /**
     * Returns the top ten most popular videos in an ordered list.
     *
     *
     *
     * @return a list of video ids
     */
    List<String> getTopVideos() {
        return videosPQ.top();
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

    /**
     * Index Max Priority queue
     */
    private static class IndexedMaxPQ {
        private int n; //number of elements
        private List<String> pq;
        private HashMap<String, Integer> qp;
        private HashMap<String, Integer> keys;

        public IndexedMaxPQ() {
            n = 0;
            pq = new ArrayList();
            pq.add("");
            qp = new HashMap<>();
            keys = new HashMap<>();
        }


        public boolean isEmpty() {
            return n == 0;
        }

        public boolean contains(String index) {
            return qp.containsKey(index);
        }

        public int size() {
            return n;
        }

        public void add(String index, Integer key) {
            if (contains(index)) throw new IllegalArgumentException("index already exist in PQ");
            n++;
            qp.put(index, n);
            pq.add(n, index);
            keys.put(index, key);
            swim(n);
        }

        private void swim(int n) {
            while (n > 1 && greater(n / 2, n)) {
                exchange(n / 2, n);
                n = n / 2;
            }
        }

        private boolean greater(int i, int j) {
            return keys.get(pq.get(i)).compareTo(keys.get(pq.get(j))) < 0;
        }

        private void exchange(int i, int j) {
            String temp = pq.get(i);
            pq.set(i, pq.get(j));
            pq.set(j, temp);
            qp.put(pq.get(i), i);
            qp.put(pq.get(j), j);
        }

        public String delMax() {
            if (n == 0) throw new NoSuchElementException("empty pq");
            String min = pq.get(1);
            exchange(1, n);
            n--;
            sink(1);
            qp.put(min, -1);
            keys.remove(min);
            pq.remove(n + 1);
            return min;
        }

        /**
         * If key for index does nt exist return -1
         *
         * @param index of priority queue
         * @return
         */
        public int keyOf(String index) {
            if (!contains(index))
                return -1;
            return keys.get(index);
        }

        public int rankFromTopK(String videoId) {
            int rank = 1;
            for (String index : topVideosMaxPQ.top()) {
                if (index.equals(videoId)) {
                    return rank;
                }
                rank++;
            }
            //the video is not in top viewed videos last in topk
            return topVideosMaxPQ.top().size();
        }

        public List<String> top() {
            IndexedMaxPQ copy = new IndexedMaxPQ();
            int min = Math.min(10, keys.size());
            for (int i = 1; i <= min; i++) {
                if(!pq.isEmpty()){
                    copy.add(pq.get(i), keys.get(pq.get(i)));
                }
            }
            List<String> top = new ArrayList<>();
            while (!copy.isEmpty()) {
                top.add(copy.delMax());
            }
            return top;
        }

        private void sink(int k) {
            while (2 * k <= n) {
                int j = 2 * k;
                if (j < n && greater(j, j + 1)) {
                    j++;
                }
                if (greater(j, k)) break;
                exchange(j, k);
                k = j;
            }
        }

        public void addOrIncreaseKey(String index) {
            if (keyOf(index) < 0) {
                add(index, 1);
            } else {
                increaseKey(index);
            }

        }


        public void deleteMin() {
            int smallest = Integer.MAX_VALUE;
            String smallestIndex = null;
            for (Map.Entry<String, Integer> entry : keys.entrySet()) {
                if (entry.getValue() < smallest) {
                    smallest = entry.getValue();
                    smallestIndex = entry.getKey();
                }
            }

            int index = qp.get(smallestIndex);
            exch(index, n--);
            swim(index);
            sink(index);
            keys.remove(smallestIndex);
            qp.remove(smallestIndex);
        }

        private void exch(int i, int j) {
            String swap = pq.get(i);
            pq.set(i, pq.get(j));
            pq.set(j, swap);
            qp.put(pq.get(i), i);
            qp.put(pq.get(j), j);
        }

        public void increaseKey(String index) {
            if (!contains(index)) throw new NoSuchElementException("index is not in the priority queue");
            Integer existing = keys.get(index);
            keys.put(index, existing + 1);
            swim(qp.get(index));
        }
    }

}
