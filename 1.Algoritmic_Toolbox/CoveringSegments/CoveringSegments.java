import java.util.LinkedHashSet;
import java.util.Scanner;

public class CoveringSegments {

    private static void bubbleSort(Segment[] toSort) {
        int length = toSort.length;
        Segment temp;

        for (int i = 0; i < length; ++i) {
            for (int current = 1, before = 0; current < (length - i); ++current, before = current - 1) {
                if (toSort[before].end > toSort[current].end) {
                    temp = toSort[current];
                    toSort[current] = toSort[before];
                    toSort[before] = temp;
                }
            }
        }
    }

    private static Integer[] optimalPoints(Segment[] segments) {
        bubbleSort(segments);

        LinkedHashSet<Integer> points = new LinkedHashSet<>(segments.length);

        for (int i = 0; i < segments.length; ++i) {
            Segment minSegment = segments[i];

            int next = i + 1;
            if (next < segments.length && minSegment.isCover(segments[next])) {
                for (int j = i + 1; j < segments.length && minSegment.isCover(segments[j]); ++j) {
                    points.add(minSegment.end);
                    i = j;
                }
            } else {
                points.add(minSegment.end);
            }
        }

        return points.toArray(new Integer[points.size()]);
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean isCover(Segment other) {
            return this.end >= other.start;
        }

        boolean isZeroLength() {
            return start == end;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }

        Integer[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (Integer point : points) {
            System.out.print(point + " ");
        }
    }

}
