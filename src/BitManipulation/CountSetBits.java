package BitManipulation;

/**
 * @author jakadam on 2020-01-05
 */

/**
 * Write an efficient program to count number of 1s in binary representation of an integer.
 *
 * Examples :
 *
 * Input : n = 6
 * Output : 2
 * Binary representation of 6 is 110 and has 2 set bits
 *
 * Input : n = 13
 * Output : 3
 * Binary representation of 13 is 1101 and has 3 set bits
 */

class countSetBits {
    /* Function to get no of set
    bits in binary representation
    of positive integer n */

    /**
     * Loop through all bits in an integer, check if a bit is set and if it is then
     * increment the set bit count. See below program.
     * @param n
     * @return
     */
    static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    // driver program
    public static void main(String args[])
    {
        int i = 9;
        System.out.println(countSetBits(i));
    }
}

// This code is contributed by Anshika Goyal.
