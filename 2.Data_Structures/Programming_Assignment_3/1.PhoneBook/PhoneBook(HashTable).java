import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PhoneBook {

    private static class HashTable {

        static class Element {
            Integer key;
            String value;

            Element(Integer key, String value) {
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

        private int indexForKey(Integer key) {
            return hashFunc(key);
        }

        private int hashFunc(Integer i) {
            return Math.abs(i.hashCode()) % buckets.length;
        }

        Element findElementForKey(Integer key) {
            int index = indexForKey(key);
            for (Element element : buckets[index].elements) {
                if (element.key.intValue() == key) return element;
            }
            return null;
        }

        String valueForKey(Integer key) {
            Element element = findElementForKey(key);
            if (element != null)
                return element.value;
            return null;
        }

        void putValueForKey(Integer key, String value) {
            int index = indexForKey(key);
            Bucket bucket = buckets[index];
            for (int i = 0; i < bucket.elements.size(); i++) {
                Element currentElement = bucket.elements.get(i);
                if (currentElement.key.intValue() == key) {
                    currentElement.value = value;
                    return;
                }
            }

            buckets[index].elements.add(0, new Element(key, value));
            count += 1;
        }

        void removeValueForKey(Integer key) {
            int index = indexForKey(key);
            Bucket bucket = buckets[index];
            for (int i = 0; i < bucket.elements.size(); i++) {
                Element currentElement = bucket.elements.get(i);
                if (currentElement.key.intValue() == key) {
                    bucket.elements.remove(i);
                    count -= 1;
                    return;
                }
            }
        }

    }

    private FastScanner in = new FastScanner();
    private HashTable contacts;
    private StringBuilder response = new StringBuilder();

    public static void main(String[] args) {
        new PhoneBook().processQueries();
    }

    private void processQueries() {
        int queryCount = in.nextInt();
        contacts = new HashTable(queryCount / 2);
        for (int i = 0; i < queryCount; ++i)
            processQuery(readQuery());

        System.out.println(response.toString().trim());
    }

    private Query readQuery() {
        String type = in.next();
        int number = in.nextInt();
        if (type.equals("add")) {
            String name = in.next();
            return new Query(type, name, number);
        } else {
            return new Query(type, number);
        }
    }

    private void writeResponse(String response) {
        this.response.append(response).append("\n");
    }

    private void processQuery(Query query) {
        switch (query.type) {
            case "add":
                contacts.putValueForKey(query.number, query.name);
                break;
            case "del":
                contacts.removeValueForKey(query.number);
                break;
            default:
                String response = "not found";
                HashTable.Element element = contacts.findElementForKey(query.number);
                if (element != null) response = element.value;
                writeResponse(response);
                break;
        }
    }

    private static class Query {
        String type;
        String name;
        int number;

        Query(String type, String name, int number) {
            this.type = type;
            this.name = name;
            this.number = number;
        }

        Query(String type, int number) {
            this.type = type;
            this.number = number;
        }
    }

    private class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
