import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Bracket {

    private char type;
    private int position;

    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    boolean match(char c) {
        return (this.type == '[' && c == ']' ||
                this.type == '{' && c == '}' ||
                this.type == '(' && c == ')'
        );
    }

    static boolean isStarting(char c) {
        return (c == '(' || c == '[' || c == '{');
    }

    static boolean isClosing(char c) {
        return (c == ')' || c == ']' || c == '}');
    }

}

public class CheckBrackets {

    /**
     * @param line - Input line to process.
     * @return 0 on success and greater then 0 position index on failure.
     */
    private static int isBalanced(String line) {
        final int success = 0;

        Stack<Bracket> stack = new Stack<>();

        for (int position = 0; position < line.length(); ++position) {
            char character = line.charAt(position);

            if (Bracket.isStarting(character)) stack.push(new Bracket(character, position));

            if (Bracket.isClosing(character)) {
                if (stack.isEmpty()) {
                    return position + 1;
                }

                Bracket top = stack.pop();
                if (!top.match(character)) {
                    return position + 1;
                }
            }
        }

        if (stack.isEmpty()) {
            return success;
        } else {
            Bracket top = stack.pop();
            return top.getPosition() + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        String text = reader.readLine();

        int isBalanced = isBalanced(text);
        System.out.println(isBalanced == 0 ? "Success" : isBalanced);
    }

}
