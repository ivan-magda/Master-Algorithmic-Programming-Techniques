import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PhoneBook {

    private FastScanner in = new FastScanner();
    private HashMap<Integer, String> contacts;
    private StringBuilder response = new StringBuilder();

    public static void main(String[] args) {
        new PhoneBook().processQueries();
    }

    private void processQueries() {
        int queryCount = in.nextInt();
        contacts = new HashMap<>(queryCount / 2);
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
                contacts.put(query.number, query.name);
                break;
            case "del":
                contacts.remove(query.number);
                break;
            default:
                String response = "not found";
                String name = contacts.get(query.number);
                if (name != null) response = name;
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
