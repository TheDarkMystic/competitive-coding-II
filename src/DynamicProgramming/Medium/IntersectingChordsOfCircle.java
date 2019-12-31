package DynamicProgramming.Medium;

/**
 * @author jakadam on 2019-12-31
 */

/**
 * Given a number N, find the number of ways you can draw N chords in a circle with 2*N points
 * such that no 2 chords intersect.
 * Two ways are different if there exists a chord which is present in one way and not in other.
 *
 * Examples:
 *
 * Input : N = 2
 * Output : 2
 * Explanation: If points are numbered 1 to 4 in
 * clockwise direction, then different ways to
 * draw chords are:
 * {(1-2), (3-4)} and {(1-4), (2-3)}
 *
 *
 * Input : N = 1
 * Output : 1
 * Explanation: Draw a chord between points 1 and 2.
 */
public class IntersectingChordsOfCircle {
    public static void main(String[] args) {
        System.out.println(chordCnt(5));
    }

    public static int chordCnt(int A) {
        long[] dp = new long[A + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= A; i++) {

            for (int k = 0; k < i; k++) {
                dp[i] = (dp[i] + dp[k] * dp[i - 1 - k]) % 1000000007;
            }
        }

        return (int) dp[A];
    }

    /**
     * Think in terms of DP.
     * Can we relate answer for N with smaller answers.
     *
     * If we draw a chord between any two points, can you observe current set of points getting broken
     * into two smaller sets S_1 and S_2? Can a chord be drawn between two points where each point belong
     * to different set?
     *
     * If we draw a chord from a point in S_1 to a point in S_2, it will surely intersect the chord we’ve
     * just drawn.
     *
     * So, we can arrive at a recurrence that Ways(n) = sum[i = 0 to n-1] { Ways(i)*Ways(n-i-1) }.
     * Here we iterate over i, assuming that size of one of the sets is i and size of other set automatically
     * is (n-i-1) since we’ve already used a pair of points and i pair of points in one set.
     */
}
