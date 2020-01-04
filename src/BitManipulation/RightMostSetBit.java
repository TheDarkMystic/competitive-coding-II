package BitManipulation;

/**
 * @author jakadam on 2020-01-05
 */

/**
 * Write a one line function to return position of first 1 from right to left,
 * in binary representation of an Integer.
 *
 * I/P    18,   Binary Representation 010010
 * O/P   2
 * I/P    19,   Binary Representation 010011
 * O/P   1
 */
public class RightMostSetBit {
    /**
     * Using XOR and & operator :
     * Initialize m as 1 as check its XOR with the bits starting from the rightmost bit.
     * Left shift m by one till we find the first set bit, as the first set bit gives a
     * number when we perform a & operation with m.
     * @param num
     * @return
     */
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
    public static void main(String[] args) {
        System.out.println(getRightMostSetBit(20));
        System.out.println(getRightMostSetBit(16));
        System.out.println(getRightMostSetBit(15));
    }
}
/**
 *https://www.geeksforgeeks.org/position-of-rightmost-set-bit/
 */