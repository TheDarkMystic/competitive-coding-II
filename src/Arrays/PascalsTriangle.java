package Arrays;

import java.util.ArrayList;

public class PascalsTriangle {
    public static void main(String args[]){
        int numRows=5;
        ArrayList<ArrayList<Integer>> res ;
        PascalsTriangleSolver solver = new PascalsTriangleSolver();
        res=solver.solve(numRows);
        //print the pascal triangle
        for(int i=0; i<numRows; i++){
            for(int j=0; j<=i; j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println("\n");
        }
    }
}

class PascalsTriangleSolver{
    public ArrayList<ArrayList<Integer>> solve(int numRows){
        ArrayList<ArrayList<Integer>> res =new ArrayList<>();

        for(int i=0; i<numRows; i++){
            ArrayList<Integer> inner = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0||j==i){
                    inner.add(1);
                }else{
                    inner.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
            }
            res.add(inner);
        }
        return res;
    }
}
