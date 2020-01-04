package BitManipulation;

/**
 * @author jakadam on 2020-01-05
 */

/**
 * Given two numbers m and n. Find the position of the rightmost different bit in the
 * binary representation of numbers. It is guaranteed that such a bit exists.
 *
 * Examples :
 *
 * Input : m = 11, n = 9
 * Output : 2
 * (11)10 = (1011)2
 * (9)10 = (1001)2
 * It can be seen that 2nd bit from
 * the right is different
 *
 * Input : m = 52, n = 4
 * Output : 5
 * (52)10 = (110100)2
 * (4)10 = (100)2, can also be written as
 *      = (000100)2
 * It can be seen that 5th bit from
 * the right is different
 */
public class RightMostDifferentBit {
    /**
     * Get the bitwise xor of m and n. Let it be xor_value = m ^ n.
     * Now, find the position of rightmost set bit in xor_value.
     *
     * XOR gives 1 when bits differ and 0 when bits match
     */

    //this function is reused from RightMostSetBit.java
    public static int getRightMostSetBit(int num) {
        //if number is odd, right most bit is 1
        if(num%2==1)
            return 1;

        int position=1;
        int m=1;

        while((num & m)==0){
            m=m<<1;
            position++;
        }

        return position;
    }
    public static int getRightMostDiffBit(int m, int n) {
        return getRightMostSetBit(m^n);
    }

    public static void main(String[] args) {
        int m = 52, n = 4;
        System.out.print("Position = " + getRightMostDiffBit(m, n));
    }
}
