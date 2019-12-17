package Arrays;

import java.util.Arrays;

public class KthRowPascal {
        public static void main(String args[]) {
            //List<Integer> nums= Arrays.asList(3,1,2,5,3);
            int rows=5;
            final KthRowPascalSolver solver= new KthRowPascalSolver();
            solver.solve(rows);
            //System.out.println(solver.solve(nums)) ;
        }
}

class KthRowPascalSolver{
    public void solve(int rowNum){
        int A[] = new int[rowNum + 1];
        Arrays.fill(A, 0);
        A[0] = 1;
        System.out.println(Arrays.toString(A));
        for (int i = 1; i <= rowNum; i++) { //we have rowNum rows, hence execute outer for rowNum times
            for (int j = i; j > 0; j--) { //
                A[j] = A[j] + A[j - 1];
            }
            System.out.println(Arrays.toString(A));
        }

       System.out.println(Arrays.toString(A));
    }
}