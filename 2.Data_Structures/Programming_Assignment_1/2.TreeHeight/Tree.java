import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tree implements Runnable {

    private static final int ROOT_INDEX = -1;

    private static class Node {
        int value;

        ArrayList<Node> childs = null;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root = null;

    private void addTo(Node parent, Node child) {
        if (parent.childs == null) parent.childs = new ArrayList<>(2);
        parent.childs.add(child);
    }

    private void addTo(Node parent, int value) {
        addTo(parent, new Node(value));
    }

    private static int height(Node node) {
        int levels = 0;

        if (node == null || node.childs == null || node.childs.size() == 0) return levels + 1;

        for (Node child : node.childs) {
            int childHeight = height(child);
            if (childHeight > levels) levels = childHeight;
        }

        return levels + 1;
    }

    public static void main(String[] args) throws IOException {
        new Thread(null, new Tree(), Tree.class.getSimpleName(), 1 << 26).start();
    }

    @Override
    public void run() {
        FastScanner in = new FastScanner();

        int vertices = in.nextInt();
        Node[] parents = new Node[vertices];

        // Build tree from user input.
        for (int i = 0; i < vertices; i++) {
            int parentVertex = in.nextInt();

            if (parentVertex == ROOT_INDEX) {
                if (parents[i] != null) {
                    root = parents[i];
                } else {
                    root = new Node(i);
                    parents[i] = root;
                }
                continue;
            }

            if (parents[parentVertex] == null) {
                Node parent = new Node(parentVertex);
                Node child;
                if (parents[i] == null) {
                    child = new Node(i);
                    parents[i] = child;
                } else {
                    child = parents[i];
                }
                addTo(parent, child);
                parents[parentVertex] = parent;
            } else {
                Node parent = parents[parentVertex];

                if (parents[i] != null) {
                    Node child = parents[i];
                    addTo(parent, child);
                } else {
                    Node child = new Node(i);
                    addTo(parent, child);
                    parents[i] = child;
                }
            }
        }

        System.out.println(height(root));
    }

    private static class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (!tok.hasMoreElements())
                try {
                    tok = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return tok.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
