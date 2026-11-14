package string.assignment_problems12;


public class ScoreBandCounter {

    static int lowerBound(int[] scores, int x) {

        int low = 0;
        int high = scores.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (scores[mid] < x)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    static void query(int[] scores, int x) {

        int below = lowerBound(scores, x);

        int exactly =
                lowerBound(scores, x + 1)
                        - lowerBound(scores, x);

        System.out.println(
                x + ": exactly " + exactly +
                        ", below " + below);
    }
}