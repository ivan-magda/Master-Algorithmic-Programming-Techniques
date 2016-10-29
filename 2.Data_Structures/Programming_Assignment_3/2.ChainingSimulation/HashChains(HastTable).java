import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HashChains {

    private static class HashTable {

        private static final int PRIME = 1000000007;
        private static final int MULTIPLIER = 263;

        static class Element {
            String key;
            Integer value;

            Element(String key, Integer value) {
                this.key = key;
                this.value = value;
            }
        }

        static class Bucket {
            ArrayList<Element> elements;

            Bucket(ArrayList<Element> elements) {
                this.elements = elements;
            }
        }

        Bucket[] buckets = null;
        private int count = 0;

        boolean isEmpty() {
            return count == 0;
        }

        HashTable(int capacity) {
            assert capacity > 0;
            buckets = new Bucket[capacity];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new Bucket(new ArrayList<>(capacity));
            }
        }

        private int indexForKey(String key) {
            return hashFunc(key);
        }

        private int hashFunc(String s) {
            long hash = 0;
            for (int i = s.length() - 1; i >= 0; --i)
                hash = (hash * MULTIPLIER + s.charAt(i)) % PRIME;
            return (int) Math.abs(hash) % buckets.length;
        }

        Element findElementForKey(String key) {
            int index = indexForKey(key);
            for (Element element : buckets[index].elements) {
                if (element.key.equals(key)) return element;
            }
            return null;
        }

        Integer valueForKey(String key) {
            Element element = findElementForKey(key);
            if (element != null)
                return element.value;
            return null;
        }

        void putValueForKey(Integer value, String key) {
            int index = indexForKey(key);
            Bucket bucket = buckets[index];
            for (int i = 0; i < bucket.elements.size(); i++) {
                Element currentElement = bucket.elements.get(i);
                if (currentElement.key.equals(key)) {
                    currentElement.value = value;
                    return;
                }
            }

            buckets[index].elements.add(0, new Element(key, value));
            count += 1;
        }

        void removeValueForKey(String key) {
            int index = indexForKey(key);
            Bucket bucket = buckets[index];
            for (int i = 0; i < bucket.elements.size(); i++) {
                Element currentElement = bucket.elements.get(i);
                if (currentElement.key.equals(key)) {
                    bucket.elements.remove(i);
                    count -= 1;
                    return;
                }
            }
        }

    }

    private FastScanner in = new FastScanner();
    private StringBuilder responseBuilder = new StringBuilder(100);
    private HashTable hashTable;

    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    }

    private void processQueries() throws IOException {
        int bucketCount = in.nextInt();
        hashTable = new HashTable(bucketCount);
        int queryCount = in.nextInt();

        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }

        System.out.print(responseBuilder.toString());
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String text = in.next();
            return new Query(type, text);
        } else {
            int index = in.nextInt();
            return new Query(type, index);
        }
    }

    private void processQuery(Query query) {
        switch (query.type) {
            case "add":
                hashTable.putValueForKey(1, query.text);
                break;
            case "del":
                hashTable.removeValueForKey(query.text);
                break;
            case "find":
                responseBuilder.append(hashTable.findElementForKey(query.text) == null ? "no" : "yes").append("\n");
                break;
            case "check":
                checkBucketAtIndex(query.index);
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    private void checkBucketAtIndex(int index) {
        HashTable.Bucket[] buckets = hashTable.buckets;
        if (index < 0 || index >= buckets.length) throw new IllegalArgumentException("Invalid bucket index");
        HashTable.Bucket bucket = buckets[index];
        if (bucket.elements.isEmpty()) {
            responseBuilder.append("\n");
        } else {
            String elementsString = "";
            for (HashTable.Element element : bucket.elements) elementsString += element.key + " ";
            responseBuilder.append(elementsString.trim()).append("\n");
        }
    }

    private static class Query {
        String type;
        String text;
        int index;

        Query(String type, String text) {
            this.type = type;
            this.text = text;
        }

        Query(String type, int index) {
            this.type = type;
            this.index = index;
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
