import java.util.*;

public class FibonacciLastDigit {
	
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int[] lastDigits = new int[n + 1];
        lastDigits[0] = 0;
		lastDigits[1] = 1;

        for (int i = 2; i < lastDigits.length; ++i) {
			lastDigits[i] = (lastDigits[i - 1] + lastDigits[i - 2]) % 10;
        }

        return lastDigits[n];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
	
}

