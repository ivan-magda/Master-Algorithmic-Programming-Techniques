import java.util.Scanner;

public class APlusB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        try {
            verify(a, b);
            System.out.println(a + b);
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }

    private static void verify(int a, int b) throws Exception {
        if (a < 0 || b > 9) { throw new Exception("Out of range constraints."); }
    }

}
