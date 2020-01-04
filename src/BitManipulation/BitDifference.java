package BitManipulation;

/**
 * @author jakadam on 2020-01-05
 */

/**
 * Given two numbers ‘a’ and b’. Write a program to count number of bits needed to be
 * flipped to convert ‘a’ to ‘b’.
 * Example :
 *
 * Input : a = 10, b = 20
 * Output : 4
 * Binary representation of a is 00001010
 * Binary representation of b is 00010100
 * We need to flip highlighted four bits in a
 * to make it b.
 *
 * Input : a = 7, b = 10
 * Output : 3
 * Binary representation of a is 00000111
 * Binary representation of b is 00001010
 * We need to flip highlighted three bits in a
 * to make it b.
 */

class Count {
    /**
     * 1. Calculate XOR of A and B.
     * a_xor_b = A ^ B
     * 2. Count the set bits in the above
     * calculated XOR result.
     * countSetBits(a_xor_b)
     *
     * @param n
     * @return
     */

    // Function that count set bits
    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    // Function that return count of
    // flipped number
    public static int FlippedCount(int a, int b) {
        // Return count of set bits in
        // a XOR b
        return countSetBits(a ^ b);
    }

    // Driver code
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.print(FlippedCount(a, b));
    }
}