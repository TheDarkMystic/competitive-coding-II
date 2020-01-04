package BitManipulation;

/**
 * @author jakadam on 2020-01-05
 */

/**
 * Given a number n, check if k-th bit of n is set or not.
 *
 * Examples:
 *
 * Input : n = 5, k = 1
 * Output : SET
 * 5 is represented as 101 in binary
 * and has its first bit set.
 *
 * Input : n = 2, k = 3
 * Output : NOT SET
 * 2 is represented as 10 in binary,
 * all higher i.e. beyond MSB,
 * bits are NOT SET.
 */
public class CheckKthBitSetOrNot {
    /**
     * 1) Left shift given number 1 by k-1 to create
     * a number that has only set bit as k-th bit.
     * temp = 1 << (k-1)
     * 2) If bitwise AND of n and temp is non-zero,
     * then result is SET else result is NOT SET.
     *
     * @param n
     * @param k
     * @return
     */
    public static String isKthBitSet1(int n, int k) {
        int temp = (1 << (k - 1));

        if ((n & temp) == 1)
            return "SET";
        else
            return "NOT SET";
    }

    /**
     * If we right shift n by k-1, we get last bit as 1 if k-th bit is set else 0.
     *
     * @param n
     * @param k
     * @return
     */
    public static String isKthBitSet2(int n, int k) {
        int temp = n >> (k - 1);
        if ((temp & 1) == 1)
            return "SET";
        else
            return "NOT SET";
    }

    public static void main(String[] args) {
        int n = 5, k = 1;
        System.out.println(isKthBitSet1(n, k));
        System.out.println(isKthBitSet2(n, k));
    }
}
