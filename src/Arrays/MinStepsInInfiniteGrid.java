package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jakadam on 2020-01-05
 */

/**
 * ou are in an infinite 2D grid where you can move in any of the 8 directions :
 *
 *     (x,y) to
 *     (x+1, y),
 *     (x - 1, y),
 *     (x, y+1),
 *     (x, y-1),
 *     (x-1, y-1),
 *     (x+1,y+1),
 *     (x-1,y+1),
 *     (x+1,y-1)
 * You are given a sequence of points and the order in which you need to cover the points.
 * Give the minimum number of steps in which you can achieve it. You start from the first point.
 *
 * Input :
 *
 * Given two integer arrays A and B, where A[i] is x coordinate and B[i]
 * is y coordinate of ith point respectively.
 * Output :
 *
 * Return an Integer, i.e minimum number of steps.
 * Example :
 *
 * Input : [(0, 0), (1, 1), (1, 2)]
 * Output : 2
 * It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 *
 * This question is intentionally left slightly vague. Clarify the question by trying out a few
 * cases in the “See Expected Output” section.
 */

public class MinStepsInInfiniteGrid {
    /**
     * **As we have to cover all the given points in the specified order, if we can find
     * the minimum number of steps required to reach from a starting point to next point,
     * the sum of all such minimum steps for covering all the points would be our answer.
     *
     * One way to reach form a point (x1,y1) to (x2, y2) is to move abs(x2-x1)
     * steps in horizontal direction and abs(y2-y1) steps in vertical direction,
     * but this is not the shortest path to reach (x2,y2). The best way would be to
     * cover the maximum possible distance in diagonal direction and remaining in
     * horizontal or vertical direction. If we look closely this just reduces to
     * maximum of abs(x2-x1) and abs(y2-y1).
     *
     * Example
     * x1 = 5, y1= 20
     * x2 = 15, y2 = 15
     *
     * we first move diagonally to reach (10,15) this takes 5 steps and then we
     * move 5 units in x direction, which again takes 5 steps. In total this is 10
     * steps which is equal to MAX(abs(15-5), abs(15-20))
     **/

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(coverPoints(A, B));
    }

    public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int result = 0;
        int lenA = A.size();
        int lenB = B.size();

        if (lenA <= 1)
            return 0;
        assert lenA == lenB : "Given Points NOT Correct!";

        for (int i = 0; i < lenA - 1; i++) {
            result += Math.max(
                    Math.abs(A.get(i) - A.get(i + 1)),
                    Math.abs(B.get(i) - B.get(i + 1))
            );
        }

        return result;
    }
}
