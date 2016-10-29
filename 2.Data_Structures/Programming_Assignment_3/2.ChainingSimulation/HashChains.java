import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HashChains {

    private static final int PRIME = 1000000007;
    private static final int MULTIPLIER = 263;

    private FastScanner in;
    private StringBuilder responseBuilder = new StringBuilder(100);

    private int bucketCount;
    private ArrayList<ArrayList<String>> buckets;

    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    }

    private int indexForKey(String key) {
        return hashFunc(key);
    }

    private int hashFunc(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = (hash * MULTIPLIER + s.charAt(i)) % PRIME;
        return (int) Math.abs(hash) % bucketCount;
    }

    private void processQueries() throws IOException {
        in = new FastScanner();

        bucketCount = in.nextInt();
        buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++)
            buckets.add(new ArrayList<>(3));

        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i)
            processQuery(readQuery());

        System.out.print(responseBuilder.toString());
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    private void processQuery(Query query) {
        switch (query.type) {
            case "add":
                addValue(query.s);
                break;
            case "del":
                removeValue(query.s);
                break;
            case "find":
                responseBuilder.append(findValue(query.s) ? "yes" : "no").append("\n");
                break;
            case "check":
                checkBucketAtIndex(query.ind);
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    private ArrayList<String> bucketForValue(String value) {
        int index = indexForKey(value);
        return buckets.get(index);
    }

    private void addValue(String value) {
        ArrayList<String> bucket = bucketForValue(value);
        if (!bucket.contains(value)) bucket.add(0, value);
    }

    private void removeValue(String value) {
        ArrayList<String> bucket = bucketForValue(value);
        if (bucket.contains(value)) bucket.remove(value);
    }

    private boolean findValue(String value) {
        ArrayList<String> bucket = bucketForValue(value);
        return bucket.contains(value);
    }

    private void checkBucketAtIndex(int index) {
        if (index < 0 || index >= buckets.size()) throw new IllegalArgumentException("Invalid bucket index");
        ArrayList<String> bucket = buckets.get(index);
        if (bucket.isEmpty()) {
            responseBuilder.append("\n");
        } else {
            String elementsString = "";
            for (String item : bucket) elementsString += item + " ";
            responseBuilder.append(elementsString.trim()).append("\n");
        }
    }

    private static class Query {
        String type;
        String s;
        int ind;

        Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
        }
    }

    private static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

