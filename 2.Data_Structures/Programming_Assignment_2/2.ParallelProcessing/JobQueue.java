import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JobQueue {

    private int numWorkers;
    private int[] jobs;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        readData();
        assignJobs();

        out.close();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i)
            jobs[i] = in.nextInt();
    }

    private void assignJobs() {
        PriorityQueue<Worker> priorityQueue = new PriorityQueue<>(numWorkers, (lhs, rhs) -> {
            if (lhs.startTime < rhs.startTime) return -1;
            if (lhs.startTime > rhs.startTime) return 1;
            if (lhs.startTime == rhs.startTime) {
                if (lhs.index < rhs.index) return -1;
                if (lhs.index > rhs.index) return 1;
                return 0;
            }
            return 0;
        });

        for (int i = 0; i < numWorkers; i++)
            priorityQueue.add(new Worker(i, 0));

        for (int job : jobs) {
            Worker worker = priorityQueue.poll();
            out.println(worker.index + " " + worker.startTime);
            priorityQueue.add(new Worker(worker.index, worker.startTime + job));
        }
    }

    private static class Worker {
        int index;
        long startTime;

        public Worker(int index, long startTime) {
            this.index = index;
            this.startTime = startTime;
        }

        @Override
        public String toString() {
            return "Worker{" +
                    "index=" + index +
                    ", startTime=" + startTime +
                    '}';
        }
    }

    private static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
