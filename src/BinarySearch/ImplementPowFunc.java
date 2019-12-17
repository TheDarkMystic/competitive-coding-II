package BinarySearch;

/*
Implement pow(x, n) % d.
In other words, given x, n and d,
find (xn % d)
Note that remainders on division cannot be negative.
In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2
2^3 % 3 = 8 % 3 = 2.

Case 2: (remainders on division cannot be negative)
A : -1
B : 1
C : 20
Answer: 19
 */
public class ImplementPowFunc {

    public static void main(String args[]) {
        final ImplementPowFuncSolver solver = new ImplementPowFuncSolver();
        System.out.println(solver.solve(2, 3, 3));
        System.out.println(solver.solve(-1, 1, 20));
    }
}

class ImplementPowFuncSolver {
    public long solve(int x, int r, int d) {
        // We need (base ** n) % p.
        // Now there are 2 cases.
        // 1) n is even. Then we can make base = base^2 and n = n / 2.
        // 2) n is odd. So we need base * base^(n-1)

        /*
        There are two major things to note here:

        1) Overflow situation: Note that if x is large enough, multiplying x to the answer might overflow in integer.

        2) Multiplying x one by one to the answer is O(n). We are looking for something better than O(n).

        If n is even, note the following:

        x ^ n = (x * x) ^ n/2

        Can you use the above observation to come up with a solution better than O(n)?
         */

        int base = x;
        int pow = r;
        int div = d;
        long ans = 1;
        while (pow > 0) {
            if (pow % 2 == 0) {
                base = (base * base) % div;
                pow = pow / 2;
            } else {
                ans = (ans * base) % div;
                pow--;
            }
        }

        if (ans < 0)
            ans = (ans + div) % div;

        return ans;
    }
}