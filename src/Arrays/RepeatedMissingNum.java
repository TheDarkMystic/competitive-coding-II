package Arrays;

import java.util.Arrays;
import java.util.List;

/*
There are certain problems which are asked in the interview to also check how you take care of overflows in your problem.
This is one of those problems.
Please take extra care to make sure that you are type-casting your ints to long properly and at all places. Try to verify if your solution works if number of elements is as large as 105

Food for thought :
Even though it might not be required in this problem, in some cases, you might be required to order the operations cleverly so that the numbers do not overflow.
For example, if you need to calculate n! / k! where n! is factorial(n), one approach is to calculate factorial(n), factorial(k) and then divide them.
Another approach is to only multiple numbers from k + 1 ... n to calculate the result.
Obviously approach 1 is more susceptible to overflows.
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3]

Output:[3, 4]

A = 3, B = 4
 */
public class RepeatedMissingNum {
    public static void main(String args[]) {
        List<Integer> nums= Arrays.asList(3,1,2,5,3);
        final RepeatedMissingNumSolver solver= new RepeatedMissingNumSolver();
        solver.solve(nums);
        //System.out.println(solver.solve(nums)) ;
    }

}

class RepeatedMissingNumSolver{
    public void solve(final List<Integer> nums){
        long n =nums.size();

        //(A+A+C+D) -> Given seq sum
        long givenSum=0;
        for(int num:nums)
            givenSum+=(long)num;

        //(A+B+C+D) -> Actual seq sum
        long actualSum= (long)(n*(n+1)/2);

        //(A-B)
        long aSubB=givenSum-actualSum;

        //(A2+A2+C2+D2)-> Given seq sum
        long givenSumSq=0;
        for(int num:nums)
            givenSumSq+=(long)num*(long)num;

        //(A2+B2+C2+D2)-> Actual seq sum
        long actualSumSq= (long)(n*(n+1)*(2*n+1)/6);

        //A2-B2 =>(A+B)(A-B)
        long a2SubB2=givenSumSq-actualSumSq;

        //(A+B)=((A+B)(A-B)/(A-B))
        long aPlusB=a2SubB2/aSubB;

        //A=((A+B)+(A-B))/2
        int a=(int)((aPlusB+aSubB)/2);
        // B=((A+B)-(A-B))/2
        int b=(int)((aPlusB-aSubB)/2);
        System.out.println("a="+a);
        System.out.println("b="+b);
    }
}
/*
        (A+A+C+D) -> Given seq sum
       -(A+B+C+D) -> Actual seq sum
       =(A-B)

        (A2+A2+C2+D2)-> Given seq sum
       -(A2+B2+C2+D2)-> Actual seq sum
       =A2-B2 =>(A+B)(A-B)

        (A+B)=((A+B)(A-B)/(A-B))

        Now, we have (A+B) and (A-B)
        A=((A+B)+(A-B))/2
        B=((A+B)-(A-B))/2
 */