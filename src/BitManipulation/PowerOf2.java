package BitManipulation;

/**
 * @author jakadam on 2020-01-05
 */
public class PowerOf2 {



    /**
     * If we subtract a power of 2 numbers by 1 then all unset bits after the only set bit
     * become set; and the set bit become unset.
     *
     * For example for 4 ( 100) and 16(10000), we get following after subtracting 1
     * 3 –> 011
     * 15 –> 01111
     * @param x
     * @return
     */
    static boolean isPowerOfTwo1 (int x)
    {
      /* First x in the below expression is
        for the case when x is 0 */
        return x!=0 && ((x&(x-1)) == 0);

    }

    /**
     * keep dividing the number by two, i.e, do n = n/2 iteratively. In any iteration,
     * if n%2 becomes non-zero and n is not 1 then n is not a power of 2. If n becomes 1
     * then it is a power of 2.
     * @param n
     * @return
     */
    static boolean isPowerOfTwo2(int n)
    {
        if (n == 0)
            return false;

        while (n != 1)
        {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }

    // Driver method
    public static void main(String[] args)
    {
        System.out.println(isPowerOfTwo1(31) ? "Yes" : "No");
        System.out.println(isPowerOfTwo1(64) ? "Yes" : "No");

        System.out.println(isPowerOfTwo2(31) ? "Yes" : "No");
        System.out.println(isPowerOfTwo2(64) ? "Yes" : "No");

    }
}
