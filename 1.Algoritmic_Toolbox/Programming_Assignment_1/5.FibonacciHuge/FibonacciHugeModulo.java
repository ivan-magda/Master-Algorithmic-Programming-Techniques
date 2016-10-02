import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciHugeModulo {

    private static class PisanoSequence {
        int length;
        ArrayList<Integer> remainders;

        private PisanoSequence() {
            this.length = 0;
            this.remainders = new ArrayList<>();
        }

        private static PisanoSequence sequenceDataForModule(int m) {
            PisanoSequence sequence = new PisanoSequence();
            sequence.remainders.add(0);
            sequence.remainders.add(1);
            sequence.length = 2;

            for (
                    int fn2 = 1, fn1 = 2 % m, fn = 3 % m;
                    fn1 != 1 || fn != 1;
                    fn2 = fn1, fn1 = fn, fn = (fn1 + fn2) % m
                    ) {
                sequence.remainders.add(fn2);
                sequence.length++;
            }

            return sequence;
        }
    }

    private static long getFibonacciNumber(long n) {
        if (n <= 1) return n;

        long previous = 0;
        long current = 1;

        for (int i = 0; i < n - 1; ++i) {
            long tmp = previous;
            previous = current;
            current = tmp + previous;
        }

        return current;
    }

    private static long getFibonacciHugeNaive(long n, long m) {
        return getFibonacciNumber(n) % m;
    }

    private static long getFibonacciHugeFast(long n, int m) {
        PisanoSequence pisanoSequence = PisanoSequence.sequenceDataForModule(m);
        int remainder = Math.toIntExact(n % pisanoSequence.length);

        return pisanoSequence.remainders.get(remainder);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long number = scanner.nextLong();
        int module = scanner.nextInt();

        System.out.println(getFibonacciHugeFast(number, module));
    }

}
